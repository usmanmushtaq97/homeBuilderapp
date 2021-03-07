package com.tss.homebuilder.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.smarteist.autoimageslider.SliderView;
import com.tss.homebuilder.Controller.AutoSliderVIewAdapter;
import com.tss.homebuilder.Controller.BuilderAdapter;
import com.tss.homebuilder.Controller.RattingAdapter;
import com.tss.homebuilder.Controller.WorkerAdapter;
import com.tss.homebuilder.Models.BuilderItems;
import com.tss.homebuilder.Models.RatingsModels;
import com.tss.homebuilder.Models.SliderItem;
import com.tss.homebuilder.Models.WorkerItems;
import com.tss.homebuilder.R;

import java.util.ArrayList;
import java.util.List;

public class LabourItemDetails extends AppCompatActivity {
    List<RatingsModels> workerItemsList;
    RattingAdapter workerAdapter;
    RecyclerView workerRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labour_item_details);
        init();
        LoadWorker();
    }
    private void init() {
        workerRecyclerView = findViewById(R.id.rating_rv_id);

    }
    private void LoadWorker() {
        workerItemsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            //(int wId, String wName, String wtypeofemployee, String wAdress, String wRatings, String wAge, String wImageUrl, int whourlyrate)
            workerItemsList.add(new RatingsModels(1,"Rocky","https://cdn1.vectorstock.com/i/thumb-large/84/80/cityscape-building-logo-vector-16628480.jpg","nice jobs",3));
        }
      LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        workerRecyclerView.setLayoutManager(layoutManager);
        workerAdapter =  new RattingAdapter(this, workerItemsList);
        workerRecyclerView.setAdapter(workerAdapter);
        workerAdapter.notifyDataSetChanged();
    }
}