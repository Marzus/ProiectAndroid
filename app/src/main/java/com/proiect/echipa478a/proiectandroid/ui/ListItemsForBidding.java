package com.proiect.echipa478a.proiectandroid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.connection.DownloadImageURL;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItem;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItemManager;

public class ListItemsForBidding extends AppCompatActivity {

    private Button addBtn;
    private TextView addNameTV;
    private TextView addPriceTV;
    private TextView addImageTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items_for_bidding);

        //handle the intent if needed
        //Intent intent = getIntent();

        addBtn = (Button) findViewById(R.id.addBtn);
        addNameTV = (TextView) findViewById(R.id.addNameEditText);
        addPriceTV = (TextView) findViewById(R.id.addPriceEditText);
        addImageTV = (TextView) findViewById(R.id.addImageURL);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = addNameTV.getText().toString().trim();
                double itemPrice = -1;
                String imageUrl = "";

                if(itemName.isEmpty()) {
                    addNameTV.setText("");
                    addNameTV.setError("Invalid name");
                    return;
                }
                try {
                    itemPrice = Double.valueOf(addPriceTV.getText().toString());
                } catch(NumberFormatException e) {
                    addPriceTV.setText("");
                    addPriceTV.setError("Invalid number");
                    return;
                }
                if(itemPrice <= 0) {
                    addPriceTV.setText("");
                    addPriceTV.setError("Price can't be negative");
                    return;
                }

                BidItem bidItem = new BidItem(itemName, itemPrice, null);

                imageUrl = addImageTV.getText().toString().trim();
                if(!imageUrl.isEmpty()) { //TODO check if the link is valid
                    DownloadImageURL downloadImageTask = new DownloadImageURL(ListItemsForBidding.this, bidItem);
                    downloadImageTask.execute(imageUrl);
                    //downloadImageTask.execute("http://icons-search.com/img/icons-land/IconsLandVistaStyleEmoticonsDemo.zip/IconsLandVistaStyleEmoticonsDemo-PNG-256x256-Cool.png-256x256.png");
                } else {
                    BidItemManager.addLocalBidItem(bidItem);
                    Toast.makeText(ListItemsForBidding.this, bidItem.getItemName() + " added.", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}
