package com.example.conversionapptestnow.network;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.conversionapptestnow.models.CurrencyModel;
import com.example.conversionapptestnow.utils.Constants;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyRepository {

    private final ApiInterface apiInterface;
    private static CurrencyRepository repository;
    private static final String TAG = "CurrencyRepository";

    public CurrencyRepository() {
        apiInterface = NetworkUtils.retrofit.create(ApiInterface.class);
    }

    public synchronized static CurrencyRepository getInstance() {
        if (repository == null) repository = new CurrencyRepository();
        return repository;
    }

    public LiveData<List<CurrencyModel>> getCurrenciesByConversion(String baseCurrency) {
        final MutableLiveData<List<CurrencyModel>> liveData = new MutableLiveData<>();
        Call<JsonObject> call = apiInterface.fetchCurrencyRatesBy(Constants.FREE_CURRENCY_API_KEY, baseCurrency);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body() != null) {
                    Log.d(TAG, "onResponse: -> " + response.body());

                    JsonObject data = response.body().getAsJsonObject("data");
                    Log.d(TAG, "onResponse: Data -> " + data.toString());
                    List<CurrencyModel> list = new ArrayList<>();
                    Set<String> keys = data.keySet();
                    for (String key : keys) {
                        double value = data.get(key).getAsDouble();
                        list.add(new CurrencyModel(key, value));
                    }
                    liveData.postValue(list);
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d(TAG, "onFailure: Error -> " + t.getLocalizedMessage());
                liveData.postValue(new ArrayList<CurrencyModel>());
            }
        });
        return liveData;
    }
}
