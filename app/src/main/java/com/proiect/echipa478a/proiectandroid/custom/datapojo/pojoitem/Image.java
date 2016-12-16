package com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem;

/**
 * Created by Marius on 12/15/2016.
 */

public class Image
{
    private String imageUrl;

    public String getImageUrl ()
    {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [imageUrl = "+imageUrl+"]";
    }
}
