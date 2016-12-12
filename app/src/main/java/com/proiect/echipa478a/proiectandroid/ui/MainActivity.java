package com.proiect.echipa478a.proiectandroid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.adapters.BiddingItemsListAdapter;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItem;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItemManager;

public class MainActivity extends AppCompatActivity {

    private ListView itemsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        itemsListView = (ListView) findViewById(R.id.itemsListView);

        // dummy items
        for(int i = 1; i <= 10; i++) {
            BidItemManager.addBidItem(new BidItem(i, "Item " + i, Math.random()*100, null));
        }

        BiddingItemsListAdapter<String> itemsArrayAdapter = new BiddingItemsListAdapter<>(this, BidItemManager.getBidItemsList());

        itemsListView.setAdapter(itemsArrayAdapter);
    }
}
