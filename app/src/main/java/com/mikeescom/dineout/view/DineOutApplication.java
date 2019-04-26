package com.mikeescom.dineout.view;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class DineOutApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
