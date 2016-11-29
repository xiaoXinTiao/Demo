package com.example.alarmmamager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1 , btn2;
    AlarmManager am;
    PendingIntent pi;
    AlarmReceiver  ar = new  AlarmReceiver();
    public static final String MY_ACTION = "com.vince.MY_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button_1);
        btn2 = (Button) findViewById(R.id.button_2);
        am = (AlarmManager) getSystemService(MainActivity.this.ALARM_SERVICE);
        Intent intent = new Intent(MY_ACTION);
        intent.putExtra("getup","Get up...  Get up...");
        pi = PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alaem();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    private void cancel() {
        unregisterReceiver(ar);
        am.cancel(pi);
    }

    private void alaem() {
        long triggerAtTime = System.currentTimeMillis();
        am.setRepeating(AlarmManager.RTC_WAKEUP,triggerAtTime,100,pi);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter fi = new IntentFilter();
        fi.addAction(MY_ACTION);
        registerReceiver(ar,fi);
    }
}
