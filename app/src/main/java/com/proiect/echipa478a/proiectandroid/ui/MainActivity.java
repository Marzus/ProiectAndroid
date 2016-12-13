package com.proiect.echipa478a.proiectandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.proiect.echipa478a.proiectandroid.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Switch syncSwitch;
    private TextView syncInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        syncInfoTextView = (TextView) findViewById(R.id.syncInfoTextView);
        syncSwitch = (Switch) findViewById(R.id.syncSwitch);
        syncSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    compoundButton.setText("Auto Sync On");
                    syncInfoTextView.setText(R.string.auto_sync_on_description);
                } else {
                    compoundButton.setText("Auto Sync Off");
                    syncInfoTextView.setText(R.string.auto_sync_off_description);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.bidOnItemsBtn:
                intent = new Intent(this, BiddingListActivity.class);
                Bundle extra = new Bundle();
                if(syncSwitch.isChecked())
                    extra.putBoolean("AutoSync", true);
                else
                    extra.putBoolean("AutoSync", false);
                intent.putExtras(extra);
                startActivity(intent);
                break;
            case R.id.listItemBtn:
                intent = new Intent(this, ListItemsForBidding.class);
                startActivity(intent);
                break;
        }
    }
}
