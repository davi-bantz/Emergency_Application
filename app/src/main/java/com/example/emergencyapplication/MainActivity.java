package com.example.emergencyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.emergencyapplication.Rescuer_Registration.Rescuer_Log_In;

public class MainActivity extends AppCompatActivity {

    private Button sendEmergencyButton, rescuerSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //When send emergency is clicked
        sendEmergencyButton = findViewById(R.id.Send_Emergency_BTN);
        sendEmergencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Send_EmergencyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //When Rescuer wants to Sign In
        rescuerSignIn = findViewById(R.id.Rescuer_Sign_In);
        rescuerSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Rescuer_Log_In.class);
                startActivity(intent);
                finish();
            }
        });


    }
}