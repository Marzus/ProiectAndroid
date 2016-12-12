package com.proiect.echipa478a.proiectandroid.custom.datapojo;

import android.graphics.Bitmap;

/**
 * Created by Marius on 12/12/2016.
 */

public class BidItem {
    private int id;
    private String itemName;
    private Double price;
    private Bitmap image;

    public BidItem(int id, String itemName, Double price, Bitmap image) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
