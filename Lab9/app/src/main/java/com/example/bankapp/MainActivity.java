package com.example.bankapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText fullName, emailId, password, confirmPassword;
    private Button signUpButton;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        }else{
            Log.i("permission","granted");
        }
        progress = new ProgressDialog(this);
        signUpButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                signupfinal();
                                            }
                                        }

        );
    }

    private void initViews() {
        fullName = (EditText) findViewById(R.id.fullName);
        emailId = (EditText) findViewById(R.id.userEmailId);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);
        signUpButton = (Button) findViewById(R.id.signUpBtn);
    }
    public void signupfinal() {
        if (TextUtils.isEmpty(fullName.getText())) {
            fullName.setError("Name is required");
        } else if (TextUtils.isEmpty(emailId.getText())) {
            emailId.setError("EmailId is required");
        } else if (TextUtils.isEmpty(password.getText())) {
            password.setError("Password is required");
        } else if (TextUtils.isEmpty(confirmPassword.getText())) {
            confirmPassword.setError("Confirm Password is required");
        } else if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
            Toast.makeText(MainActivity.this, "Confirm password is not same. ", Toast.LENGTH_SHORT).show();
        } else {
            progress.setMessage("Signing Up! ...");
            progress.show();
            progress.dismiss();
            Intent intent = new Intent(MainActivity.this, VerifyOtp.class);
            intent.putExtra("name", fullName.getText().toString());
            intent.putExtra("Email", emailId.getText().toString());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}