package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class VerifyOtp extends AppCompatActivity {

    private EditText phoneNo,otpText;
    private Button sendOtp,signIn;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        phoneNo = (EditText) findViewById(R.id.userphoneno);
        otpText = (EditText) findViewById(R.id.otpText);
        sendOtp = (Button) findViewById(R.id.getotp);
        signIn = (Button) findViewById(R.id.signIn);

        sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(phoneNo.getText())) {
                    phoneNo.setError("Enter phone no");
                }else {
                    Random random = new Random();
                    message = String.format("%04d", random.nextInt(10000));
                    otpText.setVisibility(View.VISIBLE);
                    sendOtp.setVisibility(View.GONE);
                    signIn.setVisibility(View.VISIBLE);
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo.getText().toString(), null, message, null, null);

                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(otpText.getText())) {
                    otpText.setError("Enter Otp");
                }else if(otpText.getText().toString().equals(message)){
                    Toast.makeText(VerifyOtp.this, "Signed In Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(VerifyOtp.this, Profile.class);
                    Intent intent2 = getIntent();
                    intent.putExtra("name", intent2.getStringExtra("name"));
                    intent.putExtra("Email", intent2.getStringExtra("Email"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });



    }
}