package com.proiect.echipa478a.proiectandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItem;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItemManager;

public class BidItemActivity extends AppCompatActivity {

    private TextView bidItemNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_item);



        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        int bidItemID = extra.getInt("BidItemID");
        BidItem bidItem = BidItemManager.getBidItemById(bidItemID);

        bidItemNameText = (TextView) findViewById(R.id.bidItemName);
        bidItemNameText.setText(bidItem.getItemName());


    }
}
