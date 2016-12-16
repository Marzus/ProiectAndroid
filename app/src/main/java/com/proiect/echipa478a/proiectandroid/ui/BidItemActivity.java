package com.proiect.echipa478a.proiectandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.adapters.ExpandableListAdapter;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItem;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItemManager;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem.ItemLocation;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem.Seller;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem.ShippingOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BidItemActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView bidItemNameText;
    private ExpandableListAdapter listAdapter;
    private ExpandableListView elView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private int numberOfHeaders = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_item);



        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        int bidItemID = extra.getInt("BidItemID");

        BidItem bidItem = BidItemManager.getBidItemById(bidItemID);

        if(bidItem != null) {
            bidItemNameText = (TextView) findViewById(R.id.bidItemName);
            bidItemNameText.setText(bidItem.getItemName());

            //handle expandable list
            elView = (ExpandableListView) findViewById(R.id.expandableListView);
            createElView(bidItem);
            listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
            elView.setAdapter(listAdapter);

            Toast.makeText(this, "Click on items to show more info.", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "This record is not synchronized.", Toast.LENGTH_LONG).show();
            finish();
        }



    }

    private void createElView(BidItem bidItem) {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();
        numberOfHeaders = 0;

        addItemPriceInfo(bidItem, listDataHeader, listDataChild);
        addItemSellerInfo(bidItem, listDataHeader, listDataChild);
        addItemLocation(bidItem, listDataHeader, listDataChild);
        addItemShippingOptions(bidItem, listDataHeader, listDataChild);
    }

    private void addItemShippingOptions(BidItem bidItem, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        ShippingOptions shippingOptions = bidItem.getShippingOptions();
        listDataHeader.add("Shipping Options");
        List<String> arrayList = new ArrayList<>();
        String shippingCostTypeBuilder = "Shipping Cost Type: ";
        String shippingCostBuilder = "Shipping Cost: ";
        if(shippingOptions != null && shippingOptions.getShippingCostType() != null){
            shippingCostTypeBuilder += shippingOptions.getShippingCostType();
        }
        if(shippingOptions != null && shippingOptions.getShippingCost() != null) {
            shippingCostBuilder += shippingOptions.getShippingCost().getValue();
        }
        arrayList.add(shippingCostTypeBuilder);
        arrayList.add(shippingCostBuilder);
        // keep track of position with numberOfHeaders attribute
        listDataChild.put(listDataHeader.get(numberOfHeaders++), arrayList);
    }

    private void addItemSellerInfo(BidItem bidItem, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        Seller seller = bidItem.getSeller();
        listDataHeader.add("Seller Info");
        List<String> arrayList = new ArrayList<>();
        String userNameBuild = "Username: ";
        if(seller != null && seller.getUsername() != null) {
            userNameBuild += seller.getUsername();
        }
        arrayList.add(userNameBuild);
        // keep track of position with numberOfHeaders attribute
        listDataChild.put(listDataHeader.get(numberOfHeaders++), arrayList);
    }

    private void addItemPriceInfo(BidItem bidItem, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        String price = bidItem.getPrice().toString();
        listDataHeader.add("Price");
        List<String> arrayList = new ArrayList<>();
        arrayList.add(price);
        // keep track of position with numberOfHeaders attribute
        listDataChild.put(listDataHeader.get(numberOfHeaders++), arrayList);
    }

    private void addItemLocation(BidItem bidItem, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        ItemLocation itemLocation = bidItem.getItemLocation();
        listDataHeader.add("Location Info");
        List<String> arrayList = new ArrayList<>();
        String itemLocationBuilder = "Country: ";
        String itemLocationPostalCode = "Postal Code: ";
        if(itemLocation != null && itemLocation.getCountry() != null) {
            itemLocationBuilder += itemLocation.getCountry();
        }
        if(itemLocation != null && itemLocation.getPostalCode() != null) {
            itemLocationPostalCode += itemLocation.getPostalCode();
        }
        arrayList.add(itemLocationBuilder);
        arrayList.add(itemLocationPostalCode);
        // keep track of position with numberOfHeaders attribute
        listDataChild.put(listDataHeader.get(numberOfHeaders++), arrayList);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, FinishedBidActivity.class);
        startActivity(intent);
        finish();
    }
}
