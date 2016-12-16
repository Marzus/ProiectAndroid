package com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem;

/**
 * Created by Marius on 12/15/2016.
 */

public class ShippingOptions
{
    public ShippingOptions(String cost) {
        this.shippingCost = new ShippingCost();
        this.shippingCost.setValue(cost);
    }

    public ShippingOptions() {
    }

    private String shippingCostType;

    private ShippingCost shippingCost;

    public String getShippingCostType ()
    {
        return shippingCostType;
    }

    public void setShippingCostType (String shippingCostType)
    {
        this.shippingCostType = shippingCostType;
    }

    public ShippingCost getShippingCost ()
    {
        return shippingCost;
    }

    public void setShippingCost (ShippingCost shippingCost)
    {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [shippingCostType = "+shippingCostType+", shippingCost = "+shippingCost+"]";
    }

    public class ShippingCost
    {
        private String value;

        private String currency;

        public String getValue ()
        {
            return value;
        }

        public void setValue (String value)
        {
            this.value = value;
        }

        public String getCurrency ()
        {
            return currency;
        }

        public void setCurrency (String currency)
        {
            this.currency = currency;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [value = "+value+", currency = "+currency+"]";
        }
    }

}
