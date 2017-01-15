package com.proiect.echipa478a.proiectandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.adapters.BiddingItemsListAdapter;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItemManager;

public class BiddingListActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView itemsListView;
    private boolean autoSync;
    private Button manualSyncBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidding_list);

        //handle the received intent
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        autoSync = extras.getBoolean("AutoSync");

        itemsListView = (ListView) findViewById(R.id.itemsListView);

        if(autoSync) {
            manualSyncBtn = (Button) findViewById(R.id.syncBtn);
            manualSyncBtn.setEnabled(false);
            BidItemManager.synchronizeBidItemsRecords(this);
        }



        /*if(BidItemManager.getAllBidItemsList().size() <= 0) {
            Toast.makeText(BiddingListActivity.this, "No records. Add an item first", Toast.LENGTH_LONG).show();
            for(int i = 1; i <= 3; i++) {
                BidItem dummyItem = new BidItem("Dummy Item " + i, Math.random() * 100, null);
                Seller seller = new Seller();
                seller.setUsername("Guest");
                dummyItem.setSeller(seller);
                BidItemManager.addLocalBidItem(dummyItem);
            }
        }*/

        BiddingItemsListAdapter<String> itemsArrayAdapter = new BiddingItemsListAdapter<>(this, BidItemManager.getAllBidItemsList());

        itemsListView.setAdapter(itemsArrayAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(autoSync) {
            BidItemManager.synchronizeBidItemsRecords(this);
        }
        BiddingItemsListAdapter<String> itemsArrayAdapter = new BiddingItemsListAdapter<>(this, BidItemManager.getAllBidItemsList());
        itemsListView.setAdapter(itemsArrayAdapter);
    }

    @Override
    public void onClick(View view) {
        BidItemManager.synchronizeBidItemsRecords(this);

        BiddingItemsListAdapter<String> itemsArrayAdapter = new BiddingItemsListAdapter<>(this, BidItemManager.getAllBidItemsList());

        if(BidItemManager.getAllBidItemsList().size() <= 0) {
            Toast.makeText(BiddingListActivity.this, "No records. Add an item first", Toast.LENGTH_LONG).show();
        }

        itemsListView.setAdapter(itemsArrayAdapter);

    }
}
