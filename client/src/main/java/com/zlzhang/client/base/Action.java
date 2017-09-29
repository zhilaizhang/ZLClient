package com.zlzhang.client.base;

import java.io.Serializable;

/**
 * Created by zhilaizhang on 17/9/29.
 */

public class Action implements Serializable {
    public final static int STATUS_SUCCESS          = 0;
    public final static int STATUS_FAILED           = -1;
    public final static int STATUS_NET_ERROR        = -100;
    public final static int STATUS_IO_ERROR         = -101;
    public final static int STATUS_ENCODE_ERROR     = -102;
    public final static int STATUS_RESPONSE_FAILED  = -103;
    public final static int STATUS_CONNECT_TIME_OUT = -104;
    public final static int STATUS_SOCKET_TIME_OUT  = -105;

    public Action(){

    }

    public static final String URL_TEST   = "http://uri.amap.com";

    private int s;
    private String       m;
    private String       d;
    private String       t;
    private Serializable result;

    public Serializable getResult() {
        return result;
    }

    public void setResult(Serializable result) {
        this.result = result;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
}
