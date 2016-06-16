package com.davidferrand.spark.ui.addreading;

import android.app.Activity;
import android.content.Intent;

import com.davidferrand.spark.data.FuelType;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

public class AddReadingActivity extends RxAppCompatActivity {
    private static final String ARG_FUEL_TYPE = "fuelType";

    public static void start(Activity parent, FuelType fuelType) {
        Intent i = new Intent(parent, AddReadingActivity.class);
        i.putExtra(ARG_FUEL_TYPE, fuelType.name());

        parent.startActivity(i);
    }
}
