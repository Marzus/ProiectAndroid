package com.proiect.echipa478a.proiectandroid.custom.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItem;
import com.proiect.echipa478a.proiectandroid.ui.BidItemActivity;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Marius on 12/12/2016.
 */

public class BiddingItemsListAdapter<T> extends ArrayAdapter {
    List<BidItem> items;
    private Activity context;

    public BiddingItemsListAdapter(Activity context, List<BidItem> items) {
        super(context, android.R.layout.two_line_list_item);
        this.context = context;
        this.items = items;

        this.addAll(items);
    }

    @NonNull
    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.bid_item, parent, false);
        final BidItem localBidItem = this.items.get(position);

        //handle the item image
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        /*TODO set the image when the BidItem supports them
        * imageView.setImageBitmap(localBidItem.getImage());
        *
        **/

        //handle the item name
        TextView txtTitle = (TextView) rowView.findViewById(R.id.bidItem);
        txtTitle.setText(localBidItem.getItemName());
        //handle the item price
        TextView subItemTxt = (TextView) rowView.findViewById(R.id.bidSubItem);
        String formattedPrice = new DecimalFormat("##.##").format(localBidItem.getPrice());
        subItemTxt.setText("Price: " + formattedPrice);
        //handle the item buton
        Button bidButton = (Button) rowView.findViewById(R.id.bidBtn);

        bidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BidItemActivity.class);

                Bundle extraForId = new Bundle();
                extraForId.putInt("BidItemID", localBidItem.getId());

                intent.putExtras(extraForId);

                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
