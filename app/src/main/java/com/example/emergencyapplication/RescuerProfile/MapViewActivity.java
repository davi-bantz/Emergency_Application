package com.example.emergencyapplication.RescuerProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.emergencyapplication.R;

public class MapViewActivity extends AppCompatActivity {

    //write code for mapping here

    private ImageButton mapview, emergencies, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        mapview = findViewById(R.id.MapViewButton_frMap);
        emergencies = findViewById(R.id.EmergencyButton_frMapAct);
        settings = findViewById(R.id.UserSettingsButton_frMap);

        //Navigate through mapButton
        mapview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMap = new Intent(MapViewActivity.this, MapViewActivity.class);
                startActivity(gotoMap);
            }
        });

        //Navigate through emergencyButton
        emergencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMap = new Intent(MapViewActivity.this, Rescuer_HomeScreenActivity.class);
                startActivity(gotoMap);
            }
        });

        //Navigate through Settings Button
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMap = new Intent(MapViewActivity.this, Rescuer_SettingsActivity.class);
                startActivity(gotoMap);
            }
        });
    }
}