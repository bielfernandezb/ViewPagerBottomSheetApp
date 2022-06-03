package com.bielfernandezb.viewpagerbottomsheetapp;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bielfernandezb.viewpagerbottomsheetapp.views.fragments.FragmentAux;
import com.bielfernandezb.viewpagerbottomsheetapp.views.fragments.FragmentMain;

import java.util.ArrayList;
import java.util.List;

class PagerAdapterMain extends FragmentStatePagerAdapter {

    SparseArray<Fragment> registeredFragments = new SparseArray<>();
    private final List<Fragment> mFragments = new ArrayList<>();
    private int currentPage = 0;

    public PagerAdapterMain(Context context, FragmentManager fragmentManager) {
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
