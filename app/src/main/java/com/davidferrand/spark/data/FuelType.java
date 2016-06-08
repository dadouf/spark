package com.davidferrand.spark.data;

import com.davidferrand.spark.R;

public enum FuelType {
    ELECTRICITY(
            R.drawable.ic_power_white_24dp,
            R.string.electricity,
            R.color.electricity_colorPrimary,
            R.color.electricity_colorPrimaryDark),
    GAS(
            R.drawable.ic_whatshot_white_24dp,
            R.string.gas,
            R.color.gas_colorPrimary,
            R.color.gas_colorPrimaryDark);

    public static final FuelType[] VALUES = FuelType.values();

    public final int iconRes;
    public final int nameRes;
    public final int colorPrimaryRes;
    public final int colorPrimaryDarkRes;

    FuelType(int iconTabRes, int nameRes, int colorPrimaryRes, int colorPrimaryDarkRes) {
        this.iconRes = iconTabRes;
        this.nameRes = nameRes;
        this.colorPrimaryRes = colorPrimaryRes;
        this.colorPrimaryDarkRes = colorPrimaryDarkRes;
    }

    public static FuelType valueOf(int position) {
        return FuelType.VALUES[position];
    }
}
