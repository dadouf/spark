package com.davidferrand.spark.app;

import android.app.Application;

import com.davidferrand.spark.data.FuelType;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SparkApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FuelType.ResourceCache.init(this);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
