package com.example.emergencyapplication.RescuerProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.emergencyapplication.R;


public class Rescuer_SettingsActivity extends AppCompatActivity {

    private ImageButton profile, service;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescuer_settings);

        profile = findViewById(R.id.imageButtonforRescuerProfile);
        service = findViewById(R.id.imageButtonforRescuerService_Profile);

        //go to user profile
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoprofile = new Intent(Rescuer_SettingsActivity.this, Rescuer_UpdateBasicDetails_Activity.class);
                startActivity(gotoprofile);
            }
        });

        //goto service profile
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoserviceprofile = new Intent(Rescuer_SettingsActivity.this, Rescuer_UpdateService_Activity.class);
                startActivity(gotoserviceprofile);
            }
        });
    }
}