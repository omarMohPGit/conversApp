package com.example.conversionapptestnow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conversionapptestnow.adapters.CoinsAdapter;
import com.example.conversionapptestnow.models.CurrencyModel;
import com.example.conversionapptestnow.network.CurrencyRepository;

import java.util.ArrayList;
import java.util.List;

public class coinUnits extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "CoinUnitsActivity";
    RecyclerView recyclerView;
    Spinner spinner;
    public ImageButton coinButton1;
    public ImageButton coinButton2;
    public ImageButton coinButton3;
    public ImageButton coinButton4;
    public ImageButton coinButton5;
    public ImageButton coinButton6;
    public ImageButton coinButton7;
    public ImageButton coinButton8;
    public ImageButton coinButton9;


    private double selectedAmount = 0;
    private CoinsAdapter adapter;
    private static CoinsAdapter.DiffCallback callback = new CoinsAdapter.DiffCallback();
    private List<CurrencyModel> currenciesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_units);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.list8);
        spinner = (Spinner) findViewById(R.id.spinner2);
        initAdapter();
        fetchAndUpdateCurrencies("USD");
        coinButton1 = (ImageButton) findViewById(R.id.button1);
        coinButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(coinUnits.this, byteUnits.class);
                startActivity(intent);
            }
        });
        coinButton2 = (ImageButton) findViewById(R.id.button2);
        coinButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(coinUnits.this, coinUnits.class);
                startActivity(intent);
            }
        });
        coinButton3 = (ImageButton) findViewById(R.id.button3);
        coinButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(coinUnits.this, fuelUnits.class);
                startActivity(intent);
            }
        });
        coinButton4 = (ImageButton) findViewById(R.id.button4);
        coinButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(coinUnits.this, kitchUnits.class);
                startActivity(intent);
            }
        });
        coinButton5 = (ImageButton) findViewById(R.id.button5);
        coinButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(coinUnits.this, lengthUnits.class);
                startActivity(intent);
            }
        });
        coinButton6 = (ImageButton) findViewById(R.id.button6);
        coinButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(coinUnits.this, pressUnits.class);
                startActivity(intent);
            }
        });
        coinButton7 = (ImageButton) findViewById(R.id.button7);
        coinButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(coinUnits.this, tempUnits.class);
                startActivity(intent);
            }
        });
        coinButton8 = (ImageButton) findViewById(R.id.button8);
        coinButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(coinUnits.this, timeUnits.class);
                startActivity(intent);
            }
        });
        coinButton9 = (ImageButton) findViewById(R.id.button9);
        coinButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(coinUnits.this, weightUnits.class);
                startActivity(intent);
            }
        });


        EditText numberInput = findViewById(R.id.coinNum);

        numberInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence != null && !charSequence.toString().isEmpty()) {
                    double numb = Double.parseDouble(charSequence.toString());
                    if (numb > 0) {
                        selectedAmount = numb;
                        closeKeyboard();
                        fetchAndUpdateCurrencies(spinner.getSelectedItem().toString().toUpperCase());
                    }
                } else {
                    closeKeyboard();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void initAdapter() {
        adapter = new CoinsAdapter(callback, 1);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int a, long l) {
        String text = adapterView.getItemAtPosition(a).toString();
        // runTest(adapterView, view, a, l);
        if (selectedAmount > 0) {
            fetchAndUpdateCurrencies(text.toUpperCase());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        }
    }


    private void fetchAndUpdateCurrencies(String unit) {
        CurrencyRepository.getInstance().getCurrenciesByConversion(unit)
                .observe(this, currencyModels -> {
                    currenciesList.addAll(currencyModels);
                    if (spinner.getAdapter() == null) {
                        setSpinner();
                    }

                    if (selectedAmount > 0) {
                        adapter.setSelectedAmount(selectedAmount);
                        adapter.submitList(currencyModels);
                    }

                });
    }

    private void setSpinner() {
        ArrayAdapter<CurrencyModel> adapter = new ArrayAdapter<CurrencyModel>(this, R.layout.spinner_item, currenciesList);//ArrayAdapter.createFromResource(this, R.array.unitsCoin, R.layout.scroll);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

}

