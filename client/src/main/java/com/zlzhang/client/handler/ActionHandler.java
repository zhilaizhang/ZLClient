package com.zlzhang.client.handler;

import java.io.Serializable;

/**
 * Created by zhilaizhang on 17/9/29.
 */

public interface ActionHandler {
    void doActionStart();

    void doActionEnd();

    void doActionResponse(int status, String message, Serializable result);

    void doActionRawData(String data, String dataFile);
}
