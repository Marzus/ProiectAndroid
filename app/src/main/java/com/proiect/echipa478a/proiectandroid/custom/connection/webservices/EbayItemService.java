package com.proiect.echipa478a.proiectandroid.custom.connection.webservices;

import com.proiect.echipa478a.proiectandroid.custom.datapojo.pojoitem.EbayItemJson;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by Marius on 12/14/2016.
 */

public interface EbayItemService {
    public final String itemsLocation = "/buy/browse/v1/item_summary/search";

    //public void getItemsByKeyWord(@Query("q") String searchWord, Callback<JSONArray> response);

    @Headers({
            "Authorization:Bearer v^1.1#i^1#f^0#p^1#I^3#r^0#t^H4sIAAAAAAAAAOVXfWwURRTvXa8lpFRQoYIh8VjABMju7ddt7xbu4pW2UtOPgyukrTE4uzvbrr3b3ezM0h6JUPoHEgKKfMRIitbIH4b4B5AQASH4VaLESKKIJuAfYkyQBLSaiJpGnb0e5VoNVDgNiZtsNvPemze/93vvzc6wfeVTF29esfl6pW+Kf7CP7fP7fFwFO7W8bMl9pf6Hy0rYAgPfYN+CvkB/6eVlCGTStrwKItsyEQz2ZtImknPCGOU6pmwBZCDZBBmIZKzKqURTo8wzrGw7FrZUK00FG2pjFJTEqBIBmq6pImB5QKTmDZ+tVowKCxKnVvNSOCwJ1YrAET1CLmwwEQYmjlE8y0k0x9Oc1MqJsiDIYpiRJKmDCq6BDjIsk5gwLBXPwZVzc50CrLeGChCCDiZOqHhDoj7VkmiorWtuXRYq8BXP85DCALto/Gi5pcHgGpB24a2XQTlrOeWqKkSICsVHVxjvVE7cAHMH8HNUa7rCQ4HTRaiIelhhi0JlveVkAL41Dk9iaLSeM5WhiQ2cvR2jhA3lGaji/KiZuGioDXqflS5IG7oBnRhVV5NoTySTVLwJOIaLal16tWms88DSqZo2WhDDegTwikaHOZ6PsryeX2jUW57mCSstt0zN8EhDwWYL10CCGk7khi/ghhi1mC1OQsceokI76QaHvNjhJXU0iy7uMr28wgwhIpgb3j4DY7MxdgzFxXDMw0RFjqIYBWzb0KiJylwt5sunF8WoLoxtORTq6elhegTGcjpDPMtyobamxpTaBTOkGXszXq+P2hu3n0AbuVBUSGYiQ8ZZm2DpJbVKAJidVJyXRK6azfM+HlZ8ovQvgoKYQ+M7olgdAlguEtUUQQJRMSoAUIwOieeLNOThgArI0hngdENsp4EKaZXUmZuBjqHJQljnhYgOaU2K6rQY1XVaCWtkPR1CFkJFUaOR/1OjTLbUl6cNomwlpVaUei9ara+wEIbaZGv9b0NLqZYNk1baULP/SWxer086PsHRksDB2Ro3S8YpmE6Tz12Fq+YyubZIG1fREvkPe+bOYjcAvrei5sQI2QwjET58d3GRA809FZdqZRhvG2YcYGPLYQg0Ow0R40BkuQ45gDEt3k+51eqGJtnisGOl09BZw90VC8hr5HuLh8CmE54LRHwA2xilhHATsgCJ3hOtzYEOTsYopLhZptOFCBMgGnT+hR98aPx1I16Se7h+30m233eM3FjYapbmlrCLyktXB0qnUcjAkOTW1BSrlzGAziCj0ySnaQcy3TBrA8Pxl/uavtnWvrHgojP4FDt77KoztZSrKLj3sHNvasq46Q9VchLHk1cUyE7Qwc6/qQ1wVYGZ735Ut2PLwiMrzu6Z9v0TR7+KiOcGhtnKMSOfr6wk0O8refsdn2A0w1NzWy5fGbo67cLqdVe5Kv9I27yLPe2Nhz5fnDjSLR+ianZuHt4Q+Gz91oZL16vZqo/nqQMbDz5Zf/brirZrH1yJDI9Mf7Pr1XZuzq7E71XDJ49M79uQOrN/8f6B+AMzjn8h7p01J7Nv1YvGUv3wknrwnXDm9Uc+3Mt8yQ347R92L31MCs14dGhL+7lP1MaD/uM/HV3/4Ct/zJnSO1iR7Hx8ffnFt7YPHT22c+PZfvfAp+jHbS/dP3+PMGTj8ydGTifr9h3YOnv7ykXvvXDt5+Sspjf67RFzz7Mvv/9a9PivQ7t+K/+lg13YEXtux/ObSg7PrF7w7dOV7qH6C2m6tPvS6cz5E7WnekbT+Ceqkdo/gg4AAA==",
            "Accept:application/json",
            "Content-Type:application/json"
    })
    @GET(itemsLocation)
    public void getItemsByKeyWord(@Query("q") String searchWord, Callback<EbayItemJson> response);

}
