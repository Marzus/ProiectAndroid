package com.proiect.echipa478a.proiectandroid.custom.datapojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marius on 12/12/2016.
 */

public class BidItemManager {
    private static Map<Integer, BidItem> _mappedBidItems = new HashMap<>();

    public static void addBidItem(BidItem bidItem) {
        _mappedBidItems.put(bidItem.getId(), bidItem);
    }

    public static void addBidItemList(List<BidItem> bidItemsList) {
        for(BidItem item : bidItemsList) {
            _mappedBidItems.put(item.getId(), item);
        }
    }

    public static BidItem getBidItemById(int id) {
        return _mappedBidItems.get(id);
    }

    public static ArrayList<BidItem> getBidItemsList() {
        return new ArrayList<>(_mappedBidItems.values());
    }

    public static void deleteBidItem(BidItem bidItem) {
        deleteBidItem(bidItem.getId());
    }

    public static void deleteBidItem(int i) {
        _mappedBidItems.remove(i);
    }

}
