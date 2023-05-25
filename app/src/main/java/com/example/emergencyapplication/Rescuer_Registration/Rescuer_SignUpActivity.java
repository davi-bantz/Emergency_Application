package com.example.emergencyapplication.Rescuer_Registration;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.emergencyapplication.R;
import com.example.emergencyapplication.SaveData_Database;

public class Rescuer_SignUpActivity extends AppCompatActivity {

    private EditText editRegisterName, editdob, editRescuerPhoneNumber, editTextEmail, editRegisterPass, editConfirmPass;
    private ProgressBar progressBar;
    private DatePickerDialog birthdatepicker;
    private Button Next;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescuer_sign_up);

        //Assign the things
        progressBar = findViewById(R.id.progressBarCitizen);
        editRegisterName = findViewById(R.id.editUser_Name);
        editdob = findViewById(R.id.editdob);
        editRescuerPhoneNumber = findViewById(R.id.editRescuerPhoneNumber);
        editTextEmail = findViewById(R.id.editUserName1);
        editRegisterPass = findViewById(R.id.editPassword);
        editConfirmPass = findViewById(R.id.editConfirmPass);

        //set up date picker
        editdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar dateofbirth = Calendar.getInstance();
                int dayofbirth = dateofbirth.get(Calendar.DAY_OF_MONTH);
                int monthofbirth = dateofbirth.get(Calendar.MONTH);
                int yearofbirth = dateofbirth.get(Calendar.YEAR);

                //datepicker dialog
                birthdatepicker = new DatePickerDialog(Rescuer_SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        editdob.setText(dayofbirth + "/" + (monthofbirth + 1) + "/" + yearofbirth);
                    }

                }, yearofbirth, monthofbirth, dayofbirth);
                birthdatepicker.show();

            }
        });

        //Button
        Next = findViewById(R.id.NextToServiceProfile);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Obtain entered details
                String textFullName = editRegisterName.getText().toString();
                String textdob = editdob.getText().toString();
                String textPhoneNumber = editRescuerPhoneNumber.getText().toString();
                String textEmail = editTextEmail.getText().toString();
                String textPassword = editRegisterPass.getText().toString();
                String textConfirmPassword = editConfirmPass.getText().toString();

                //validate the phone number
                String mobileNumber = "((^(\\+)(\\d){12}$)|(^\\d{11}$))";
                Matcher mobilematcher;
                Pattern mobilePatt = Pattern.compile(mobileNumber);
                mobilematcher = mobilePatt.matcher(textPhoneNumber);

                if (TextUtils.isEmpty(textFullName)) {
                    Toast.makeText(Rescuer_SignUpActivity.this, "Please enter your Full Name", Toast.LENGTH_LONG).show();
                    editRegisterName.setError("Full Name is Required");
                    editRegisterName.requestFocus();

                } else if (TextUtils.isEmpty(textdob)) {
                    Toast.makeText(Rescuer_SignUpActivity.this, "Please enter your Age", Toast.LENGTH_LONG).show();
                    editdob.setError("Age is Required");
                    editdob.requestFocus();

                } else if (TextUtils.isEmpty(textPhoneNumber)) {
                    Toast.makeText(Rescuer_SignUpActivity.this, "Please enter your Phone Number", Toast.LENGTH_LONG).show();
                    editRescuerPhoneNumber.setError("Phone Number is Required");
                    editRescuerPhoneNumber.requestFocus();
                } else if (textPhoneNumber.length() != 11) {
                    Toast.makeText(Rescuer_SignUpActivity.this, "Please re-enter your Phone Number", Toast.LENGTH_LONG).show();
                    editRescuerPhoneNumber.setError("Phone Number must be 11 digits");
                    editRescuerPhoneNumber.requestFocus();
                } else if (!mobilematcher.find()) {
                    Toast.makeText(Rescuer_SignUpActivity.this, "Please re-enter your Phone Number", Toast.LENGTH_LONG).show();
                    editRescuerPhoneNumber.setError("Phone Number is not valid");
                    editRescuerPhoneNumber.requestFocus();

                } else if (TextUtils.isEmpty(textEmail)) {
                    Toast.makeText(Rescuer_SignUpActivity.this, "Please enter your Email", Toast.LENGTH_LONG).show();
                    editTextEmail.setError("Email is Required");
                    editTextEmail.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                    Toast.makeText(Rescuer_SignUpActivity.this, "Please re-enter your Email", Toast.LENGTH_LONG).show();
                    editTextEmail.setError("Valid Email is Required");
                    editTextEmail.requestFocus();

                } else if (TextUtils.isEmpty(textPassword)) {
                    Toast.makeText(Rescuer_SignUpActivity.this, "Please enter your Password", Toast.LENGTH_LONG).show();
                    editRegisterPass.setError("Password is Required");
                    editRegisterPass.requestFocus();
                } else if (textPassword.length() < 8) {
                    Toast.makeText(Rescuer_SignUpActivity.this, "Password should be at least 8 digits", Toast.LENGTH_LONG).show();
                    editRegisterPass.setError("Password too weak");
                    editRegisterPass.requestFocus();
                } else if (TextUtils.isEmpty(textConfirmPassword)) {
                    Toast.makeText(Rescuer_SignUpActivity.this, "Please confirm your Password", Toast.LENGTH_LONG).show();
                    editConfirmPass.setError("Password Confirmation is Required");
                    editConfirmPass.requestFocus();
                } else if (!textPassword.equals(textConfirmPassword)) {
                    Toast.makeText(Rescuer_SignUpActivity.this, "Please re-confirm Password", Toast.LENGTH_LONG).show();
                    editConfirmPass.setError("Password does not match");
                    editConfirmPass.requestFocus();
                    editRegisterPass.clearComposingText();
                    editConfirmPass.clearComposingText();

                } else {
                    progressBar.setVisibility(view.VISIBLE);

                    sendInfo(textFullName, textEmail, textdob, textPhoneNumber);


                }
            }
        });
    }

    private void sendInfo(String textFullName, String textEmail, String textdob, String textPhoneNumber) {

        //Transfer Data to SaveDatabaseActivity
        Intent senddata = new Intent(Rescuer_SignUpActivity.this, SaveData_Database.class);
        senddata.putExtra("keyUsername", textFullName);
        senddata.putExtra("keyEmail", textEmail);
        senddata.putExtra("keyDOB", textdob);
        senddata.putExtra("keyPhoneNumber", textPhoneNumber);
        startActivity(senddata);

        //Transfer to Service Profile Sign Up
        Intent intent = new Intent(Rescuer_SignUpActivity.this, Rescuer_ServiceProfileActivity.class);
        startActivity(intent);
    }

}