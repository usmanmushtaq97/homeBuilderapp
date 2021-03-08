package com.tss.homebuilder.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.tss.homebuilder.Controller.AutoSliderVIewAdapter;
import com.tss.homebuilder.Controller.BuilderAdapter;
import com.tss.homebuilder.Controller.WorkerAdapter;
import com.tss.homebuilder.Models.BuilderItems;
import com.tss.homebuilder.Models.SliderItem;
import com.tss.homebuilder.Models.WorkerItems;
import com.tss.homebuilder.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.tss.homebuilder.Constant.SLIDER;
public class Home extends Fragment {
    View view;
    List< SliderItem > sliderItemList;
    List< BuilderItems > builderItemsList;
    List< WorkerItems > workerItemsList;
    SliderView mSliderView;
    Context mContext;
    AutoSliderVIewAdapter sliderViewAdapter;
    BuilderAdapter builderAdapter;
    WorkerAdapter workerAdapter;
    RecyclerView builderRecyclerView;
    RecyclerView workerRecyclerView;

    public Home() {
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
        view = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        LoadSlider();
        LoadBuilder();
        LoadWorker();
        return view;
    }

    private void init() {
        mSliderView = view.findViewById(R.id.imageSlider);
        builderRecyclerView = view.findViewById(R.id.builderrv);
        workerRecyclerView = view.findViewById(R.id.workerrvid);

    }

    // load the slider from backend penals
    private void LoadSlider() {
        mSliderView.startAutoCycle();
        mSliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        mSliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        mSliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        mSliderView.setIndicatorSelectedColor(Color.GREEN);
        mSliderView.setIndicatorUnselectedColor(Color.GRAY);
        mSliderView.setScrollTimeInSec(4);
        sliderItemList = new ArrayList<>();
        StringRequest request = new StringRequest(Request.Method.GET, SLIDER, new Response.Listener< String >() {
            @Override
            public void onResponse(String response) {
                Log.d("testtcode", response);
                try {
                    JSONArray mMainCategory = new JSONArray(response);
                    for (int i = 0; i < mMainCategory.length(); i++) {
                        JSONObject postobj = mMainCategory.getJSONObject(i);
                        int sliderid = postobj.getInt("id");
                        String mImageUrl = postobj.getString("image_url");

                        sliderItemList.add(new SliderItem(sliderid, mImageUrl));
                    }
                    sliderViewAdapter = new AutoSliderVIewAdapter(mContext, sliderItemList);
                    mSliderView.setSliderAdapter(sliderViewAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, error ->
                Toast.makeText(mContext, "errorrr", Toast.LENGTH_SHORT).show());
        request.setRetryPolicy(new DefaultRetryPolicy(
                7000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        );
        Volley.newRequestQueue(mContext).add(request);
    }

    private void LoadBuilder() {
        builderItemsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            builderItemsList.add(new BuilderItems(1, "Constructo", "23-34-43", "www.google.com", "adress", "03419796197", "4.3", 6, "https://cdn1.vectorstock.com/i/thumb-large/66/85/building-construction-logo-vector-22656685.jpg", 9));
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        builderRecyclerView.setLayoutManager(layoutManager);
        builderAdapter = new BuilderAdapter(mContext, builderItemsList);
        builderRecyclerView.setAdapter(builderAdapter);
        builderAdapter.notifyDataSetChanged();
    }

    private void LoadWorker() {
        workerItemsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            //(int wId, String wName, String wtypeofemployee, String wAdress, String wRatings, String wAge, String wImageUrl, int whourlyrate)
            workerItemsList.add(new WorkerItems(1, "Rocky", "Painter", "Daska Pakistan", "ratings", "33", "https://cdn1.vectorstock.com/i/thumb-large/84/80/cityscape-building-logo-vector-16628480.jpg", 20));
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        workerRecyclerView.setLayoutManager(layoutManager);
        workerAdapter = new WorkerAdapter(mContext, workerItemsList);
        workerRecyclerView.setAdapter(workerAdapter);
        workerAdapter.notifyDataSetChanged();
    }
}