package com.proiect.echipa478a.proiectandroid.custom.connection.webservices;

import com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem.EbayItemJson;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by Marius on 12/14/2016.
 */

public interface EbayItemService {
    //public final String itemsLocation = "/buy/browse/v1/item_summary/search";

    public final String itemsLocation = "/Marzus/49d9cd4df4acd2deb5a30444cf901541/raw/ce3e3f855d06b55779b64b8e220c14864d0e19f7/BidItemsJson";

    //public void getItemsByKeyWord(@Query("q") String searchWord, Callback<JSONArray> response);

    @Headers({
            "Accept:application/json",
            "Content-Type:application/json"
    })
    @GET(itemsLocation)
    public void getItemsByKeyWord(/*@Query("q") String searchWord,*/ Callback<EbayItemJson> response);

}
