package com.example.homecapsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class dialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ImageView bigiv;
        bigiv = (ImageView)findViewById(R.id.bigIV);

        Intent intent = getIntent();
        Uri uri = intent.getParcelableExtra("url");
        Glide.with(dialogActivity.this).load(uri).into(bigiv);


    ;}
}