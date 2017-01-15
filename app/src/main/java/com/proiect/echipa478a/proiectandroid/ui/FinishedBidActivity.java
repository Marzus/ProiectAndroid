package com.proiect.echipa478a.proiectandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItem;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItemManager;

public class FinishedBidActivity extends AppCompatActivity {

    private Button returnToMainBtn;
    private ImageView signatureView;
    private TextView itemName;
    private TextView itemPrice;
    private BidItem biddedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_bid);

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        int bidItemID = extra.getInt("ITEM_ID");

        signatureView = (ImageView) findViewById(R.id.finishBidSignatureView);
        itemName = (TextView) findViewById(R.id.finishBidItemName);
        itemPrice = (TextView) findViewById(R.id.finishBidItemPrice);

        biddedItem = BidItemManager.getBidItemById(bidItemID);

        signatureView.setImageBitmap(biddedItem.getOwnerSignature());
        itemName.setText(biddedItem.getItemName());
        itemPrice.setText(biddedItem.getPrice().toString());

        returnToMainBtn = (Button) findViewById(R.id.returnToMainBtn);
        returnToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
