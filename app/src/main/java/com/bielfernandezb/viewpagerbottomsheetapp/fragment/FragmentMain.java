package com.bielfernandezb.viewpagerbottomsheetapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bielfernandezb.viewpagerbottomsheetapp.R;
import com.bielfernandezb.viewpagerbottomsheetapp.adapter.DataAdapter;
import com.bielfernandezb.viewpagerbottomsheetapp.model.Data;

import java.util.ArrayList;
import java.util.List;

public class FragmentMain extends Fragment {

    private RecyclerView recyclerView;
    private DataAdapter mAdapter;

    public static FragmentMain newInstance() {
        Bundle bundle = new Bundle();
        FragmentMain fragmentMain = new FragmentMain();
        fragmentMain.setArguments(bundle);
        return fragmentMain;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = getActivity().findViewById(R.id.fragment_main_recycler);

        mAdapter = new DataAdapter(prepareDataList());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

    }

    public List<Data> prepareDataList() {
        List<Data> dataList = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            dataList.add(new Data("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged"));
        }
        return dataList;
    }
}