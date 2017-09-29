package com.zlzhang.client.action;

import android.util.Pair;

import com.zlzhang.client.base.BasePostAction;

import java.util.List;

import okhttp3.Response;

/**
 * Created by zhilaizhang on 17/9/29.
 */

public class TestPostAction extends BasePostAction {
    private static final String URL = "/getLastVersion";

    public TestPostAction() {
        super(URL);
    }

    @Override
    public void setParam(List<Pair> params) {
        mParams = params;
    }

    @Override
    protected void doResponse(Response response) {

    }
}
