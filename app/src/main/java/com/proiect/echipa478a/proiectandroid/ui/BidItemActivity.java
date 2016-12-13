package com.proiect.echipa478a.proiectandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItem;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItemManager;

public class BidItemActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView bidItemNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_item);



        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        int bidItemID = extra.getInt("BidItemID");

        //TODO handle when records are not synced
        BidItem bidItem = BidItemManager.getBidItemById(bidItemID);

        if(bidItem != null) {
            bidItemNameText = (TextView) findViewById(R.id.bidItemName);
            bidItemNameText.setText(bidItem.getItemName());
        } else {
            Toast.makeText(this, "This record is not synchronized.", Toast.LENGTH_LONG).show();
            finish();
        }


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, FinishedBidActivity.class);
        startActivity(intent);
        finish();
    }
}
