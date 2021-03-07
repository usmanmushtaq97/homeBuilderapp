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

public class AllWorkerFragment extends Fragment {
    View view;
    List< WorkerItems > workerItemsList;
    Context mContext;
    WorkerAdapter workerAdapter;
    RecyclerView workerRecyclerView;
    public AllWorkerFragment() {
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
 view = inflater.inflate(R.layout.fragment_first, container, false);
 init();
 LoadWorker();
 return view;
    }
    private void init() {
        workerRecyclerView = view.findViewById(R.id.allworkerrvid);

    }
    private void LoadWorker() {

        workerItemsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            //(int wId, String wName, String wtypeofemployee, String wAdress, String wRatings, String wAge, String wImageUrl, int whourlyrate)
            workerItemsList.add(new WorkerItems(1,"Rocky","Painter","Daska Pakistan","ratings","33","https://cdn1.vectorstock.com/i/thumb-large/84/80/cityscape-building-logo-vector-16628480.jpg",20));
        }
      GridLayoutManager layoutManager = new GridLayoutManager(mContext,2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        workerRecyclerView.setLayoutManager(layoutManager);
        workerAdapter =  new WorkerAdapter(mContext, workerItemsList);
        workerRecyclerView.setAdapter(workerAdapter);
        workerAdapter.notifyDataSetChanged();
    }
}