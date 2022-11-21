package com.example.thirdmounthhome_3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button addPhotoButton;
    ImageView imageView,imageView2,imageView3,imageView4;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addPhotoButton=findViewById(R.id.gallery_btn);
        imageView=findViewById(R.id.profile);
        imageView2=findViewById(R.id.profile2);
        imageView3=findViewById(R.id.profile3);
        imageView4=findViewById(R.id.profile4);

        ActivityResultLauncher<Intent> imagepickResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Uri photoUri = result.getData().getData();
                    imageView.setImageURI(photoUri);
                    imageView2.setImageURI(photoUri);
                    imageView3.setImageURI(photoUri);
                    imageView4.setImageURI(photoUri);


                }
            }
        });



        addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, Images.Media.EXTERNAL_CONTENT_URI);
                imagepickResult.launch(intent);
            }
        });
    }
}