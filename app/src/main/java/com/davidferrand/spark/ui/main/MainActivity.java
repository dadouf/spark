package com.davidferrand.spark.ui.main;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.os.Bundle;
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
import android.widget.TextView;

import com.davidferrand.spark.R;
import com.davidferrand.spark.data.FuelType;
import com.davidferrand.spark.ui.meter.MeterOverviewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_view_group)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.main_view_pager)
    ViewPager viewPager;
    @BindView(R.id.main_tabs)
    TabLayout tabLayout;
    @BindView(R.id.main_fab)
    FloatingActionButton fab;

    @BindView(R.id.test_position)
    TextView tvPosition;
    @BindView(R.id.test_offset1)
    TextView tvPositionOffset;
    @BindView(R.id.test_offset2)
    TextView tvPositionOffsetPx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                final int colorPrimaryCurrent = getResources().getColor(FuelType.valueOf(position).colorPrimaryRes);
                final int colorPrimaryDarkCurrent = getResources().getColor(FuelType.valueOf(position).colorPrimaryDarkRes);

                final int colorPrimaryBlend;
                final int colorPrimaryDarkBlend;

                if (positionOffset == 0) {
                    // No movement: easy
                    colorPrimaryBlend = colorPrimaryCurrent;
                    colorPrimaryDarkBlend = colorPrimaryDarkCurrent;
                } else {
                    // The offset is always [0,1) and the scroll happens always between position n and n+1
                    final int colorPrimaryNext = getResources().getColor(FuelType.valueOf(position + 1).colorPrimaryRes);
                    final int colorPrimaryDarkNext = getResources().getColor(FuelType.valueOf(position + 1).colorPrimaryRes);

                    // Blend
                    colorPrimaryBlend = (int) new ArgbEvaluator().evaluate(positionOffset,
                            colorPrimaryCurrent, colorPrimaryNext);
                    colorPrimaryDarkBlend = (int) new ArgbEvaluator().evaluate(positionOffset,
                            colorPrimaryDarkCurrent, colorPrimaryDarkNext);
                }

                coordinatorLayout.setBackgroundColor(colorPrimaryBlend);
                coordinatorLayout.setStatusBarBackgroundColor(colorPrimaryDarkBlend);
            }
        });

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

    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final Context context;

        public SectionsPagerAdapter(Context context, FragmentManager fm) {
            super(fm);
            this.context = context;
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
            return context.getString(FuelType.valueOf(position).nameRes);
        }
    }
}
