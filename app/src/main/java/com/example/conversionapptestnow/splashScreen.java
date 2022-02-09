package com.example.conversionapptestnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT =2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //Disables support bar
        getSupportActionBar().hide();
        //Gets the transition stuff to display it and yeet it out
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent= new Intent(splashScreen.this, MainScreen.class);
                startActivity(homeIntent);
                finish();
            }
        } , SPLASH_TIME_OUT);
        }

}