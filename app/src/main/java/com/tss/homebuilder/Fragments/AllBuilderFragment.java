package com.tss.homebuilder.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.SliderView;
import com.tss.homebuilder.Controller.AutoSliderVIewAdapter;
import com.tss.homebuilder.Controller.BuilderAdapter;
import com.tss.homebuilder.Controller.WorkerAdapter;
import com.tss.homebuilder.Models.BuilderItems;
import com.tss.homebuilder.Models.SliderItem;
import com.tss.homebuilder.Models.WorkerItems;
import com.tss.homebuilder.R;

import java.util.ArrayList;
import java.util.List;

public class AllBuilderFragment extends Fragment {
    View view;
    List< BuilderItems > builderItemsList;
    Context mContext;
    BuilderAdapter builderAdapter;
    RecyclerView builderRecyclerView;

    public AllBuilderFragment() {
        // Required empty public constructor
    }
    // attach context
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    view = inflater.inflate(R.layout.fragment_second, container, false);
    init();
    LoadBuilder();
    return view;
    }
    private void init() {
        builderRecyclerView = view.findViewById(R.id.builderrv);
    }
    private void LoadBuilder() {
        builderItemsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            //(int bid, String bname, String bstartdate, String bWeburl, String baddress, String bPhone, String brating, int bNo_of_employee, String bImageUrl, int bVerifiyStatus)
            builderItemsList.add(new BuilderItems(1, "Constructo", "23-34-43", "www.google.com", "adress", "03419796197", "4.3", 6, "https://cdn1.vectorstock.com/i/thumb-large/66/85/building-construction-logo-vector-22656685.jpg", 9));
        }
    GridLayoutManager layoutManager = new GridLayoutManager(mContext,2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        builderRecyclerView.setLayoutManager(layoutManager);
        builderAdapter = new BuilderAdapter(mContext, builderItemsList);
        builderRecyclerView.setAdapter(builderAdapter);
        builderAdapter.notifyDataSetChanged();
    }
}