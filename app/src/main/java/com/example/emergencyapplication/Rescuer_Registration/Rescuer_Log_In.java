package com.example.emergencyapplication.Rescuer_Registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.util.Log;
import android.widget.ImageView;
import android.text.method.HideReturnsTransformationMethod;
import 	android.text.method.PasswordTransformationMethod;

import com.example.emergencyapplication.RescuerProfile.Rescuer_HomeScreenActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.text.TextUtils;
import android.widget.Toast;



import com.example.emergencyapplication.R;

public class Rescuer_Log_In extends AppCompatActivity {

    //Define the parts of activity
    private EditText emailAdd, PassWD;
    private ProgressBar progressBarLogIn;

    private Button login;

    private static final String TAG = "LogIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescuer_log_in2);

        //find views of activity
        emailAdd = findViewById(R.id.editLoginEmailAddress);
        PassWD = findViewById(R.id.editLoginPassword);
        progressBarLogIn = findViewById(R.id.progressBarLogIn);
        login = findViewById(R.id.Login);






        //forgotPass
        Button forgotPass =  findViewById(R.id.buttonForgotPassEmail);
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Rescuer_Log_In.this, "You can reset your password now", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Rescuer_Log_In.this, forgotPassword.class));
            }
        });

        //When the rescuer want to open Sign up
        Button signUp = findViewById(R.id.Sign_Up_Rescuer);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Rescuer_Log_In.this, "You can Register Now", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Rescuer_Log_In.this, Rescuer_SignUpActivity.class));
            }
        });

        //showhidePassword
        ImageView imageviewHidepassword = findViewById(R.id.Hide_ShowPassword);
        imageviewHidepassword.setImageResource(R.drawable.ic_hide_pwd);
        imageviewHidepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PassWD.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){

                    //If the password is visible then hide it
                    PassWD.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //Change Icon
                    imageviewHidepassword.setImageResource(R.drawable.ic_hide_pwd);
                }else{
                    PassWD.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageviewHidepassword.setImageResource(R.drawable.ic_show_pwd);

                }
            }
        });

        //Define button for log in
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textemail = emailAdd.getText().toString();
                String textPwd = PassWD.getText().toString();

                //if the user has not entered any data
                if(TextUtils.isEmpty(textemail)) {
                    Toast.makeText(Rescuer_Log_In.this, "Please enter your Email", Toast.LENGTH_SHORT).show();
                    emailAdd.setError("Email is required");
                    emailAdd.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(textemail).matches()) {
                    Toast.makeText(Rescuer_Log_In.this, "Please re-enter your Email", Toast.LENGTH_LONG).show();
                    emailAdd.setError("Valid Email is Required");
                    emailAdd.requestFocus();
                } else if (TextUtils.isEmpty(textPwd)) {
                    Toast.makeText(Rescuer_Log_In.this, "Please enter your Password", Toast.LENGTH_SHORT).show();
                    PassWD.setError("Password is required");
                    PassWD.requestFocus();
                }else{
                    progressBarLogIn.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}