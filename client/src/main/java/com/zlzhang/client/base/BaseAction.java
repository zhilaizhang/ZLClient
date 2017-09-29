package com.zlzhang.client.base;

import android.os.Bundle;
import android.os.Message;
import android.os.NetworkOnMainThreadException;
import android.util.Pair;

import com.zlzhang.client.handler.ActionHandler;
import com.zlzhang.client.handler.AsyncActionHandler;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Call;
import okhttp3.Callback;

/**
 * Created by zhilaizhang on 17/9/29.
 */

public abstract class BaseAction extends Action {
    protected ActionHandler mActionHandler;
    protected AsyncActionHandler mAsyncActionHandler;
    protected boolean isAsync;

    private OkHttpClient mOkHttpClient;
    protected Request mRequest;
    protected List<Pair> mParams;

    protected String sURL;

    public BaseAction(String url){
        sURL = url;
    }

    public void execute(boolean isAsync, ActionHandler actionHandler){
        this.isAsync = isAsync;
        mActionHandler = actionHandler;
        mOkHttpClient = new OkHttpClient();
        initRequest();
        if (isAsync) {
            executeAsync();
        } else {
            executeSync();
        }
    }

    public abstract void setParam(List<Pair> params);

    protected abstract void initRequest();

    private void executeSync(){
        Call call = mOkHttpClient.newCall(mRequest);
        try {
            Response response = call.execute();
            doResponse(response);
            handleResponse();
        } catch (IOException e) {
            e.printStackTrace();
            handleException(e, STATUS_IO_ERROR);
        } catch(NetworkOnMainThreadException e){
            handleException(e, STATUS_FAILED);
        }
    }

    private void executeAsync(){
        mAsyncActionHandler = new AsyncActionHandler();
        mAsyncActionHandler.setActionHandler(mActionHandler);
        Call call = mOkHttpClient.newCall(mRequest);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                handleException(e, STATUS_IO_ERROR);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                doResponse(response);
                handleResponse();
            }
        });
    }

    protected abstract void doResponse(Response response);

    protected abstract void doException(Exception exception, int errCode);

    private void handleException(Exception exception, int errCode){
        doException(exception, errCode);
        handleResponse();
    }

    private void handleResponse(){
        if (isAsync) {
            Message message = new Message();
            Bundle data = new Bundle();
            data.putInt(AsyncActionHandler.ACTION_STATUS, getS());
            data.putString(AsyncActionHandler.ACTION_DATA, getD());
            data.putString(AsyncActionHandler.ACTION_MESSAGE, getM());
            data.putSerializable(AsyncActionHandler.ACTION_RESULT, getResult());
            mAsyncActionHandler.sendMessage(message);
        } else {
            mActionHandler.doActionRawData(getD(), getM());
            mActionHandler.doActionResponse(getS(), getM(), getResult());
        }
    }
}
