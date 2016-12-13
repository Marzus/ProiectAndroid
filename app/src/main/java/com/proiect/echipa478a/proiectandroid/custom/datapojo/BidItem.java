package com.proiect.echipa478a.proiectandroid.custom.datapojo;

import android.graphics.Bitmap;

/**
 * Created by Marius on 12/12/2016.
 */

public class BidItem {
    private String itemName;
    private Double price;
    private Bitmap image;
    private String description;

    // autoassign from db
    int id = -1;
    //special field to check if the record is synchronized with the database
    boolean synced;
    public BidItem(String itemName, Double price, Bitmap image) {
        this.itemName = itemName;
        this.price = price;
        this.image = image;

        //special field for check
        this.synced = false;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
        this.synced = false;
    }*/

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
        this.synced = false;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
        this.synced = false;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
        if(this.image.isMutable() && this.image.getWidth() > 300) {
            this.image.setWidth(300);
            this.image.setHeight(200);
        }
        this.synced = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.synced = false;
    }

    public boolean isSynced() {
        return synced;
    }
}
