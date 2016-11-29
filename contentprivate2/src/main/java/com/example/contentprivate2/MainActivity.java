package com.example.contentprivate2;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver resolver = getContentResolver();
        Uri uri = Uri.parse("content://com.example.contentprivate");
        Cursor c = resolver.query(uri, null, null, null, null);
        tv = (TextView) findViewById(R.id.act_tv);
        tv.setText(c.toString());
    }
}
