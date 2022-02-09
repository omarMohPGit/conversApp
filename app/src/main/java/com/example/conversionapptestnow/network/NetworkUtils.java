package com.example.conversionapptestnow.network;

import com.example.conversionapptestnow.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {
    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(50, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
            .build();
}
