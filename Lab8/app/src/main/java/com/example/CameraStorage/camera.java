package com.example.CameraStorage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class camera extends AppCompatActivity {
    private static final int Image_Capture_Code = 1;
    Button retry, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, Image_Capture_Code);
        retry = findViewById(R.id.retry);
        back = findViewById(R.id.back);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, Image_Capture_Code);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(camera.this, MainActivity.class);
                startActivity(back);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Image_Capture_Code && resultCode == RESULT_OK && data != null) {
            Bitmap image;
            image = (Bitmap) data.getExtras().get("data");
            Intent intent = new Intent(camera.this, gallery.class);
            intent.putExtra("image", image);
            setResult(RESULT_OK, intent);
            startActivity(intent);
        }
    }
}

