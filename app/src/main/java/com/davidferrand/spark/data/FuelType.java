package com.davidferrand.spark.data;

import android.content.Context;

import com.davidferrand.spark.R;

import java.util.HashMap;
import java.util.Map;

public enum FuelType {
    ELECTRICITY(
            R.drawable.ic_power_white_24dp,
            R.string.electricity,
            R.color.theme_electricity_colorPrimary,
            R.color.theme_electricity_colorPrimaryDark),
    GAS(
            R.drawable.ic_whatshot_white_24dp,
            R.string.gas,
            R.color.theme_gas_colorPrimary,
            R.color.theme_gas_colorPrimaryDark);

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

    public ResourceCache getResourceCache() {
        return ResourceCache.MAP_CACHES.get(this);
    }

    public static FuelType valueOf(int position) {
        return FuelType.VALUES[position];
    }

    /**
     * Used to cache values of resources that can only be loaded with a {@link Context} (strings,
     * colours).
     */
    public static class ResourceCache {

        public final String name;
        public final int colorPrimary;
        public final int colorPrimaryDark;

        private static final Map<FuelType, ResourceCache> MAP_CACHES = new HashMap<>();

        /**
         * Loads the cache by fetching the values of the resources.
         * Should be called as early as possible (in the Application's onCreate()) and every time
         * there's a configuration change, if necessary.
         */
        public static void init(Context context) {
            for (FuelType fuelType : VALUES) {
                MAP_CACHES.put(fuelType, new ResourceCache(context, fuelType));
            }
        }

        private ResourceCache(Context context, FuelType fuelType) {
            name = context.getString(fuelType.nameRes);
            colorPrimary = context.getResources().getColor(fuelType.colorPrimaryRes);
            colorPrimaryDark = context.getResources().getColor(fuelType.colorPrimaryDarkRes);
        }
    }
}
