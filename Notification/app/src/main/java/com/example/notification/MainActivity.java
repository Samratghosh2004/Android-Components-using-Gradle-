package com.example.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "My Channel";
    private static final int NOTIFICATION_ID = 1001;


    private static final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // It mainly uses in service class


        //Drawable icon = ResourcesCompat.getDrawable(getResources(),R.drawable.ic_launcher_background,null);

//****** IMAGE SHOULD BE IN    PNG   FORMAT FOR LARGE ICON *******

        //BitmapDrawable b = (BitmapDrawable)icon;
        //Bitmap largeIcon = b.getBitmap();


        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification n;
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi = PendingIntent.getActivity(this,REQ_CODE,i,PendingIntent.FLAG_UPDATE_CURRENT);


        // Style
        // Big Picture Style
        // Inbox Style
        Notification.InboxStyle inbox = new Notification.InboxStyle().addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A");


if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {
    n = new Notification.Builder(this)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentText("New Message")
            .setSubText("Message from someone")
            .setContentIntent(pi)
            //The channel Id will not work for less than android 8 versions; therefore it is required to add a if condition before building notification
            .setChannelId(CHANNEL_ID)
            .setStyle(inbox)
            .setAutoCancel(false)
            .build();

}
else {
    n = new Notification.Builder(this)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentText("New Message")
            .setSubText("Message from someone")
            .setContentIntent(pi)
            // opposite of setAutoCancel
            .setOngoing(true)
            .build();
}

            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel",NotificationManager.IMPORTANCE_HIGH));
            nm.notify(NOTIFICATION_ID, n);
    }

}