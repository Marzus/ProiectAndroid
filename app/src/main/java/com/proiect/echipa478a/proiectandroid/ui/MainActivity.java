package com.proiect.echipa478a.proiectandroid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.adapters.SubitemsListAdapter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView itemsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsListView = (ListView) findViewById(R.id.itemsListView);

        Map<String, Double> dummyItems = new HashMap<>();

        dummyItems.put("item 1", 2.18);
        dummyItems.put("item 2", 3.10);
        dummyItems.put("item 3", 34D);

        SubitemsListAdapter<String> itemsArrayAdapter = new SubitemsListAdapter<>(this, dummyItems);

        itemsListView.setAdapter(itemsArrayAdapter);
    }
}
