package com.example.conversionapptestnow.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/v2/latest")
    Call<JsonObject> fetchCurrencyRatesBy(
            @Query("apikey") String apiKey,
            @Query("base_currency") String base_currency
    );
}
