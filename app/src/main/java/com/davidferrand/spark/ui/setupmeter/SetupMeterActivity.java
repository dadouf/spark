package com.davidferrand.spark.ui.setupmeter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.davidferrand.spark.R;
import com.davidferrand.spark.data.FuelType;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SetupMeterActivity extends RxAppCompatActivity {
    private static final String ARG_FUEL_TYPE = "fuelType";

    private FuelType fuelType;

    @BindView(R.id.setup_meter_toolbar)
    Toolbar toolbar;

    public static void start(Context context, FuelType fuelType) {
        Intent i = new Intent(context, SetupMeterActivity.class);
        i.putExtra(ARG_FUEL_TYPE, fuelType.name());

        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fuelType = FuelType.valueOf(getIntent().getStringExtra(ARG_FUEL_TYPE));
        if (fuelType == FuelType.ELECTRICITY) {
            setTheme(R.style.AppTheme_Electricity_NoActionBar);
        } else {
            setTheme(R.style.AppTheme_Gas_NoActionBar);
        }

        setContentView(R.layout.activity_setup_meter);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
