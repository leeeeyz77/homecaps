package com.example.homecapsapp;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.btn1);
        Button button2 = findViewById(R.id.btn2);


        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view)
            {
                createNotification();

            }
        });
    }

    private void createNotification(){

        Intent intent = new Intent(getApplicationContext(), SubActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder =  new NotificationCompat.Builder(this, "default");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("움직임감지");
        builder.setContentText("누군가가 감지되었습니다");
        builder.setColor(Color.RED);
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT));
        }

        notificationManager.notify(1, builder.build());

    }



}