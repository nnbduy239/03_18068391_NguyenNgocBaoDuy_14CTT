package com.iuh.a03_18068391_nguyenngocbaoduy_14ctt;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class AppNotification extends Application {
    public static final  String CHANNEL_ID ="channel_services";
    public static final  String CHANNEL_NAME ="Channel Services";
    @Override
    public void onCreate() {
        super.onCreate();
        createChanelNotification();
    }

    private void createChanelNotification() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager =getSystemService(NotificationManager.class);
            if(manager !=null) {
                manager.createNotificationChannel(channel);
            }
        }
    }
}
