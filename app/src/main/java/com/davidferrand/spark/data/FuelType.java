package com.davidferrand.spark.data;

import android.content.Context;
import android.content.res.TypedArray;

import com.davidferrand.spark.R;

import java.util.HashMap;
import java.util.Map;

public enum FuelType {
    ELECTRICITY(
            R.drawable.ic_power_white_24dp,
            R.string.electricity,
            R.style.AppTheme_Electricity_NoActionBar),
    GAS(
            R.drawable.ic_whatshot_white_24dp,
            R.string.gas,
            R.style.AppTheme_Gas_NoActionBar);

    public static final FuelType[] VALUES = FuelType.values();

    public final int iconRes;
    public final int nameRes;
    public final int themeRes;

    FuelType(int iconTabRes, int nameRes, int themeRes) {
        this.iconRes = iconTabRes;
        this.nameRes = nameRes;
        this.themeRes = themeRes;
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

            TypedArray a = context.getTheme().obtainStyledAttributes(fuelType.themeRes, new int[]{R.attr.colorPrimary, R.attr.colorPrimaryDark});
            colorPrimary = a.getColor(0, 0);
            colorPrimaryDark = a.getColor(1, 0);
            a.recycle();
        }
    }
}
