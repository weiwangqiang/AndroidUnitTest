package com.demo.demoaunittest.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/**
 * create by wei on 2020-01-03
 */
public class BookSqLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "demo.db";
    private static final int DATABASE_VERSION = 1;

    public BookSqLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public BookSqLite(@Nullable Context context,
                      @Nullable String name,
                      @Nullable SQLiteDatabase.CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists " + BookTable.tableName
            + " ( "
            + BookTable.id + " VARCHAR(20) unique,"
            + BookTable.name + " VARCHAR(20) );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
