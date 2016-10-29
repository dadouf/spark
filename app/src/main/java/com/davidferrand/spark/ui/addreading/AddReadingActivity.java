package com.davidferrand.spark.ui.addreading;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.davidferrand.spark.data.FuelType;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

public class AddReadingActivity extends RxAppCompatActivity implements AddReadingView {
    private static final String EXTRA_FUEL_TYPE = "fuelType";

    public static void start(Activity parent, FuelType fuelType) {
        Intent i = new Intent(parent, AddReadingActivity.class);
        i.putExtra(EXTRA_FUEL_TYPE, fuelType.name());

        parent.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String fuelTypeName = getIntent().getStringExtra(EXTRA_FUEL_TYPE);

        AddReadingFragment.newInstance(fuelTypeName);
    }
}
