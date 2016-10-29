package com.davidferrand.spark.ui.addreading;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidferrand.spark.R;


public class AddReadingFragment extends Fragment implements AddReadingView {
    private static final String ARG_FUEL_TYPE = "fuelType";
    private final AddReadingPresenter presenter = AddReadingModule.presenter();

    public static AddReadingFragment newInstance(String fuelTypeName) {
        Bundle args = new Bundle();
        args.putString(ARG_FUEL_TYPE, fuelTypeName);

        AddReadingFragment fragment = new AddReadingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_reading, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.bindView(this);
    }
}
