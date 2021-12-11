package com.bielfernandezb.viewpagerbottomsheetapp;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

class PagerAdapterMain extends FragmentStatePagerAdapter {

    public static final int FRAGMENT_VISITS = 0;
    public static final int FRAGMENT_WORK_ORDERS = 1;
    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();
    private List<Fragment> mFragments = new ArrayList<>();
    private Context mContext;
    private int currentPage = 0;

    public PagerAdapterMain(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;

        // setup fragments
        mFragments.add(FragmentMain.newInstance());
        mFragments.add(FragmentAux.newInstance());
    }

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

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
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
