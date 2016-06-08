package com.davidferrand.spark.ui.main;

import android.content.Context;
import android.os.Bundle;
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

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(sectionsPagerAdapter);

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
