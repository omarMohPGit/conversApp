package com.example.conversionapptestnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainScreen extends AppCompatActivity{
    public ImageButton mainSButton1;
    public ImageButton mainSButton2;
    public ImageButton mainSButton3;
    public ImageButton mainSButton4;
    public ImageButton mainSButton5;
    public ImageButton mainSButton6;
    public ImageButton mainSButton7;
    public ImageButton mainSButton8;
    public ImageButton mainSButton9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        getSupportActionBar().hide();

        mainSButton1=(ImageButton) findViewById(R.id.weightButton);
        mainSButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWeightUnits();
            }
        });

        mainSButton2=(ImageButton) findViewById(R.id.tempButton);
        mainSButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTempUits();
            }
        });
        mainSButton3=(ImageButton) findViewById(R.id.byteButton);
        mainSButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openByteUnits();
            }
        });
        mainSButton4=(ImageButton) findViewById(R.id.pressureButton);
        mainSButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPressUnits();
            }
        });

        mainSButton5=(ImageButton) findViewById(R.id.timeBut);
        mainSButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimeUnits();
            }
        });

        mainSButton6=(ImageButton) findViewById(R.id.fuelBut);
        mainSButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFuelUnits();
            }
        });

        mainSButton7=(ImageButton) findViewById(R.id.lenBut);
        mainSButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLenUnits();
            }
        });

        mainSButton8=(ImageButton) findViewById(R.id.coinBut);
        mainSButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCoinUnits();
            }
        });

        mainSButton9=(ImageButton) findViewById(R.id.kitchBut);
        mainSButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openKitchUnits();
            }
        });

    }



    public void openWeightUnits(){
        Intent intent = new Intent (this,weightUnits.class);
        startActivity(intent);

    }

    public void openTempUits(){
        Intent intent = new Intent (this, tempUnits.class);
        startActivity(intent);
    }
    public void openByteUnits(){
        Intent intent = new Intent (this, byteUnits.class);
        startActivity(intent);
    }
    public void openPressUnits(){
        Intent intent = new Intent (this, pressUnits.class);
        startActivity(intent);
    }
    public void openTimeUnits(){
        Intent intent = new Intent (this, timeUnits.class);
        startActivity(intent);
    }
    public void openFuelUnits(){
        Intent intent = new Intent (this, fuelUnits.class);
        startActivity(intent);
    }
    public void openLenUnits(){
        Intent intent = new Intent (this, lengthUnits.class);
        startActivity(intent);
    }
    public void openCoinUnits(){
        Intent intent = new Intent (this, coinUnits.class);
        startActivity(intent);
    }
    public void openKitchUnits(){
        Intent intent = new Intent (this, kitchUnits.class);
        startActivity(intent);
    }


}