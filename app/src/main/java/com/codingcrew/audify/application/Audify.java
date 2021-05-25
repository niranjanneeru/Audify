package com.codingcrew.audify.application;

import android.app.Application;

import com.facebook.soloader.SoLoader;

public class Audify extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
    }
}
