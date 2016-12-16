package com.proiect.echipa478a.proiectandroid.custom.datapojo;

import android.graphics.Bitmap;

import com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem.ItemLocation;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem.Seller;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem.ShippingOptions;

/**
 * Created by Marius on 12/12/2016.
 */

public class BidItem {
    private String itemName;
    private Double price;
    private Bitmap image;
    private String description;
    private Seller seller;
    private ShippingOptions shippingOptions;
    private ItemLocation itemLocation;

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

    public BidItem(String itemName) {
        this.itemName = itemName;

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
        if(this.image != null) {
            if(this.image.isMutable() && this.image.getWidth() > 300) {
                this.image.setWidth(300);
                this.image.setHeight(200);
            }
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


    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
        this.synced = false;
    }

    public ShippingOptions getShippingOptions() {
        return shippingOptions;
    }

    public void setShippingOptions(ShippingOptions shippingOptions) {
        this.shippingOptions = shippingOptions;
        this.synced = false;
    }

    public ItemLocation getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(ItemLocation itemLocation) {
        this.itemLocation = itemLocation;
        this.synced = false;
    }
}
