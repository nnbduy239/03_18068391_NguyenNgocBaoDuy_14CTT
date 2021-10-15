package com.iuh.a03_18068391_nguyenngocbaoduy_14ctt;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

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
        sendNotification();
        return START_NOT_STICKY;
    }

    private void sendNotification() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
