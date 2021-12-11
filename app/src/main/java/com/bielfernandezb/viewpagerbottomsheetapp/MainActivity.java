package com.bielfernandezb.viewpagerbottomsheetapp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewpager.widget.ViewPager;

import com.bielfernandezb.viewpagerbottomsheetapp.adapter.MainPagerAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetUtils;
import com.google.android.material.bottomsheet.ViewPagerBottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    private ViewPagerBottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        LinearLayoutCompat bottomSheet = findViewById(R.id.bottom_sheet);
        ViewPager mViewPager = findViewById(R.id.activity_main_vp);

        // setup viewpager
        MainPagerAdapter mPagerAdapter = new MainPagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        mBottomSheetBehavior = ViewPagerBottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setHideable(false);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mBottomSheetBehavior.setPeekHeight(120);

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
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