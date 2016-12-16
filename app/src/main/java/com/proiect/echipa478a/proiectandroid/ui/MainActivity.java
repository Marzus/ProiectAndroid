package com.proiect.echipa478a.proiectandroid.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.connection.tasks.DownloadImageURL;
import com.proiect.echipa478a.proiectandroid.custom.connection.webservices.EbayItemService;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItem;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItemManager;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.User;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem.EbayItemJson;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem.ItemSummaries;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public final static int REQUEST_LOGIN = 1;

    public final String AppIDClientID = "MariusDu-Universi-SBX-345f8a2bd-5122902f";
    public final String DevID = "8cb6b9b6-f726-4c9e-86a7-9257a68f3891";
    public final String CertID = "SBX-45f8a2bd32db-c32c-4b8b-b8c5-f67f";

    public final String OAuthToken = "v^1.1#i^1#p^1#I^3#r^0#f^0#t^H4sIAAAAAAAAAOVXXWwUVRTuttvWQoFgiDaAukwJijiz87e7s5PukG0LoUB/YNvaYgiZnbmzHTo7M869Q7sJxrYgCcqPgiHhBSpBfZDIi0oMaiISH4gJiQhRgSjyoIgx2hgFxeid6VK21UCF1ZA4L5N7zrnnfuc759wfeqCi6tEty7b8Mi1QWTo8QA+UBgLMVLqqonzR9LLS2eUldIFBYHhg/kBwqOybOihnDVtcDaBtmRCE+rOGCUVfmCBcxxQtGepQNOUsgCJSxFSyeaXIUrRoOxayFMsgQk2NCSIWAwrDgxgXEdS4LPBYal732W4lCB5wQoynlRgbT3ORGMB6CF3QZEIkmyhBsDQTJRmWZCLtLCOyvMjHKU4Q1hChTuBA3TKxCUUTkg9X9Oc6BVhvDlWGEDgIOyGkpuTSVGuyqXFJS3tduMCXlOchhWTkwvGjBksFoU7ZcMHNl4G+tZhyFQVASISl0RXGOxWT18HcBnyfakUAfCzOpjWFowU+WhQml1pOVkY3h+FJdJXUfFMRmEhHuVsRislIrwcKyo9asIumxpD3W+XKhq7pwEkQS+qT3cm2NkJqlh3dhY0u2WHqGzywZKq+i+T4iCbIbFolIwzLxmlWyy806i3P8oSVGixT1T3OYKjFQvUAowYTuWEKuMFGrWark9SQh6jQjrvOIR9d4+V0NIku6jG9tIIsJiLkD2+dgbHZCDl62kVgzMNEhU9RgpBtW1eJiUq/FPPV0w8TRA9CthgO9/X1UX0cZTmZMEvTTLireWVK6QFZmfBsvV737fVbTyB1PxQFdym2F1HOxlj6caliAGaGkNgoz8ToPO/jYUkTpX8RFMQcHt8QxWoQTkkrcU6NAU3WhLQaKUaHSPkiDXs4QFrOkVnZ6QXINmQFkAquMzcLHF0VuYjGcoIGSDUa10g+rmlkOqLi9TQAaADSGJrwf2qUyZZ6g6FjZTsuteLUe7FqfZkFEVAnW+t/G1pKsWzQZhm6kvtvYvN6fbLxcY7aJjsoV+/m8DgFDAP/7ihcxc/kumJtXMVK5D/smduLXZfR3RU1wwuMwMVoIX5nceH7zF0Vl2JlKW8bphzZRpZDYWi2ASDlAGi5Dr5/Ua3eodxu9QITb3HIsQwDOJ3MHbEAvUa+u3joCQ4exS4g9iHb+iglmJuwJePoPdE6H3SoZxJG4bSbozIugAgDUYHzLxzw4fGvDanE/5ihwLv0UOBt/GChYzTJLKIXVpR1BMuqCagjgHNrqmmrn9JljYJ6xsSXaQdQvSBny7pTWhFovrit++mCd87wWrpm7KVTVcZMLXj20HNvaMqZGfdPY6IMy0RYhuX5+Bq69oY2yNwXnFW7mfjuyrzzI73bNh1E1eVz3ct9R+lpY0aBQHlJcChQsnqw4ar0R/TqnLoTD4HzK7pqTz6XuXdKaLh6UOfp16KD29/o3np2/+Izc1YY16QFP4Nv91GvZ36UOmdnnr3ny8PZujk1DT9tbvl89cZHHj644NgrSw7VXLuw/KXH35nHpL7fe+Tai2fpC78tvGx+1rFrxw/PGJVnqjqVZbsSGy52RGtffb53+p7dH2yuPzbbtSpHhtaeOxI/Xj5jcaB/+yc1u5dvHDi1dGvXnhd2Hgfdbd0zq/efnrv4ZenNj+z5s8JTVxnrHzg9M0OfW7fqyt4vAH/0wQMjJzc+duLKk0/s//VQc8id7n696fdLb1XMq32q6f0Z70kf128L7N2x6cDuKacqgx9eonaM2PsOf9r/1Wga/wRSHFsigQ4AAA==";

    public final String API = "https://api.sandbox.ebay.com";

    private Switch syncSwitch;
    private TextView syncInfoTextView;
    private Button ebayBtn;
    private ProgressDialog progressDialog;

    private Button registerBtn;

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

        ebayBtn = (Button) findViewById(R.id.ebayItemsBtn);

        ebayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hardKeyWord = "phone";
                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API).build();
                EbayItemService ebayItemService = restAdapter.create(EbayItemService.class);

                MainActivity.this.progressDialog = new ProgressDialog(MainActivity.this);
                MainActivity.this.progressDialog.setMessage("Processing Request...");
                MainActivity.this.progressDialog.show();

                ebayItemService.getItemsByKeyWord(hardKeyWord, new Callback<EbayItemJson>() {

                    @Override
                    public void success(EbayItemJson ebayItemJson, Response response) {
                        if (MainActivity.this.progressDialog.isShowing()) {
                            MainActivity.this.progressDialog.dismiss();
                        }
                        ItemSummaries[] itemSummaries = ebayItemJson.getItemSummaries();
                        for(int i = 0; i < 10; i++) {
                            BidItem bidItem = new BidItem(itemSummaries[i].getTitle(), Double.valueOf(itemSummaries[i].getPrice().getValue()),
                                    null);
                            bidItem.setItemLocation(itemSummaries[i].getItemLocation());
                            bidItem.setSeller(itemSummaries[i].getSeller());
                            bidItem.setShippingOptions(itemSummaries[i].getShippingOptions()[0]);
                            if(itemSummaries[i].getImage() != null) {
                                if(itemSummaries[i].getImage().getImageUrl() != null) {
                                    DownloadImageURL downloadImageTask = new DownloadImageURL(MainActivity.this, bidItem);
                                    downloadImageTask.execute(itemSummaries[i].getImage().getImageUrl());
                                }
                            } else {
                                if(bidItem != null)
                                    BidItemManager.addLocalBidItem(bidItem);
                            }
                        }



                    }

                    @Override
                    public void failure(RetrofitError error) {
                        ConnectivityManager cm =
                                (ConnectivityManager)MainActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);

                        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                        boolean isConnected = activeNetwork != null &&
                                activeNetwork.isConnectedOrConnecting();

                        if (MainActivity.this.progressDialog.isShowing()) {
                            MainActivity.this.progressDialog.dismiss();
                        }
                        if(!isConnected) {
                            Toast.makeText(MainActivity.this, "No network connection! Please connect to a network.",
                                    Toast.LENGTH_LONG).show();
                        } else if(error.getMessage().equals("401 Unauthorized") && error.getKind().name().equals("HTTP")) {
                            Toast.makeText(MainActivity.this, "Unauthorized access! Please contact the owner of the app.",
                                    Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Service is unreachable. Try again later",
                                    Toast.LENGTH_LONG).show();
                        }


                    }
                });
            }
        });

        //Login activity if there is no user logged.


        if(User.getUserLogged() == null && !User.isGuestUser()) {
            loginMethod(LoginActivity.NO_USER_LOGGED);
        }

        registerBtn = (Button) findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(User.getUserLogged() == null && !User.isGuestUser()) {
                    loginMethod(LoginActivity.NO_USER_LOGGED);
                } else if(User.getUserLogged() == null && User.isGuestUser()) {
                    loginMethod(LoginActivity.NO_USER_LOGGED);
                } else if(User.getUserLogged() != null && !User.isGuestUser()) {
                    loginMethod(LoginActivity.REGISTER_OTHER_USER);
                }
            }
        });

    }

    private void loginMethod(String methodToLogin) {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        loginIntent.setAction(methodToLogin);
        startActivityForResult(loginIntent, REQUEST_LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == REQUEST_LOGIN) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK && data.getAction().equals(LoginActivity.SIGN_IN_AS_GUEST)) {
                Toast.makeText(this, "You have signed in as guest.", Toast.LENGTH_SHORT).show();
                registerBtn = (Button) findViewById(R.id.registerBtn);
                registerBtn.setText("Register");
            } else if(resultCode == RESULT_OK && data.getAction().equals(LoginActivity.LOGIN_SUCCESSFUL)) {
                Toast.makeText(this, "Welcome " + data.getExtras().getString("UserName") + "!", Toast.LENGTH_SHORT).show();
                registerBtn = (Button) findViewById(R.id.registerBtn);
                registerBtn.setText("Change User");
            } else {
                Toast.makeText(this, "Please Login or Sign In as Guest before continuing.", Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(this, LoginActivity.class);
                loginIntent.setAction(LoginActivity.NO_USER_LOGGED);
                startActivityForResult(loginIntent, REQUEST_LOGIN);
            }
        }

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
                if(User.getUserLogged() == null) {
                    Toast.makeText(this, "You cannot list items as guest. Please login.", Toast.LENGTH_LONG).show();
                    Intent loginIntent = new Intent(this, LoginActivity.class);
                    loginIntent.setAction(LoginActivity.REGISTER_OTHER_USER);
                    startActivityForResult(loginIntent, REQUEST_LOGIN);
                } else {
                    intent = new Intent(this, ListItemsForBidding.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
