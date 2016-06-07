package com.davidferrand.spark.ui.meter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidferrand.spark.R;
import com.davidferrand.spark.data.Meter;

public class MeterOverviewFragment extends Fragment {

    private static final String ARG_FUEL_TYPE = "fuelType";

    public static Fragment newInstance(Meter.FuelType fuelType) {
        MeterOverviewFragment fragment = new MeterOverviewFragment();

        Bundle args = new Bundle();
        args.putString(ARG_FUEL_TYPE, fuelType.name());
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meter_overview, container, false);

        TextView textView = (TextView) v.findViewById(R.id.meter_overview_text);
        textView.setText(getString(R.string.section_format, getArguments().getString(ARG_FUEL_TYPE)));

        return v;
    }
}
