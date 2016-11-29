package com.example.contentprivate;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db = new MySQLite(this).getReadableDatabase();
        ContentValues v = new ContentValues();
        v.put("name","小明");
        v.put("age",20);
        db.insert("person",null,v);
    }
}
