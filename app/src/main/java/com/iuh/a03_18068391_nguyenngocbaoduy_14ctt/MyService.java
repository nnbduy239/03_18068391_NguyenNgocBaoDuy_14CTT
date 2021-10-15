package com.iuh.a03_18068391_nguyenngocbaoduy_14ctt;

import static com.iuh.a03_18068391_nguyenngocbaoduy_14ctt.AppNotification.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    public static final  int ACTION_SUB=1;
    private static final  int ACTION_MUL =2;
    private static final  int ACTION_DIV =3;
    public static final  int ACTION_ADD =4;

    Number number;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String number1 = intent.getStringExtra("number1");
        String number2 = intent.getStringExtra("number2");
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
}
