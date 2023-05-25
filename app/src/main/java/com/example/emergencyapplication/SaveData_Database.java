package com.example.emergencyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emergencyapplication.RescuerProfile.Rescuer_HomeScreenActivity;
import com.example.emergencyapplication.Rescuer_Registration.DBHelper;
import com.example.emergencyapplication.Rescuer_Registration.DBService;
import com.example.emergencyapplication.Rescuer_Registration.ReadWriteService;
import com.example.emergencyapplication.Rescuer_Registration.ReadWriteUserDetails;


public class SaveData_Database extends AppCompatActivity {

    private TextView fullnameRescuer, DOBRes, EmailRes, phoneNumberRes, rescuerOrganization, rescuerRole, rescuerAddressOS, rescuerBasicSkills;
    private Button save;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data_database);

        fullnameRescuer = findViewById(R.id.receive_Name);
        DOBRes = findViewById(R.id.receive_DOB);
        EmailRes = findViewById(R.id.receive_email);
        phoneNumberRes = findViewById(R.id.receive_PhoneNumber);
        rescuerOrganization = findViewById(R.id.receive_UserOrganization);
        rescuerRole = findViewById(R.id.receive_UserRole);
        rescuerAddressOS = findViewById(R.id.receive_OrgAddress);
        rescuerBasicSkills = findViewById(R.id.receive_BasicSkills);
        save = findViewById(R.id.SaveData_Button);
        progressBar = findViewById(R.id.progressBarRescuerSaveData);

        //getting data from the inputs from rescuer_serviceprofile and rescuer_signup
        Intent intent = getIntent();
        String data = intent.getStringExtra("keyUsername");
        String dataEmail = intent.getStringExtra("keyEmail");
        String dataDOB = intent.getStringExtra("keyDOB");
        String dataPhoneNumber = intent.getStringExtra("keyPhoneNumber");
        String dataOrgName= intent.getStringExtra("keyOrgName");
        String dataRole= intent.getStringExtra("keyRole");
        String dataOrgAddress= intent.getStringExtra("keyAddressOS");
        String databasicSkill= intent.getStringExtra("keyselectedSkill");

        if (data != null){
            fullnameRescuer.setText(data);
        } else if (dataEmail != null) {
            EmailRes.setText(dataEmail);

        } else if (dataDOB !=null) {
            DOBRes.setText(dataDOB);

        } else if (dataPhoneNumber !=null) {
            phoneNumberRes.setText(dataPhoneNumber);

        }  else if (dataOrgName !=null) {
            rescuerOrganization.setText(dataOrgName);

        } else if (dataRole != null) {
            rescuerRole.setText(dataRole);

        } else if (dataOrgAddress !=null) {
            rescuerAddressOS.setText(dataOrgAddress);

        } else if (databasicSkill != null) {
            rescuerBasicSkills.setText(databasicSkill);

        } else{
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "Something went wrong in getting your information!", Toast.LENGTH_SHORT).show();
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(SaveData_Database.this);
                ReadWriteUserDetails readWriteUserDetails = new ReadWriteUserDetails(data, dataEmail, dataDOB, dataPhoneNumber);
                dbHelper.addNewRescuer(readWriteUserDetails);

                DBService dbService =  new DBService(SaveData_Database.this);
                ReadWriteService readWriteService = new ReadWriteService(dataOrgName, dataRole, dataOrgAddress, databasicSkill);
                dbService.addServiceRescuer(readWriteService);

                Toast.makeText(SaveData_Database.this, "Account Successfully Made", Toast.LENGTH_SHORT).show();

                //Transfer activity
                Intent intent = new Intent(SaveData_Database.this, Rescuer_HomeScreenActivity.class);
                startActivity(intent);

            }
        });

    }
}