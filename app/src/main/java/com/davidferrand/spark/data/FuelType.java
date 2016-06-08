package com.davidferrand.spark.data;

import com.davidferrand.spark.R;

public enum FuelType {
    ELECTRICITY(R.drawable.ic_power_white_24dp, R.string.electricity),
    GAS(R.drawable.ic_whatshot_white_24dp, R.string.gas);

    public static final FuelType[] VALUES = FuelType.values();

    public final int iconRes;
    public final int nameRes;

    FuelType(int iconTabRes, int nameRes) {
        this.iconRes = iconTabRes;
        this.nameRes = nameRes;
    }

    public static FuelType valueOf(int position) {
        return FuelType.VALUES[position];
    }
}
