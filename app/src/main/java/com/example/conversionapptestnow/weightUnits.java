package com.example.conversionapptestnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class weightUnits extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText weightInputB;
    double base;
    ListView listV;
    public ImageButton weightButton1;
    public ImageButton weightButton2;
    public ImageButton weightButton3;
    public ImageButton weightButton4;
    public ImageButton weightButton5;
    public ImageButton weightButton6;
    public ImageButton weightButton7;
    public ImageButton weightButton8;
    public ImageButton weightButton9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_units);
        getSupportActionBar().hide();

        weightButton1=(ImageButton)findViewById(R.id.button1);
        weightButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(weightUnits.this,byteUnits.class);
                startActivity(intent);
            }
        });
        weightButton2=(ImageButton)findViewById(R.id.button2);
        weightButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(weightUnits.this,coinUnits.class);
                startActivity(intent);
            }
        });
        weightButton3=(ImageButton)findViewById(R.id.button3);
        weightButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(weightUnits.this,fuelUnits.class);
                startActivity(intent);
            }
        });
        weightButton4=(ImageButton)findViewById(R.id.button4);
        weightButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(weightUnits.this,kitchUnits.class);
                startActivity(intent);
            }
        });
        weightButton5=(ImageButton)findViewById(R.id.button5);
        weightButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(weightUnits.this,lengthUnits.class);
                startActivity(intent);
            }
        });
        weightButton6=(ImageButton)findViewById(R.id.button6);
        weightButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(weightUnits.this,pressUnits.class);
                startActivity(intent);
            }
        });
        weightButton7=(ImageButton)findViewById(R.id.button7);
        weightButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(weightUnits.this,tempUnits.class);
                startActivity(intent);
            }
        });
        weightButton8=(ImageButton)findViewById(R.id.button8);
        weightButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(weightUnits.this,timeUnits.class);
                startActivity(intent);
            }
        });
        weightButton9=(ImageButton)findViewById(R.id.button9);
        weightButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(weightUnits.this,weightUnits.class);
                startActivity(intent);
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.spinner9);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitsWeight, R.layout.scroll);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int a, long l) {
        String text= adapterView.getItemAtPosition(a).toString();
        runTest(adapterView, view, a, l);
        Toast.makeText(adapterView.getContext(), text +" selected",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view !=null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);

        }
    }

    public void runTest(AdapterView<?> adapterView, View view, int a, long l ){
        weightInputB = (EditText) findViewById(R.id.byteNum);
        weightInputB.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()== KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                    if(weightInputB.getText().toString().equals("")||weightInputB.getText().toString().equals(".")){
                        base=0.0;
                    }
                    else{
                        base=Double.parseDouble(weightInputB.getText().toString());
                    }
                    ArrayList<Double> arrayList=new ArrayList<>();

                    if(adapterView.getItemAtPosition(a).toString().equals("μg")){
                        listV=(ListView)findViewById(R.id.list1);
                        arrayList.add((double)(base)); //micro gram
                        arrayList.add((double)(base)/1000); //mg
                        arrayList.add((double)(base/1000000)); // gram
                        arrayList.add((double)(base/1000000000)); // kg
                        arrayList.add((double)(base* 2.2046226218488E-9)); // pound
                        arrayList.add((double)(base* 0.000000035274));// oz
                        arrayList.add((double)(base/64799));// grain
                        arrayList.add((double)(base/1000000000000.0));// tonne
                        arrayList.add((double)(base/9.072e+11));//ton
                        arrayList.add((double)(base/ 6.35e+9));//stone
                        arrayList.add((double)(base*0.0000050000)); // carat
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("mg")){
                        listV=(ListView)findViewById(R.id.list1);
                        arrayList.add((double)(base*1000)); //micro gram
                        arrayList.add((double)(base)); //mg
                        arrayList.add((double)(base/1000)); // gram
                        arrayList.add((double)(base/ 1e+6)); // kg
                        arrayList.add((double)(base/453592)); // pound
                        arrayList.add((double)(base/28350));// oz
                        arrayList.add((double)(base/64.799));// grain
                        arrayList.add((double)(base/1e+9));// tonne
                        arrayList.add((double)(base/9.072e+8));//ton
                        arrayList.add((double)(base/6.35e+6));//stone
                        arrayList.add((double)(base/200)); // carat
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("g")){
                        listV=(ListView)findViewById(R.id.list1);
                        arrayList.add((double)(base* 1e+6)); //micro gram
                        arrayList.add((double)(base*1000)); //mg
                        arrayList.add((double)(base)); // gram
                        arrayList.add((double)(base/1000)); // kg
                        arrayList.add((double)(base/454)); // pound
                        arrayList.add((double)(base/28.35));// oz
                        arrayList.add((double)(base*15.432));// grain
                        arrayList.add((double)(base/1e+6));// tonne
                        arrayList.add((double)(base/907185));//ton
                        arrayList.add((double)(base/6350));//stone
                        arrayList.add((double)(base*5)); // carat
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("kg")){
                        listV=(ListView)findViewById(R.id.list1);
                        arrayList.add((double)(base* 1e+9)); //micro gram
                        arrayList.add((double)(base*1e+6)); //mg
                        arrayList.add((double)(base*1000)); // gram
                        arrayList.add((double)(base)); // kg
                        arrayList.add((double)(base*2.205)); // pound
                        arrayList.add((double)(base*35.274));// oz
                        arrayList.add((double)(base*15432));// grain
                        arrayList.add((double)(base/1000));// tonne
                        arrayList.add((double)(base/907));//ton
                        arrayList.add((double)(base/6.35));//stone
                        arrayList.add((double)(base*5000)); // carat
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("lb")){
                        listV=(ListView)findViewById(R.id.list1);
                        arrayList.add((double)(base* 4.536e+8)); //micro gram
                        arrayList.add((double)(base*453592)); //mg
                        arrayList.add((double)(base*454)); // gram
                        arrayList.add((double)(base/2.205)); // kg
                        arrayList.add((double)(base)); // pound
                        arrayList.add((double)(base*16));// oz
                        arrayList.add((double)(base*7000));// grain
                        arrayList.add((double)(base/2205));// tonne
                        arrayList.add((double)(base/2000));//ton
                        arrayList.add((double)(base/14));//stone
                        arrayList.add((double)(base*2268)); // carat
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("oz")){
                        listV=(ListView)findViewById(R.id.list1);
                        arrayList.add((double)(base* 2.835e+7)); //micro gram
                        arrayList.add((double)(base*28350)); //mg
                        arrayList.add((double)(base*28.35)); // gram
                        arrayList.add((double)(base/35.274)); // kg
                        arrayList.add((double)(base/16)); // pound
                        arrayList.add((double)(base));// oz
                        arrayList.add((double)(base*438));// grain
                        arrayList.add((double)(base/35274));// tonne
                        arrayList.add((double)(base/32000));//ton
                        arrayList.add((double)(base/224));//stone
                        arrayList.add((double)(base*142)); // carat
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("grain")){
                        listV=(ListView)findViewById(R.id.list1);
                        arrayList.add((double)(base* 64799)); //micro gram
                        arrayList.add((double)(base*64.799)); //mg
                        arrayList.add((double)(base/15.432)); // gram
                        arrayList.add((double)(base/15432)); // kg
                        arrayList.add((double)(base/ 7000)); // pound
                        arrayList.add((double)(base/438));// oz
                        arrayList.add((double)(base));// grain
                        arrayList.add((double)(base/1.543e+7));// tonne
                        arrayList.add((double)(base/1.4e+7));//ton
                        arrayList.add((double)(base/98000));//stone
                        arrayList.add((double)(base*0.32399455)); // carat
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("tonne (metric)")){
                        listV=(ListView)findViewById(R.id.list1);
                        arrayList.add((double)(base*1e+12)); //micro gram
                        arrayList.add((double)(base* 1e+9)); //mg
                        arrayList.add((double)(base*1e+6)); // gram
                        arrayList.add((double)(base*1000)); // kg
                        arrayList.add((double)(base*2205)); // pound
                        arrayList.add((double)(base*35274));// oz
                        arrayList.add((double)(base*1.543e+7));// grain
                        arrayList.add((double)(base));// tonne
                        arrayList.add((double)(base*1.102));//ton
                        arrayList.add((double)(base*157));//stone
                        arrayList.add((double)(base* 5e+6)); // carat
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("ton")){
                        listV=(ListView)findViewById(R.id.list1);
                        arrayList.add((double)(base*9.072e+11)); //micro gram
                        arrayList.add((double)(base* 9.072e+8)); //mg
                        arrayList.add((double)(base*907185)); // gram
                        arrayList.add((double)(base*907)); // kg
                        arrayList.add((double)(base*2000)); // pound
                        arrayList.add((double)(base*32000));// oz
                        arrayList.add((double)(base*1.4e+7));// grain
                        arrayList.add((double)(base/1.102));// tonne
                        arrayList.add((double)(base));//ton
                        arrayList.add((double)(base*143));//stone
                        arrayList.add((double)(base* 4.536e+6)); // carat
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("stone")){
                        listV=(ListView)findViewById(R.id.list1);
                        arrayList.add((double)(base*6.35e+9)); //micro gram
                        arrayList.add((double)(base* 6.35e+6)); //mg
                        arrayList.add((double)(base*6350.29)); // gram
                        arrayList.add((double)(base*6.35)); // kg
                        arrayList.add((double)(base*14)); // pound
                        arrayList.add((double)(base*224));// oz
                        arrayList.add((double)(base*98000));// grain
                        arrayList.add((double)(base/157));// tonne
                        arrayList.add((double)(base/ 143));//ton
                        arrayList.add((double)(base));//stone
                        arrayList.add((double)(base*31751.5)); // carat
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("carat")){
                        listV=(ListView)findViewById(R.id.list1);
                        arrayList.add((double)(base* 200000)); //micro gram
                        arrayList.add((double)(base*200)); //mg
                        arrayList.add((double)(base/5)); // gram
                        arrayList.add((double)(base/5000)); // kg
                        arrayList.add((double)(base/2268)); // pound
                        arrayList.add((double)(base/142));// oz
                        arrayList.add((double)(base*3.086));// grain
                        arrayList.add((double)(base/5e+6));// tonne
                        arrayList.add((double)(base/4.536e+6));//ton
                        arrayList.add((double)(base/31751));//stone
                        arrayList.add((double)(base)); // carat
                    }
                    closeKeyboard();
                    ArrayAdapter arrayAdapter=new ArrayAdapter(weightUnits.this, R.layout.row,arrayList);
                    listV.setAdapter(arrayAdapter);

                    return true;
                }
                return false;
            }
        });
    }

}