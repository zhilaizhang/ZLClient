package com.zlzhang.client.action;

import android.util.Log;
import android.util.Pair;

import com.zlzhang.client.base.BaseGetAction;

import java.util.List;

import okhttp3.Response;

/**
 * Created by zhilaizhang on 17/9/29.
 */

public class TestGetAction extends BaseGetAction {
    private static final String URL = "";

    public TestGetAction() {
        super(URL);
    }

    @Override
    public void setParam(List<Pair> params) {
        mParams = params;
    }

    @Override
    protected void doResponse(Response response) {
        Log.d("test", "test "+ response.toString());
    }

    @Override
    protected void doException(Exception exception, int errCode) {

    }
}
