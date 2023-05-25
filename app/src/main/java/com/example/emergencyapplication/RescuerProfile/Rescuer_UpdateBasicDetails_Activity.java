package com.example.emergencyapplication.RescuerProfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.emergencyapplication.R;
import com.example.emergencyapplication.Rescuer_Registration.DBHelper;
import com.example.emergencyapplication.Rescuer_Registration.ReadWriteUserDetails;

import java.util.List;

public class Rescuer_UpdateBasicDetails_Activity extends AppCompatActivity {

    private RecyclerView viewdetails;
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescuer_update_basic_details);

        //declare layout
        viewdetails = findViewById(R.id.recyclerView_RescuerBasicDetails);
        update = findViewById(R.id.UpdateBasicDetails_BTN);

        //recycle view stuff
        viewdetails.setLayoutManager(new LinearLayoutManager(this));
        viewdetails.setHasFixedSize(true);

        DBHelper dbHelper = new DBHelper(Rescuer_UpdateBasicDetails_Activity.this);
        List<ReadWriteUserDetails> readWriteUserDetails = dbHelper.getBasicDetails();

        if (readWriteUserDetails.size() > 0) {
            RescuerBasicDetails_Adapter rescuerBasicDetails_adapter =  new RescuerBasicDetails_Adapter (readWriteUserDetails, Rescuer_UpdateBasicDetails_Activity.this);
            viewdetails.setAdapter(rescuerBasicDetails_adapter);

        }else {
            Toast.makeText(this, "There is no existing data!", Toast.LENGTH_SHORT).show();
        }


    }
}