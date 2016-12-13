package com.proiect.echipa478a.proiectandroid.custom.persistency;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.proiect.echipa478a.proiectandroid.custom.persistency.tables.ItemsTable;

/**
 * Created by Marius on 12/12/2016.
 */

public class DatabaseManager {

    private BiddingDataUtility bdbUtility;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public DatabaseManager(Context context) {
        this.context = context;
        this.bdbUtility = new BiddingDataUtility(context);
    }

    protected void open() {
        sqLiteDatabase = bdbUtility.getWritableDatabase();
    }

    protected void close() {
        sqLiteDatabase.close();
    }

    public class BiddingDataUtility extends SQLiteOpenHelper {

        private static final String DB_NAME = "BiddingItems.db";
        private static final int DB_VERS = 1;

        public BiddingDataUtility(Context context) {
            super(context, DB_NAME, null, DB_VERS);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            /*for(String create_table : this.create_table_SQLs) {
                sqLiteDatabase.execSQL(create_table);
            }*/
            // register all tables here
            ItemsTable.onCreate(sqLiteDatabase);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            // register all tables here
            ItemsTable.onUpgrade(sqLiteDatabase, oldVersion, newVersion);
        }
    }

    // handle data

    protected void insertRecords(String TABLE_NAME, ContentValues contentValues) {
        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    protected Cursor retrieveRecords(String TABLE_NAME) {
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null, null, null, null, null);

        return cursor;
    }

    protected Cursor retrieveRawQuery(String sql, String[] selectionArgs) {
        Cursor cursor = sqLiteDatabase.rawQuery(sql, selectionArgs);

        return cursor;
    }

    protected void deleteRecords(String TABLE_NAME, String sqlWHERE, String[] matchQuestionMarks) {
        int result = sqLiteDatabase.delete(TABLE_NAME, sqlWHERE, matchQuestionMarks);
    }

    protected void updateRecords(String TABLE_NAME, ContentValues contentValues, String sqlWHERE, String[] matchQuestionMarks) {
        int result = sqLiteDatabase.update(TABLE_NAME, contentValues, sqlWHERE, matchQuestionMarks);
    }

}
