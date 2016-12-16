package com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem;

/**
 * Created by Marius on 12/15/2016.
 */


public class EbayItemJson
{
    private String limit;

    private String total;

    private String next;

    private ItemSummaries[] itemSummaries;

    private String offset;

    private String href;

    public String getLimit ()
    {
        return limit;
    }

    public void setLimit (String limit)
    {
        this.limit = limit;
    }

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String getNext ()
    {
        return next;
    }

    public void setNext (String next)
    {
        this.next = next;
    }

    public ItemSummaries[] getItemSummaries ()
    {
        return itemSummaries;
    }

    public void setItemSummaries (ItemSummaries[] itemSummaries)
    {
        this.itemSummaries = itemSummaries;
    }

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }

    public String getHref ()
    {
        return href;
    }

    public void setHref (String href)
    {
        this.href = href;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [limit = "+limit+", total = "+total+", next = "+next+", itemSummaries = "+itemSummaries+", offset = "+offset+", href = "+href+"]";
    }
}


