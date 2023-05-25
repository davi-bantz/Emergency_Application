package com.example.emergencyapplication.Rescuer_Registration;


import static android.R.layout.simple_list_item_multiple_choice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.emergencyapplication.R;
import com.example.emergencyapplication.SaveData_Database;

import java.util.ArrayList;

public class Rescuer_ServiceProfileActivity extends AppCompatActivity {

    private EditText department, role, adressOfStation;
    private ProgressBar progressBar;
    private Button buttonVerify;

    private SearchView searchBasicSkill;
    private ListView basicSkillsList;

    ArrayList<String> basicskills;

    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescuer_service_profile);

        buttonVerify = findViewById(R.id.Rescuer_Next_To_Verification);
        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Declare Layout Reference
                progressBar = findViewById(R.id.progressBarRescuer2);
                department = findViewById(R.id.editRescuerDepOrg);
                role = findViewById(R.id.editRescuerSpecialization);
                adressOfStation = findViewById(R.id.editResAddressDepOrg);
                basicSkillsList = findViewById(R.id.ListView_BasicSkills);


                //Convert to String
                String textDepartment = department.getText().toString();
                String textRole = role.getText().toString();
                String textAddressOS = adressOfStation.getText().toString();

                if (TextUtils.isEmpty(textDepartment)) {
                    Toast.makeText(Rescuer_ServiceProfileActivity.this, "Please enter the Department/Organization you are assigned", Toast.LENGTH_LONG).show();
                    department.setError("Department/Organization is Required");
                    department.requestFocus();
                } else if (TextUtils.isEmpty(textRole)) {
                    Toast.makeText(Rescuer_ServiceProfileActivity.this, "Please enter your Role/Specialization in your Organization/Department", Toast.LENGTH_LONG).show();
                    role.setError("Role is Required");
                    role.requestFocus();
                } else if (TextUtils.isEmpty(textAddressOS)) {
                    Toast.makeText(Rescuer_ServiceProfileActivity.this, "Please enter the address of your assigned station", Toast.LENGTH_LONG).show();
                    adressOfStation.setError("Address of Station is Required");
                    adressOfStation.requestFocus();

                } else {
                    progressBar.setVisibility(View.VISIBLE);

                    //Transfer Data to the Final Activity before Saving to Database
                    Intent sendServicedata = new Intent(Rescuer_ServiceProfileActivity.this, SaveData_Database.class);
                    sendServicedata.putExtra("keyOrgName", textDepartment);
                    sendServicedata.putExtra("keyRole", textRole);
                    sendServicedata.putExtra("keyAddressOS", textAddressOS);
                    startActivity(sendServicedata);

                }

                //Array list
                basicskills = new ArrayList<>();
                basicskills.add("Basic First Aid");
                basicskills.add("CPR");
                basicskills.add("Search and Rescue");
                basicskills.add("Knot Tying");
                basicskills.add("Casualty Handling");

                arrayAdapter =  new ArrayAdapter<>(Rescuer_ServiceProfileActivity.this, simple_list_item_multiple_choice, basicskills);
                basicSkillsList.setAdapter(arrayAdapter);

                //search Filter
                searchBasicSkill = findViewById(R.id.Search_View_BasicSkill);
                searchBasicSkill.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        arrayAdapter.getFilter().filter(newText);
                        return false;
                    }
                });
                progressBar.setVisibility(View.GONE);

                //for sending the selected items to the save database activity
                basicSkillsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        String selectedSkill = basicskills.get(position);

                        Intent sendskill = new Intent(Rescuer_ServiceProfileActivity.this, SaveData_Database.class);
                        getIntent().putExtra("keyselectedSkill", selectedSkill);
                        startActivity(sendskill);

                    }
                });
                progressBar.setVisibility(View.GONE);

                //Go to the Verification
                Intent gotoVerify = new Intent(Rescuer_ServiceProfileActivity.this, Rescuer_VerificationActivity.class);
                startActivity(gotoVerify);
            }

        });


    }
}