package com.example.newbroadcast;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1,tv2;
    private EditText et1 , et2;
    private Button btn;
    private SmsManager smsManager;
    ReceiverSmsReceiver rsr ;
    MyReceiver my = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textview_3);
        tv2 = (TextView) findViewById(R.id.textview_4);
        et1 = (EditText) findViewById(R.id.edittext_1);
        et2 = (EditText) findViewById(R.id.edittext_2);
        btn = (Button) findViewById(R.id.button_1);
        smsManager = SmsManager.getDefault();
        rsr= new ReceiverSmsReceiver(tv1,tv2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
    }

    private void send() {
        String number = et1.getText().toString();
        String content = et2.getText().toString();
        PendingIntent intent =PendingIntent.getBroadcast(this,0,new Intent("com.vince.sms.MY_ACTION"),0);
        smsManager.sendTextMessage(number,null,content,intent,null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentf = new IntentFilter();
        intentf.addAction("com.vince.sms.MY_ACTION");
        registerReceiver(my,intentf);

        IntentFilter intent2 = new IntentFilter();
        intent2.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(rsr,intent2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(my);
    }
}
