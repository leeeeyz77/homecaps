package com.example.homecapsapp;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CaptureShowActivity extends AppCompatActivity {

    ImageView load;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captureshow);
        load = (ImageView)findViewById(R.id.loadimg);
        //액티비티에서 사용할 이미지 뷰
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReference();
        StorageReference pathReference = storageReference.child("photo");
        if(pathReference==null){
            Toast.makeText(CaptureShowActivity.this, "저장소에 사진이 없습니다.", Toast.LENGTH_SHORT).show();

        }else{
            StorageReference submitProfile = storageReference.child("Photo/IMG_0378.jpeg");
            submitProfile.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(CaptureShowActivity.this).load(uri).into(load);
                    //url로 이미지 받아서 올림
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }
    }
}
