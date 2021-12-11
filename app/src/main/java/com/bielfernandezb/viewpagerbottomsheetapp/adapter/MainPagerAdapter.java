package com.bielfernandezb.viewpagerbottomsheetapp.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bielfernandezb.viewpagerbottomsheetapp.fragment.FragmentAux;
import com.bielfernandezb.viewpagerbottomsheetapp.fragment.FragmentMain;

import java.util.ArrayList;
import java.util.List;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragments = new ArrayList<>();
    private final SparseArray<Fragment> registeredFragments = new SparseArray<>();
    private int currentPage = 0;

    public MainPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);

        // setup fragments
        mFragments.add(FragmentMain.newInstance());
        mFragments.add(FragmentAux.newInstance());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return "";
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

    public final int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
