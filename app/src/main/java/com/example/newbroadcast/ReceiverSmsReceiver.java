package com.example.newbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiverSmsReceiver extends BroadcastReceiver {
    SmsMessage sm;
    private TextView tv1,tv2;
    public ReceiverSmsReceiver(TextView tv1,TextView tv2) {
        this.tv1 = tv1;
        this.tv2 = tv2;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            Object [] objects = (Object[]) bundle.get("pdus");
            SmsMessage [] messages = new SmsMessage[objects.length];
            for (int i =0;i<objects.length;i++){
                messages [i] = SmsMessage.createFromPdu((byte[]) objects[i]);
            }
            for (SmsMessage message:messages){
                sm = message;
                String number = sm.getDisplayOriginatingAddress();
                String content = sm.getDisplayMessageBody();
                Toast.makeText(context, number+":"+content, Toast.LENGTH_SHORT).show();
                tv1.setText(number);
                tv2.setText(content);
            }
        }
    }
}
