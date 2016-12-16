package com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem;

/**
 * Created by Marius on 12/15/2016.
 */


public class Categories
{
    private String categoryId;

    public String getCategoryId ()
    {
        return categoryId;
    }

    public void setCategoryId (String categoryId)
    {
        this.categoryId = categoryId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [categoryId = "+categoryId+"]";
    }
}
