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

public class byteUnits extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText byteInputB;
    double base;
    ListView listV;
    public ImageButton byteButton1;
    public ImageButton byteButton2;
    public ImageButton byteButton3;
    public ImageButton byteButton4;
    public ImageButton byteButton5;
    public ImageButton byteButton6;
    public ImageButton byteButton7;
    public ImageButton byteButton8;
    public ImageButton byteButton9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_byte_units);
        getSupportActionBar().hide();

        byteButton1=(ImageButton)findViewById(R.id.button1);
        byteButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(byteUnits.this,byteUnits.class);
                startActivity(intent);
            }
        });
        byteButton2=(ImageButton)findViewById(R.id.button2);
        byteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(byteUnits.this,coinUnits.class);
                startActivity(intent);
            }
        });
        byteButton3=(ImageButton)findViewById(R.id.button3);
        byteButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(byteUnits.this,fuelUnits.class);
                startActivity(intent);
            }
        });
        byteButton4=(ImageButton)findViewById(R.id.button4);
        byteButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(byteUnits.this,kitchUnits.class);
                startActivity(intent);
            }
        });
        byteButton5=(ImageButton)findViewById(R.id.button5);
        byteButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(byteUnits.this,lengthUnits.class);
                startActivity(intent);
            }
        });
        byteButton6=(ImageButton)findViewById(R.id.button6);
        byteButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(byteUnits.this,pressUnits.class);
                startActivity(intent);
            }
        });
        byteButton7=(ImageButton)findViewById(R.id.button7);
        byteButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(byteUnits.this,tempUnits.class);
                startActivity(intent);
            }
        });
        byteButton8=(ImageButton)findViewById(R.id.button8);
        byteButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(byteUnits.this,timeUnits.class);
                startActivity(intent);
            }
        });
        byteButton9=(ImageButton)findViewById(R.id.button9);
        byteButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(byteUnits.this,weightUnits.class);
                startActivity(intent);
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitsBytes, R.layout.scroll);
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
        byteInputB = (EditText) findViewById(R.id.byteNum);

        byteInputB.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()== KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                    String test=byteInputB.getText().toString();

                    if(byteInputB.getText().toString().equals("")||byteInputB.getText().toString().equals(".")){
                        base=0.0;
                    }
                    else{
                        base=Double.parseDouble(byteInputB.getText().toString());
                    }

                    ArrayList<Double> arrayList=new ArrayList<>();

                    if(adapterView.getItemAtPosition(a).toString().equals("bit")){
                        listV=(ListView)findViewById(R.id.list9);
                        arrayList.add((double)(base)); //bit
                        arrayList.add((double)(base)/8); //Byte
                        arrayList.add((double)(base/8000)); // KB
                        arrayList.add((double)(base/8e+6)); // MB
                        arrayList.add((double)(base/8e+9)); // GB
                        arrayList.add((double)(base/8e+12));// TB
                        arrayList.add((double)(base/8e+15));// PB
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("Byte")){
                        listV=(ListView)findViewById(R.id.list9);
                        arrayList.add((double)(base*8)); //bit
                        arrayList.add((double)(base)); //Byte
                        arrayList.add((double)(base/1000)); // KB
                        arrayList.add((double)(base/1e+6)); // MB
                        arrayList.add((double)(base/1e+9)); // GB
                        arrayList.add((double)(base/1e+12));// TB
                        arrayList.add((double)(base/1e+15));// PB
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("KB")){
                        listV=(ListView)findViewById(R.id.list9);
                        arrayList.add((double)(base*8000)); //bit
                        arrayList.add((double)(base*1000)); //Byte
                        arrayList.add((double)(base)); // KB
                        arrayList.add((double)(base/1000)); // MB
                        arrayList.add((double)(base/1e+6)); // GB
                        arrayList.add((double)(base/1e+9));// TB
                        arrayList.add((double)(base/1e+12));// PB
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("MB")){
                        listV=(ListView)findViewById(R.id.list9);
                        arrayList.add((double)(base*8e+6)); //bit
                        arrayList.add((double)(base*1e+6)); //Byte
                        arrayList.add((double)(base*1000)); // KB
                        arrayList.add((double)(base)); // MB
                        arrayList.add((double)(base/1000)); // GB
                        arrayList.add((double)(base/1e+6));// TB
                        arrayList.add((double)(base/1e+9));// PB
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("GB")){
                        listV=(ListView)findViewById(R.id.list9);
                        arrayList.add((double)(base*8e+9)); //bit
                        arrayList.add((double)(base*1e+9)); //Byte
                        arrayList.add((double)(base*1e+6)); // KB
                        arrayList.add((double)(base*1000)); // MB
                        arrayList.add((double)(base)); // GB
                        arrayList.add((double)(base/1000));// TB
                        arrayList.add((double)(base/1e+6));// PB
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("TB")){
                        listV=(ListView)findViewById(R.id.list9);
                        arrayList.add((double)(base*8e+12)); //bit
                        arrayList.add((double)(base*1e+12)); //Byte
                        arrayList.add((double)(base*1e+9)); // KB
                        arrayList.add((double)(base*1e+6)); // MB
                        arrayList.add((double)(base*1000)); // GB
                        arrayList.add((double)(base));// TB
                        arrayList.add((double)(base/1000));// PB
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("PB")){
                        listV=(ListView)findViewById(R.id.list9);
                        arrayList.add((double)(base*8e+15)); //bit
                        arrayList.add((double)(base*1e+15)); //Byte
                        arrayList.add((double)(base*1e+12)); // KB
                        arrayList.add((double)(base*1e+9)); // MB
                        arrayList.add((double)(base*1e+6)); // GB
                        arrayList.add((double)(base*1000));// TB
                        arrayList.add((double)(base));// PB
                    }

                    closeKeyboard();
                    ArrayAdapter arrayAdapter=new ArrayAdapter(byteUnits.this, R.layout.row,arrayList);
                    listV.setAdapter(arrayAdapter);

                    return true;
                }

                return false;
            }
        });
    }

}