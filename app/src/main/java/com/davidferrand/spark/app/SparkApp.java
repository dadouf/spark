package com.davidferrand.spark.app;

import android.app.Application;

import com.davidferrand.spark.data.FuelType;

public class SparkApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FuelType.ResourceCache.init(this);
    }
}
