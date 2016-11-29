package com.example.contentprivate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/28.
 */
public class MySQLite extends SQLiteOpenHelper{


    public MySQLite(Context context){
        super(context,"per.db",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person(_id integer primary key autoincrement , name varchar(20) , age integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
