package com.proiect.echipa478a.proiectandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

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

        BiddingItemsListAdapter<String> itemsArrayAdapter = new BiddingItemsListAdapter<>(this, BidItemManager.getBidItemsList());

        itemsListView.setAdapter(itemsArrayAdapter);
    }

    @Override
    public void onClick(View view) {
        BidItemManager.synchronizeBidItemsRecords(this);
    }
}
