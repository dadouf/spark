package com.davidferrand.spark.ui.setupmeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.davidferrand.spark.R;
import com.davidferrand.spark.data.FuelType;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

public class SetupMeterActivity extends RxAppCompatActivity {
    private static final String ARG_FUEL_TYPE = "fuelType";

    public static void start(Activity parent, FuelType fuelType) {
        Intent i = new Intent(parent, SetupMeterActivity.class);
        i.putExtra(ARG_FUEL_TYPE, fuelType.name());

        parent.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setup_meter);
    }
}
