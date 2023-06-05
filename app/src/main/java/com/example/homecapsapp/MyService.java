package com.example.homecapsapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

public class MyService extends Service {

    private static final String TAG = "FileCountService";

    private Handler handler;
    private Runnable runnable;
    private StorageReference storageReference;
    private int previousFileCount;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        storageReference = FirebaseStorage.getInstance().getReference();
        previousFileCount = 0;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        runnable = new Runnable() {
            @Override
            public void run() {
                checkFileCount();
                handler.postDelayed(this, 5000); // 5초마다 파일 수 확인
            }
        };
        handler.postDelayed(runnable, 0); // 서비스 시작 시 즉시 실행
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable); // 서비스 종료 시 작업 중지
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void checkFileCount() {
        storageReference.listAll()
                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                    @Override
                    public void onSuccess(ListResult listResult) {
                        int currentFileCount = listResult.getItems().size();
                        //Log.d(TAG, "Current file count: " + currentFileCount);

                        if (currentFileCount > previousFileCount) {
                            int newFileCount = currentFileCount - previousFileCount;
                            Log.d(TAG, "New files created: " + newFileCount);
                            // 새로운 파일이 생성되었을 때 필요한 작업 수행
                            // 예: 알림 생성, 이벤트 발생 등
                            noti();


                        }

                        previousFileCount = currentFileCount;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Failed to retrieve file count: " + e.getMessage());
                    }
                });
    }

    private void noti(){

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
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