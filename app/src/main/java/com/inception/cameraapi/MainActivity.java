package com.inception.cameraapi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    private void dispatchTakePictureIntent() {

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(i.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(i, REQUEST_IMAGE_CAPTURE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();

            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ImageView image_view = findViewById(R.id.profile_image);

            image_view.setImageBitmap(imageBitmap);
        }
    }

    public void open_camera(View view) {

        dispatchTakePictureIntent();
    }
}
