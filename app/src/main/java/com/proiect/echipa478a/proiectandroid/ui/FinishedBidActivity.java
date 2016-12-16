package com.proiect.echipa478a.proiectandroid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.proiect.echipa478a.proiectandroid.R;

public class FinishedBidActivity extends AppCompatActivity {

    Button returnToMainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_bid);

        returnToMainBtn = (Button) findViewById(R.id.returnToMainBtn);
        returnToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
