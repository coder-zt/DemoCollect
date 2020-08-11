package com.example.democollect.base;

import android.app.Application;
import android.content.Context;

public class DemoApplication extends Application {
    private static Context sContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContextInstance(){
        return sContext;
    }
}
