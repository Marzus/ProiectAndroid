package com.proiect.echipa478a.proiectandroid.custom.datapojo;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.proiect.echipa478a.proiectandroid.custom.persistency.custom.BiddingItemDatabaseManager;
import com.proiect.echipa478a.proiectandroid.custom.persistency.tables.ItemsTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marius on 12/12/2016.
 */

public class BidItemManager {
    private static Map<Integer, BidItem> _syncedBidItems = new HashMap<>();
    private static List<BidItem> localBidItems = new ArrayList<>();

    // methods private used only in this class for synchronization
    private static void addBidItem(BidItem bidItem) {
        _syncedBidItems.put(bidItem.getId(), bidItem);
    }
    private static void addBidItemList(List<BidItem> bidItemsList) {
        for(BidItem item : bidItemsList) {
            _syncedBidItems.put(item.getId(), item);
        }
    }

    // public methods for handling purposes
    public static void addLocalBidItem(BidItem bidItem) {
        localBidItems.add(bidItem);
    }
    private static void addLocalBidItemList(List<BidItem> bidItemsList) {
        localBidItems = bidItemsList;
    }

    //method that synchronizes records in database
    public static void synchronizeBidItemsRecords(Context context) {
        BiddingItemDatabaseManager itemDatabaseManager = new BiddingItemDatabaseManager(context);
        itemDatabaseManager.open();
        List<BidItem> bidItemsList = new ArrayList<>(getAllBidItemsList());

        Cursor cursor = itemDatabaseManager.retrieveMaxRecordID();
        int highestId = -1;
        if(cursor != null) {
            cursor.moveToFirst();
            highestId = cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_ID));
        }

        for(BidItem item : bidItemsList) {
            if(item.getId() > highestId || item.getId() == -1) {
                itemDatabaseManager.insertRecord(item);
                getLocalBidItems().remove(item);
            } else {
                if(!item.synced) {
                    item.synced = true;
                    itemDatabaseManager.updateRecordByID(item);
                }
            }
        }

        Cursor retrieveCursor = itemDatabaseManager.retrieveRecords();
        //retrieveCursor.moveToFirst();
        while(retrieveCursor.getPosition() < retrieveCursor.getCount()-1) {
            retrieveCursor.moveToNext();
            addBidItem(buildRecordFromDB(retrieveCursor));
        }

        itemDatabaseManager.close();
    }

    private static BidItem buildRecordFromDB(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_ID));
        String itemName = cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_NAME));
        double itemPrice = cursor.getDouble(cursor.getColumnIndex(ItemsTable.PRICE));
        byte[] byteArray = cursor.getBlob(cursor.getColumnIndex(ItemsTable.IMAGE));

        BidItem item = new BidItem(itemName, itemPrice, null);

        if(byteArray != null) {
            Bitmap itemImage = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            item.setImage(itemImage);
        }

        item.id = id;
        item.synced = true;

        return item;
    }

    public static BidItem getBidItemById(int id) {
        return _syncedBidItems.get(id);
    }

    public static ArrayList<BidItem> getBidItemsList() {
        return new ArrayList<>(_syncedBidItems.values());
    }

    public static List<BidItem> getLocalBidItems() {
        return localBidItems;
    }


    public static List<BidItem> getAllBidItemsList() {
        List<BidItem> allItemsList = new ArrayList<>(localBidItems);
        allItemsList.addAll(_syncedBidItems.values());

        return allItemsList;
    }

    // TODO handles this methods to remove the record from DB too
    public static void deleteBidItem(BidItem bidItem) {
        deleteBidItem(bidItem.getId());
    }
    public static void deleteBidItem(int i) {
        _syncedBidItems.remove(i);
    }


}
