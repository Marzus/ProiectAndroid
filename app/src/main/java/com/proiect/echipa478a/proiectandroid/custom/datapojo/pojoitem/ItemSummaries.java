package com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem;

/**
 * Created by Marius on 12/15/2016.
 */


public class ItemSummaries
{
    private String[] buyingOptions;

    private String title;

    private Price price;

    private String condition;

    private ShippingOptions[] shippingOptions;

    private String topRatedBuyingExperience;

    private Image image;

    private String itemGroupHref;

    private Categories[] categories;

    private String itemId;

    private Seller seller;

    private ItemLocation itemLocation;

    private AdditionalImages[] additionalImages;

    public String[] getBuyingOptions ()
    {
        return buyingOptions;
    }

    public void setBuyingOptions (String[] buyingOptions)
    {
        this.buyingOptions = buyingOptions;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public Price getPrice ()
    {
        return price;
    }

    public void setPrice (Price price)
    {
        this.price = price;
    }

    public String getCondition ()
    {
        return condition;
    }

    public void setCondition (String condition)
    {
        this.condition = condition;
    }

    public ShippingOptions[] getShippingOptions ()
    {
        return shippingOptions;
    }

    public void setShippingOptions (ShippingOptions[] shippingOptions)
    {
        this.shippingOptions = shippingOptions;
    }

    public String getTopRatedBuyingExperience ()
    {
        return topRatedBuyingExperience;
    }

    public void setTopRatedBuyingExperience (String topRatedBuyingExperience)
    {
        this.topRatedBuyingExperience = topRatedBuyingExperience;
    }

    public Image getImage ()
    {
        return image;
    }

    public void setImage (Image image)
    {
        this.image = image;
    }

    public String getItemGroupHref ()
    {
        return itemGroupHref;
    }

    public void setItemGroupHref (String itemGroupHref)
    {
        this.itemGroupHref = itemGroupHref;
    }

    public Categories[] getCategories ()
    {
        return categories;
    }

    public void setCategories (Categories[] categories)
    {
        this.categories = categories;
    }

    public String getItemId ()
    {
        return itemId;
    }

    public void setItemId (String itemId)
    {
        this.itemId = itemId;
    }

    public Seller getSeller ()
    {
        return seller;
    }

    public void setSeller (Seller seller)
    {
        this.seller = seller;
    }

    public ItemLocation getItemLocation ()
    {
        return itemLocation;
    }

    public void setItemLocation (ItemLocation itemLocation)
    {
        this.itemLocation = itemLocation;
    }

    public AdditionalImages[] getAdditionalImages ()
    {
        return additionalImages;
    }

    public void setAdditionalImages (AdditionalImages[] additionalImages)
    {
        this.additionalImages = additionalImages;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [buyingOptions = "+buyingOptions+", title = "+title+", price = "+price+", condition = "+condition+", shippingOptions = "+shippingOptions+", topRatedBuyingExperience = "+topRatedBuyingExperience+", image = "+image+", itemGroupHref = "+itemGroupHref+", categories = "+categories+", itemId = "+itemId+", seller = "+seller+", itemLocation = "+itemLocation+", additionalImages = "+additionalImages+"]";
    }
}

