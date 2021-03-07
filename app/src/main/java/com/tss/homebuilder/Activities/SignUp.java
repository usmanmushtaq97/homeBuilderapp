package com.tss.homebuilder.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.tss.homebuilder.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class
SignUp extends AppCompatActivity {
    Button mNext;
    TextInputEditText mFirstNameET;
    TextInputEditText mLastNameET;
    TextInputEditText mPasswordEt;
    TextInputEditText mEmailEt;
    String name;
    String email;
    String mLastName;
    String password;
    String mobileNumber="788878778";
    public static String userpref = "USER_PREF";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //methods initialize
        init();
        getIntentValue();
        mNext.setOnClickListener(v ->
        {
            if (IsNotEmpty()) {
                SavedValueInSharedPref();
                User_register();
            }
        });
    }
    private void init() {
        mNext = findViewById(R.id.signup_bt_next);
        mFirstNameET = findViewById(R.id.signup_fullname_id);
        mLastNameET = findViewById(R.id.sginup_username_id);
        mEmailEt = findViewById(R.id.signuemail_id);
        mPasswordEt = findViewById(R.id.signup_password_id);
    }

    private void getIntentValue() {
        Intent intent = getIntent();
        intent.getStringExtra("mobilenumber");
    }

    private Boolean IsNotEmpty() {
        name = mFirstNameET.getText().toString();
        mLastName = mLastNameET.getText().toString();
        email = mEmailEt.getText().toString();
        password = mPasswordEt.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(this, "Enter The Name", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mLastName.isEmpty()) {
            Toast.makeText(this, "Enter LastName", Toast.LENGTH_SHORT).show();
            return false;
        } else if (email.isEmpty()) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void SavedValueInSharedPref() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences(userpref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("phoneNumber", mobileNumber);
        editor.putString("fname", name);
        editor.putString("lname", mLastName);
        editor.putString("email", email);
        editor.apply();
    }
    private void User_register() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.GET, "http://technicaltea.e-sialkot.com/Admin/apis/registeruser.php?fname=" + name + "&lname=" + mLastName + "&email=" + email + "&mobile=" + mobileNumber + "&pas=" + password
                , response -> {
                 if(response.contentEquals("successfully inserted")){
                     progressDialog.dismiss();
                     Intent intent = new Intent(SignUp.this, Home_Activity.class);
                     intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                     startActivity(intent);
                     Toast.makeText(this, "sucessfully inserted", Toast.LENGTH_SHORT).show();
                 }

                }, error -> Toast.makeText(this, "errorrr", Toast.LENGTH_SHORT).show());
        request.setRetryPolicy(new DefaultRetryPolicy(
                7000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        );
        request.setShouldCache(false);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}