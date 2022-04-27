package com.example.CameraStorage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 10001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mycam;

        mycam = findViewById(R.id.cambtm);

        int permissionCamera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (permissionCamera != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, CAMERA_REQUEST);
            Toast.makeText(MainActivity.this, "Camera Permission is required for this app to run", Toast.LENGTH_SHORT)
                    .show();

        }



        mycam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent cam = new Intent(MainActivity.this, camera.class);
                    startActivity(cam);


            }
        });



    }

}