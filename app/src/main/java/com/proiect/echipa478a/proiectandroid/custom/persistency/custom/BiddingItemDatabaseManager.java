package com.proiect.echipa478a.proiectandroid.custom.persistency.custom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;

import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItem;
import com.proiect.echipa478a.proiectandroid.custom.persistency.DatabaseManager;
import com.proiect.echipa478a.proiectandroid.custom.persistency.tables.ItemsTable;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by Marius on 12/12/2016.
 */

public class BiddingItemDatabaseManager extends DatabaseManager {


    public BiddingItemDatabaseManager(Context context) {
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

    public void insertRecords(List<BidItem> biddingItemRecords) {
        for(BidItem item : biddingItemRecords){
            insertRecord(item);
        }
    }

    public void insertRecord(BidItem item) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ItemsTable.COLUMN_NAME, item.getItemName());
        contentValues.put(ItemsTable.PRICE, item.getPrice());
        if(item.getImage() != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            item.getImage().compress(Bitmap.CompressFormat.PNG, 100, stream);
            contentValues.put(ItemsTable.IMAGE, stream.toByteArray());
        }
        contentValues.put(ItemsTable.DESCRIPTION, item.getDescription());
        if(item.getSeller() != null) {
            contentValues.put(ItemsTable.SELLER, item.getSeller().getUsername());
        }
        if(item.getItemLocation() != null) {
            contentValues.put(ItemsTable.ITEM_LOCATION, item.getItemLocation().getCountry() + " - " + item.getItemLocation().getPostalCode());
        }
        if(item.getShippingOptions() != null && item.getShippingOptions().getShippingCost() != null
                && item.getShippingOptions().getShippingCost().getValue() != null
                && item.getShippingOptions().getShippingCost().getCurrency() != null) {
            contentValues.put(ItemsTable.SHIPPING_COST, item.getShippingOptions().getShippingCost().getValue()
                    + " - " + item.getShippingOptions().getShippingCost().getCurrency());
        }


        super.insertRecords(ItemsTable.TABLE_NAME, contentValues);
    }

    public Cursor retrieveRecords() {
        return super.retrieveRecords(ItemsTable.TABLE_NAME);
    }

    public void deleteRecords(String sqlWHERE, String[] matchQuestionMarks) {
        //int result = sqLiteDatabase.delete(MOVIE_TABLE, MOVIE_GENRE + " = ?", new String[] {"Comedy"});
        super.deleteRecords(ItemsTable.TABLE_NAME, sqlWHERE, matchQuestionMarks);
    }


    public void updateRecordsByTheSameClause(List<BidItem> biddingItemRecords, String sqlWHERE, String[] matchQuestionMarks) {
        for(BidItem item : biddingItemRecords){
            updateRecord(item, sqlWHERE, matchQuestionMarks);
        }
    }

    public void updateRecord(BidItem bidItem, String sqlWHERE, String[] matchQuestionMarks) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ItemsTable.COLUMN_NAME, bidItem.getItemName());
        contentValues.put(ItemsTable.PRICE, bidItem.getPrice());
        if(bidItem.getImage() != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bidItem.getImage().compress(Bitmap.CompressFormat.PNG, 100, stream);
            contentValues.put(ItemsTable.IMAGE, stream.toByteArray());
        }
        contentValues.put(ItemsTable.DESCRIPTION, bidItem.getDescription());
        contentValues.put(ItemsTable.SELLER, bidItem.getSeller().getUsername());
        contentValues.put(ItemsTable.ITEM_LOCATION, bidItem.getItemLocation().getCountry() + " - " + bidItem.getItemLocation().getPostalCode());
        contentValues.put(ItemsTable.SHIPPING_COST, bidItem.getShippingOptions().getShippingCost().getValue()
                + " - " + bidItem.getShippingOptions().getShippingCost().getCurrency());

        super.updateRecords(ItemsTable.TABLE_NAME, contentValues, sqlWHERE, matchQuestionMarks);

    }

    public void updateRecordsByID(List<BidItem> biddingItemRecords) {
        for(BidItem item : biddingItemRecords){
            updateRecordByID(item);
        }
    }

    public void updateRecordByID(BidItem item) {
        updateRecord(item, ItemsTable.COLUMN_ID + " = ? ", new String[] {item.getId() + ""});
    }

    public Cursor retrieveMaxRecordID() {
        String sql = "SELECT max(" + ItemsTable.COLUMN_ID + ") AS _id FROM " + ItemsTable.TABLE_NAME + ";";
        //String[] selectionArgs = new String[] { ItemsTable.TABLE_NAME};
        return super.retrieveRawQuery(sql, null);
    }


    //never use!
    private void deleteAllRecords() {
        deleteRecords("1=1", null);
    }
}
