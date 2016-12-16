package com.proiect.echipa478a.proiectandroid.custom.persistency.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Marius on 12/12/2016.
 */

public class ItemsTable {
    public static final String TABLE_NAME = "Items";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String PRICE = "price";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE = "image";
    public static final String SELLER = "seller";
    public static final String SHIPPING_COST = "shipping";
    public static final String ITEM_LOCATION = "item_location"; // postal_code + country


    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT, "
            + PRICE + " REAL, "
            + IMAGE + " BLOB, "
            + SELLER + " TEXT, "
            + SHIPPING_COST + " TEXT, "
            + ITEM_LOCATION + " TEXT, "
            + DESCRIPTION + " TEXT);";

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
