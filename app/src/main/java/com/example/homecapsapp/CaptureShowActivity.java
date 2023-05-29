package com.example.homecapsapp;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

public class CaptureShowActivity extends AppCompatActivity {

    ImageView load;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captureshow);
        ImageView im1, im2, im3;

        im1 = (ImageView)findViewById(R.id.iv1);
        im2 = (ImageView)findViewById(R.id.iv2);
        im3 = (ImageView)findViewById(R.id.iv3);



        //액티비티에서 사용할 이미지 뷰
//        FirebaseStorage storage = FirebaseStorage.getInstance();
//        StorageReference storageReference = storage.getReference();
//        StorageReference pathReference = storageReference.child("gs://homecaps.appspot.com/Photo");

        StorageReference listRef = FirebaseStorage.getInstance().getReference().child("Photo");
        listRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                int i=0;
                for(StorageReference item : listResult.getItems()){
/*                    LinearLayout layout = (LinearLayout) findViewById(R.id.maskImageLayout);

                    ImageView iv = new ImageView(CaptureShowActivity.this);
                    iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    layout.addView(iv);*/
                    i++;
                    getSupportActionBar().setTitle("item is : "+i);

                    switch (i){
                        case 1:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im1);
                                    }
                                }
                            });
                        case 2:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im2);
                                    }
                                }
                            });
                        case 3:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im3);
                                    }
                                }
                            });




/*                    item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if (task.isSuccessful()){
                                Glide.with(CaptureShowActivity.this).load(task.getResult()).into(iv);
                            }else{
                                Toast.makeText(CaptureShowActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });*/
                }



            }
        }
    });
}}
