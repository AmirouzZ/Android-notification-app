package com.example.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View v) {
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                Context context = MainActivity.this;
                Intent intent = new Intent(context, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this);
                mBuilder.setSmallIcon(android.R.drawable.star_big_on);
                mBuilder.setTicker("This is show rounding ... ");
                mBuilder.setContentTitle("Notification Alert, Click me");
                mBuilder.setContentText("Hi, This is Android Notifaication Details !");
                mBuilder.setSound(Uri.parse("android.resource://com.example.notification/" + R.raw.wisp));
                mBuilder.setContentIntent(pendingIntent);
                Notification notification = mBuilder.build();
                nm.notify(0, notification);
            }
        });
    }
}