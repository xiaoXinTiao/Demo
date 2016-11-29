package com.example.newbroadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
      if (getResultCode()== Activity.RESULT_OK){
          Toast.makeText(context, "短信发送成功", Toast.LENGTH_SHORT).show();
      }else{
          Toast.makeText(context, "短信发送失败", Toast.LENGTH_SHORT).show();
      }
    }
}
