package com.example.emergencyapplication.Rescuer_Registration;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ProgressBar;
import android.os.Handler;
import android.widget.EditText;

import android.app.ProgressDialog;

import com.example.emergencyapplication.SaveData_Database;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.squareup.picasso.Picasso;;
import java.util.UUID;
import android.os.Bundle;

import com.example.emergencyapplication.R;

public class Rescuer_VerificationActivity extends AppCompatActivity {

    private static final int Pick_Image_Request = 1;

    private Uri verifyUri;
    ProgressBar progressBar;

    private ActivityResultLauncher<String> mGetContentLauncher;
    ImageView imageVerify;

    private EditText filename;
    Button selectPhoto, uploadPhoto, nextStartProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescuer_verification);

        imageVerify = findViewById(R.id.imageVerify3);
        uploadPhoto = findViewById(R.id.UploadPhotobtn);
        progressBar = findViewById(R.id.progressBarRescuer3);
        filename = findViewById(R.id.editFileName);


        selectPhoto = findViewById(R.id.RSelectPhoto);
        selectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFile();
            }
        });

        mGetContentLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        if (result != null) {
                            // Handle the selected image here
                            verifyUri = result;
                            Picasso.with(Rescuer_VerificationActivity.this).load(verifyUri).into(imageVerify);
                        }
                    }
                });

        nextStartProfile = findViewById(R.id.RescuerNextConfirmation);
        nextStartProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentConfirm = new Intent(Rescuer_VerificationActivity.this, SaveData_Database.class);
                intentConfirm.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentConfirm);
            }
        });
    }


    private void chooseFile() {
        mGetContentLauncher.launch("image/*");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Pick_Image_Request && resultCode == RESULT_OK && data != null && data.getData() != null) {
            verifyUri = data.getData();
            Picasso.with(this).load(verifyUri).into(imageVerify);
        }

    }
}