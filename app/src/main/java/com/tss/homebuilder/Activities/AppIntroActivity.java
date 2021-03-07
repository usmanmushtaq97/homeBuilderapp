package com.tss.homebuilder.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.tss.homebuilder.Controller.InfoViewPgAdpater;
import com.tss.homebuilder.Models.ScreenIntroModel;
import com.tss.homebuilder.R;

import java.util.ArrayList;
import java.util.List;

public class AppIntroActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private InfoViewPgAdpater viewPgAdpater;
    private List< ScreenIntroModel > infolist;
    private TabLayout tabLayout;
    Animation btanimation;
    Button btNext;
    Button btgetsatrt;
    int postion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (RestorePrefrenc()) {
            Intent intent = new Intent(AppIntroActivity.this, MainActivity.class);
            startActivity(intent);
        }
        //full screen activity
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_app_intro);
        btNext = findViewById(R.id.button);
        viewPager = findViewById(R.id.viewpage);
        tabLayout = findViewById(R.id.tablayout);
        btgetsatrt = findViewById(R.id.getStart);
        btanimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bt_animation);
        infolist = new ArrayList<>();
        infolist.add(new ScreenIntroModel("Find Your Product", "Here are many simple ways to find products that sell on E-sialkot: Use an Amazon Keyword Research Tool. Find Low Competition Keywords Triggering Product Ads on E-sialkot.", R.drawable.ic_findshop));
        infolist.add(new ScreenIntroModel("Buy your product", "Finly buy your  your products with shops any product which you want from here easly", R.drawable.ic_findshop));
        infolist.add(new ScreenIntroModel("cash & online", "PayPal allows you to make payments using a variety of methods including: PayPal Cash or PayPal Cash Plus account balance, a bank account, PayPal Credit, debit or credit cards, and rewards balance.", R.drawable.ic_findshop));
        infolist.add(new ScreenIntroModel("Congratulation", "Congratulations on your well-deserved success. your product is on your hand now Thanks to join the our app best of  luck", R.drawable.ic_findshop));
        InfoViewPgAdpater viewPgAdpater = new InfoViewPgAdpater(this, infolist);
        viewPager.setAdapter(viewPgAdpater);
        tabLayout.setupWithViewPager(viewPager);
        // LoadScreen();
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(AppIntroActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                postion = viewPager.getCurrentItem();
                if (postion < infolist.size()) {
                    postion++;
                    viewPager.setCurrentItem(postion);
                }
                if (postion == infolist.size() - 1) //when we reach the last screen
                {
                    // TODO: show the get satarted and hide the all indecator
                    LoadScreen();
                }
            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == infolist.size() - 1) {
                    LoadScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        btgetsatrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppIntroActivity.this, Home_Activity.class);
                startActivity(intent);
                finish();
            }

        });
    }

    private boolean RestorePrefrenc() {
        SharedPreferences pre = getApplicationContext().getSharedPreferences("prefrence", MODE_PRIVATE);
        Boolean isIntroAcitivityOpennedBefore = pre.getBoolean("isIntroOpened", false);

        return isIntroAcitivityOpennedBefore;
    }

    private void sevePrefdata() {

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myprefrence", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isIntroOpened", true);
        editor.commit();
        //SharedPreferences.Editor editor=;
    }

    private void LoadScreen() {
        btNext.setVisibility(View.INVISIBLE);
        tabLayout.setVisibility(View.INVISIBLE);
        btgetsatrt.setVisibility(View.VISIBLE);
        btgetsatrt.setAnimation(btanimation);
    }
}
