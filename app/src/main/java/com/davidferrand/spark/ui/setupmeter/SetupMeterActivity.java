package com.davidferrand.spark.ui.setupmeter;

import android.app.Activity;
import android.content.Intent;

import com.davidferrand.spark.data.FuelType;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

public class SetupMeterActivity extends RxAppCompatActivity {
    private static final String ARG_FUEL_TYPE = "fuelType";

    public static void start(Activity parent, FuelType fuelType) {
        Intent i = new Intent(parent, SetupMeterActivity.class);
        i.putExtra(ARG_FUEL_TYPE, fuelType.name());

        parent.startActivity(i);
    }
}
