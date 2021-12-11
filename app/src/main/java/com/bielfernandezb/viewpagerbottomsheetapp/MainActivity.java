package com.bielfernandezb.viewpagerbottomsheetapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetUtils;
import com.google.android.material.bottomsheet.ViewPagerBottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    int state = BottomSheetBehavior.STATE_COLLAPSED;
    private ViewPagerBottomSheetBehavior mBottomSheetBehavior;
    private ViewPager mViewPager;
    private LinearLayoutCompat bottomSheet;
    private PagerAdapterMain mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bottomSheet = findViewById(R.id.bottom_sheet);
        mViewPager = findViewById(R.id.activity_main_vp);

        // setup viewpager
        mPagerAdapter = new PagerAdapterMain(this, getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        mBottomSheetBehavior = ViewPagerBottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setHideable(false);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mBottomSheetBehavior.setPeekHeight(120);

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
                double upperState = 0.66;
                double lowerState = 0.33;

                if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_SETTLING) {
                    if (slideOffset >= upperState) {
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }
                    if (slideOffset > lowerState && slideOffset < upperState) {
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
                    }
                    if (slideOffset <= lowerState) {
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    }
                }
            }
        });

        BottomSheetUtils.setupViewPager(mViewPager);
    }
}