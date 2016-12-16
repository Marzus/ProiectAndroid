package com.proiect.echipa478a.proiectandroid.custom.persistency.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Marius on 12/16/2016.
 */

public class UsersTable {
    public static final String TABLE_NAME = "Users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String EMAIL = "email";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + EMAIL + " TEXT, "
            + COLUMN_NAME + " TEXT);";

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
