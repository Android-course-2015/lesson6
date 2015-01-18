package com.example.dima_2.lesson5;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Dima_2 on 16.01.2015.
 */
public class ItemsTable {
    public static final String TABLE_NAME = "ITEMS_TABLE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PUB_DATE = "pub_date";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_LINK = "link";
    public static final String COLUMN_CHANNEL_ID = "channel_id";

    private static final String DATABASE_CREATE = "create table if not exists " + TABLE_NAME
            + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TITLE + " text, "
            + COLUMN_DESCRIPTION + " text, "
            + COLUMN_PUB_DATE + " text, "
            + COLUMN_LINK + " text, "
            + COLUMN_CHANNEL_ID + " integer not null, "
            + "foreign key (" + COLUMN_CHANNEL_ID + ") references "
            + Table.TABLE_NAME + "(" + Table.COLUMN_ID + ")"
            + ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }
}