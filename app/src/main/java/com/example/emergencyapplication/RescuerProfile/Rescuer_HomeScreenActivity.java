package com.example.emergencyapplication.RescuerProfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.emergencyapplication.R;
import com.example.emergencyapplication.Send_EmergencyActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Rescuer_HomeScreenActivity extends AppCompatActivity {

    private RecyclerView messagesReceived;

    private ImageButton mapActivity, EmergencyActivity, SettingsActivity;

    private FloatingActionButton sendemergency, add;

    boolean aBoolean = true;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescuer_home_screen);

        messagesReceived = findViewById(R.id.Emergency_Received);
        mapActivity = findViewById(R.id.MapViewButton);
        EmergencyActivity = findViewById(R.id.EmergencyButton);
        SettingsActivity  = findViewById(R.id.UserSettingsButton);
        sendemergency = findViewById(R.id.FABEmergency);
        add = findViewById(R.id.floatingActionButton);

        //Method for Recycler View
        viewReceivedMessage();


        //Navigate through mapButton
        mapActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMap = new Intent(Rescuer_HomeScreenActivity.this, MapViewActivity.class);
                startActivity(gotoMap);
            }
        });

        //Navigate through emergencyButton
        EmergencyActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMap = new Intent(Rescuer_HomeScreenActivity.this, Rescuer_HomeScreenActivity.class);
                startActivity(gotoMap);
            }
        });

        //Navigate through Settings Button
        SettingsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMap = new Intent(Rescuer_HomeScreenActivity.this, Rescuer_SettingsActivity.class);
                startActivity(gotoMap);
            }
        });

        //Set-up for Floating Action Button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aBoolean){
                    sendemergency.show();
                    sendemergency.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent gotosend = new Intent(Rescuer_HomeScreenActivity.this, Send_EmergencyActivity.class);
                            startActivity(gotosend);
                        }
                    });
                    aBoolean = false;
                } else{
                    sendemergency.hide();
                    aBoolean = true;
                }
            }
        });

    }

    private void viewReceivedMessage() {
    }
}