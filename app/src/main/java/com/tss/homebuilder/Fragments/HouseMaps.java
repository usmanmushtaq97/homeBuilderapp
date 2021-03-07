package com.tss.homebuilder.Fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.tss.homebuilder.Controller.FragmentL2D3Ddapter;
import com.tss.homebuilder.Controller.FragmentLWAdapter;
import com.tss.homebuilder.R;
public class HouseMaps extends Fragment {
    View view;
    Context mContext;
    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentL2D3Ddapter adapter;
    public HouseMaps() {
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
        view = inflater.inflate(R.layout.fragment_house_mape, container, false);
        tabLayout = view.findViewById(R.id.tab_layout_id);
        pager2 = view.findViewById(R.id.view_pager2_id);
        FragmentManager fm = getFragmentManager();
        adapter = new FragmentL2D3Ddapter(fm, getLifecycle());
        pager2.setAdapter(adapter);
        tabLayout.addTab(tabLayout.newTab().setText("3D"));
        tabLayout.addTab(tabLayout.newTab().setText("2D"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        return view;
    }
}