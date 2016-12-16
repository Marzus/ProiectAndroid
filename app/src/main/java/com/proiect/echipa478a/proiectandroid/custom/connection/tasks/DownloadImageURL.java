package com.proiect.echipa478a.proiectandroid.custom.connection.tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.Toast;

import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItem;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItemManager;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Marius on 12/13/2016.
 */

public class DownloadImageURL extends AsyncTask<String, Integer, Bitmap> {
    private final BidItem bidItem;
    private Activity context;
    private ProgressDialog progressDialog;

    public DownloadImageURL(Activity context, BidItem bidItem) {
        super();
        this.context = context;
        this.bidItem = bidItem;
        this.progressDialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progressDialog.setMessage("Download Image...");
        this.progressDialog.show();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap = null;
        String sUrl = strings[0];
        HttpURLConnection httpURLConnection = null;

        try {
            URL url = new URL(sUrl);
            URLConnection urlConnection = url.openConnection();

            if(urlConnection instanceof HttpURLConnection) {
                httpURLConnection = (HttpURLConnection) urlConnection;
                httpURLConnection.connect();
                int resultCode = httpURLConnection.getResponseCode();
                if(resultCode == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    int size = bitmap.getByteCount();
                    publishProgress(size);
                }
            } else {
                //throw new Exception("Invalid HTTP connection!");
                Toast.makeText(context, "Invalid link. Try again!", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        bidItem.setImage(bitmap);
        BidItemManager.addLocalBidItem(bidItem);

        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        Toast.makeText(context, bidItem.getItemName() + " added.", Toast.LENGTH_SHORT).show();
    }
}
