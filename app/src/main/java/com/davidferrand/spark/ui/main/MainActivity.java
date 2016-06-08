package com.davidferrand.spark.ui.main;

import android.animation.ArgbEvaluator;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.davidferrand.spark.R;
import com.davidferrand.spark.data.FuelType;
import com.davidferrand.spark.ui.meter.MeterOverviewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_view_group)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.main_appbar)
    AppBarLayout appBarLayout;

    @BindView(R.id.main_view_pager)
    ViewPager viewPager;
    @BindView(R.id.main_tabs)
    TabLayout tabLayout;
    @BindView(R.id.main_fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(new ScrollColorBlender());

        tabLayout.setupWithViewPager(viewPager);
        for (FuelType fuelType : FuelType.VALUES) {
            tabLayout.getTabAt(fuelType.ordinal()).setIcon(fuelType.iconRes);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private static class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return MeterOverviewFragment.newInstance(FuelType.valueOf(position));
        }

        @Override
        public int getCount() {
            return FuelType.VALUES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return FuelType.valueOf(position).getResourceCache().name;
        }
    }

    private class ScrollColorBlender extends ViewPager.SimpleOnPageChangeListener {

        private final ArgbEvaluator colorEvaluator = new ArgbEvaluator();

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            final int colorPrimaryCurrent = FuelType.valueOf(position).getResourceCache().colorPrimary;
            final int colorPrimaryDarkCurrent = FuelType.valueOf(position).getResourceCache().colorPrimaryDark;

            final int colorPrimaryBlend;
            final int colorPrimaryDarkBlend;

            if (positionOffset == 0) {
                // No movement: easy
                colorPrimaryBlend = colorPrimaryCurrent;
                colorPrimaryDarkBlend = colorPrimaryDarkCurrent;
            } else {
                // The offset is always [0,1) and the scroll happens always between position n and n+1
                final int colorPrimaryNext = FuelType.valueOf(position + 1).getResourceCache().colorPrimary;
                final int colorPrimaryDarkNext = FuelType.valueOf(position + 1).getResourceCache().colorPrimaryDark;

                // Blend
                colorPrimaryBlend = (int) colorEvaluator.evaluate(positionOffset,
                        colorPrimaryCurrent,
                        colorPrimaryNext);
                colorPrimaryDarkBlend = (int) colorEvaluator.evaluate(positionOffset,
                        colorPrimaryDarkCurrent,
                        colorPrimaryDarkNext);
            }

            appBarLayout.setBackgroundColor(colorPrimaryBlend);
            fab.setBackgroundTintList(ColorStateList.valueOf(colorPrimaryBlend));
            coordinatorLayout.setStatusBarBackgroundColor(colorPrimaryDarkBlend);
        }
    }
}
