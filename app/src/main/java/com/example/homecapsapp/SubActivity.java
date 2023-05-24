package com.example.homecapsapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    WebView webView;
    WebSettings webSettings;
    Button callText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //webView = (WebView) webView.findViewById(R.id.cctv);
        //webSettings=webView.getSettings();
        //webSettings.setJavaScriptEnabled(true);

        // webView.loadData("<html><head><style type='text/css'>body{margin:auto auto;text-align:center;}"+
        //        "img{width:100%25;}div{overflow:hidden;}</style></head>"+
        //        "<body><div><img src=''/></div></body></html>","text/html","UTF-8");

        callText = (Button)findViewById(R.id.callText);
        callText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SubActivity.this);
                builder.setTitle("신고");
                builder.setMessage("신고하시겠습니까?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:112"));
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });
    }
}

