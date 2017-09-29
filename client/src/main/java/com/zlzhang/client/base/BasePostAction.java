package com.zlzhang.client.base;

import android.util.Pair;

import java.util.List;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by zhilaizhang on 17/9/29.
 */

public abstract class BasePostAction extends BaseAction {
    public BasePostAction(String url) {
        super(url);
        this.sURL = URL_TEST + url;
    }

    @Override
    protected void initRequest() {
        RequestBody body = initBody();
        mRequest = new Request.Builder()
                .url(sURL)
                .post(body)
                .build();
    }

    protected RequestBody initBody() {
        if (mParams != null) {
            FormBody.Builder builder = new FormBody.Builder();
            for (Pair<String, String> param : mParams) {
                builder.add(param.first, (param.second));
            }
            return builder.build();
        }
        return new FormBody.Builder()
                .build();
    }


    @Override
    protected void doException(Exception exception, int errCode) {

    }
}
