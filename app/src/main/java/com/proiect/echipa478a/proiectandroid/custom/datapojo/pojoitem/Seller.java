package com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem;

/**
 * Created by Marius on 12/15/2016.
 */

public class Seller
{
    private String username;

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [username = "+username+"]";
    }
}
