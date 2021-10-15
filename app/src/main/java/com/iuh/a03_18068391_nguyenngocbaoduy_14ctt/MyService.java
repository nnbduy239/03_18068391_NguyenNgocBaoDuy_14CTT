package com.iuh.a03_18068391_nguyenngocbaoduy_14ctt;

import static com.iuh.a03_18068391_nguyenngocbaoduy_14ctt.AppNotification.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    private  MyBinder binder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }
        @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        sendNotification();
        return START_NOT_STICKY;
    }

    private void sendNotification() {
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.custom_noficationlayout);
//        remoteViews.setTextViewText(R.id.tvTitle,number.getTitle());

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Ap tinh toan")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public  int Add(int a, int b){
        int result;
        result = a+b;
        return result;
    }
    public  int Mul(int a, int b){
        int result;
        result = a-b;
        return result;
    }
    public  double Div(int a, int b){
        double result;
        result = a/b;
        return result;
    }
    public  int Sub(int a, int b){
        int result;
        result = a*b;
        return result;
    }
}
