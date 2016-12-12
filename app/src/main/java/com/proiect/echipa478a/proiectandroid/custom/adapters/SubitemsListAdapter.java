package com.proiect.echipa478a.proiectandroid.custom.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.proiect.echipa478a.proiectandroid.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Marius on 12/12/2016.
 */

public class SubitemsListAdapter<T> extends ArrayAdapter {
    List<String> itemsList;
    Map<String,Double> items;
    private Activity context;

    public SubitemsListAdapter(Activity context, Map<String, Double> items) {
        super(context, android.R.layout.two_line_list_item);
        this.context = context;
        this.items = items;

        itemsList = new ArrayList<>();
        for(String item : items.keySet()) {
            itemsList.add(item);
        }
        this.addAll(itemsList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.bid_item, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.bidItem);
        txtTitle.setText(itemsList.get(position));
        TextView subItemTxt = (TextView) rowView.findViewById(R.id.bidSubItem);
        subItemTxt.setText("Price: " + items.get(itemsList.get(position)));
        Button bidButton = (Button) rowView.findViewById(R.id.bidBtn);

        bidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO handle the on click for items
            }
        });

        return rowView;
    }
}
