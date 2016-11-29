package com.example.contentprivate;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/10/28.
 */
public class MyContentPrivate extends ContentProvider{
    private SQLiteDatabase db;
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return db.query("person",projection,selection,selectionArgs,null,null,sortOrder);
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return "";
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        db = new MySQLite(getContext()).getReadableDatabase();
        db.insert("person",null,values);
        return uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return db.delete("person",selection,selectionArgs);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return db.update("person",values,selection,selectionArgs);
    }
}
