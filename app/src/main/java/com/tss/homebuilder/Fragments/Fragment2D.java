package com.tss.homebuilder.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tss.homebuilder.Controller.MapsAdapter;
import com.tss.homebuilder.Controller.WorkerAdapter;
import com.tss.homebuilder.Models.MapsModels;
import com.tss.homebuilder.Models.WorkerItems;
import com.tss.homebuilder.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment2D extends Fragment {
    View view;
    List< MapsModels > mapsModelsList;
    Context mContext;
    MapsAdapter workerAdapter;
    RecyclerView recyclerviewmap2d;
    public Fragment2D() {
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
        view = inflater.inflate(R.layout.fragment_2, container, false);
        init();
        LoadWorker();
        return view;
    }
    private void init() {
        recyclerviewmap2d = view.findViewById(R.id.m2d_rv_id);

    }
    private void LoadWorker() {

        mapsModelsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            //(int wId, String wName, String wtypeofemployee, String wAdress, String wRatings, String wAge, String wImageUrl, int whourlyrate)
            mapsModelsList.add(new MapsModels(1,"new 3d maps 2 marla","sduhfishfksofids","xyz.jpg"));
        }
       LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerviewmap2d.setLayoutManager(layoutManager);
        workerAdapter =  new MapsAdapter(mContext, mapsModelsList);
        recyclerviewmap2d.setAdapter(workerAdapter);
        workerAdapter.notifyDataSetChanged();
    }
}