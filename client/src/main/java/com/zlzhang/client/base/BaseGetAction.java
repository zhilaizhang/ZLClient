package com.zlzhang.client.base;

import android.util.Pair;

import okhttp3.Request;

/**
 * Created by zhilaizhang on 17/9/29.
 */

public abstract class BaseGetAction extends BaseAction {

    public BaseGetAction(String url) {
        super(url);
        this.sURL = URL_TEST  + url;
    }

    @Override
    protected void initRequest() {
        String url = linkUrl();
        mRequest = new Request.Builder()
                .url(url)
                .build();
    }

    private String linkUrl() {
        if (mParams == null) {
            return sURL;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sb);
        sb.append(sURL);
        sb.append("?");
        int len = mParams.size();
        for(int i = 0; i < len; i++){
            Pair nameValuePair = mParams.get(i);
            sb.append(nameValuePair.first);
            sb.append("=");
            sb.append(nameValuePair.second);
            if(i != len - 1){
                sb.append("&");
            }
        }
        return sb.toString();
    }
}
