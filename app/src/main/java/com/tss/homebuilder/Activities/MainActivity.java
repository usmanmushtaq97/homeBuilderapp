package com.tss.homebuilder.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.tss.homebuilder.R;

import static com.tss.homebuilder.Constant.SPLASH_TIME;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      if(FirebaseAuth.getInstance().getCurrentUser() != null){
            handler = new Handler();
            handler.postDelayed(() -> {
                intent = new Intent(MainActivity.this, Home_Activity.class);
                startActivity(intent);
                finish();
            }, SPLASH_TIME);
      }
        //else if(firstTime){
            // Go to Intro Activity
    //    }
        else {
            intent = new Intent(MainActivity.this, GetMobileNumber.class);
            startActivity(intent);
            finish();
        }
    }
}