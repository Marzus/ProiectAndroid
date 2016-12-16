package com.proiect.echipa478a.proiectandroid.custom.persistency.custom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.proiect.echipa478a.proiectandroid.custom.datapojo.User;
import com.proiect.echipa478a.proiectandroid.custom.persistency.DatabaseManager;
import com.proiect.echipa478a.proiectandroid.custom.persistency.tables.UsersTable;

import java.util.List;

/**
 * Created by Marius on 12/16/2016.
 */

public class UserDatabaseManager extends DatabaseManager {

    public UserDatabaseManager(Context context) {
        super(context);
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    public void close() {
        super.close();
    }

    public void insertUsers(List<User> users) {
        for(User user : users){
            insertRecord(user);
        }
    }

    public long insertRecord(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UsersTable.COLUMN_NAME, user.getName());
        contentValues.put(UsersTable.EMAIL, user.getEmail());


        return super.insertRecords(UsersTable.TABLE_NAME, contentValues);
    }

    public Cursor retrieveRecords() {
        return super.retrieveRecords(UsersTable.TABLE_NAME);
    }

    public void deleteRecords(String sqlWHERE, String[] matchQuestionMarks) {
        super.deleteRecords(UsersTable.TABLE_NAME, sqlWHERE, matchQuestionMarks);
    }


    public void updateRecordsByTheSameClause(List<User> users, String sqlWHERE, String[] matchQuestionMarks) {
        for(User user : users){
            updateRecord(user, sqlWHERE, matchQuestionMarks);
        }
    }

    public void updateRecord(User user, String sqlWHERE, String[] matchQuestionMarks) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(UsersTable.COLUMN_NAME, user.getName());
        contentValues.put(UsersTable.EMAIL, user.getEmail());

        super.updateRecords(UsersTable.TABLE_NAME, contentValues, sqlWHERE, matchQuestionMarks);

    }

    public void updateRecordsByID(List<User> users) {
        for(User user : users){
            updateRecordByID(user);
        }
    }

    public void updateRecordByID(User user) {
        updateRecord(user, UsersTable.COLUMN_ID + " = ? ", new String[] {user.getUserID() + ""});
    }

    public Cursor retrieveMaxRecordID() {
        String sql = "SELECT max(" + UsersTable.COLUMN_ID + ") AS _id FROM " + UsersTable.TABLE_NAME + ";";
        //String[] selectionArgs = new String[] { ItemsTable.TABLE_NAME};
        return super.retrieveRawQuery(sql, null);
    }


    //never use!
    private void deleteAllRecords() {
        deleteRecords("1=1", null);
    }
}
