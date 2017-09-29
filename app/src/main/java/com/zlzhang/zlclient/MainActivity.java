package com.zlzhang.zlclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;

import com.zlzhang.client.action.TestGetAction;
import com.zlzhang.client.action.TestPostAction;
import com.zlzhang.client.handler.ActionHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        testGet();
        testPost();
    }

    private void testGet(){
        TestGetAction testAction = new TestGetAction();
        List<Pair> pairs = new ArrayList<>();
        Pair pair1 = new Pair<>("service", "movie");
        Pair pair2 = new Pair<>("location", "116.481590,39.989175");
        Pair pair3 = new Pair<>("city", "110000");
        Pair pair4 = new Pair<>("src", "mypage");
        Pair pair5 = new Pair<>("coordinate", "gaode");
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        pairs.add(pair4);
        pairs.add(pair5);
        testAction.setParam(pairs);
        testAction.execute(true, new ActionHandler() {
            @Override
            public void doActionStart() {
                Log.d("test", "test doActionStart");
            }

            @Override
            public void doActionEnd() {
                Log.d("test", "test doActionEnd");
            }

            @Override
            public void doActionResponse(int status, String message, Serializable result) {
                Log.d("test", "test doActionResponse" + status + message + result);
            }

            @Override
            public void doActionRawData(String data, String dataFile) {
                Log.d("test", "test doActionRawData" + data + dataFile);
            }
        });
    }

    private void testPost() {
        TestPostAction postAction = new TestPostAction();
        List<Pair> pairs = new ArrayList<>();
        Pair pair1 = new Pair<>("service", "movie");
        Pair pair2 = new Pair<>("location", "116.481590,39.989175");
        Pair pair3 = new Pair<>("city", "110000");
        Pair pair4 = new Pair<>("src", "mypage");
        Pair pair5 = new Pair<>("coordinate", "gaode");
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        pairs.add(pair4);
        pairs.add(pair5);
        postAction.setParam(pairs);
        postAction.execute(true, new ActionHandler() {
            @Override
            public void doActionStart() {

            }

            @Override
            public void doActionEnd() {

            }

            @Override
            public void doActionResponse(int status, String message, Serializable result) {
                Log.d("test", "test doActionResponse" + status + message + result);
            }

            @Override
            public void doActionRawData(String data, String dataFile) {

            }
        });
    }
}
