package com.saif.flickertask;

import android.app.Application;


public class FlickerApplication extends Application {

    private static FlickerApplication instance;
    private Thread.UncaughtExceptionHandler defaultUEH;

    public static FlickerApplication get() {
        if (instance == null)
            throw new IllegalStateException("Application instance has not been initialized!");
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }



}
