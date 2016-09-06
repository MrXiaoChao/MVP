package com.example.john.mvp.Application;

import android.app.Application;
import android.content.Context;

/**
 * Created by john on 2016/7/8.
 */
public class MyApplication extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }
    public static Context getContext() {
        return sContext;
    }
}

