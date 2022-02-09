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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class tempUnits extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText tempInputB;
    double base;
    ListView listV;
    public ImageButton tempButton1;
    public ImageButton tempButton2;
    public ImageButton tempButton3;
    public ImageButton tempButton4;
    public ImageButton tempButton5;
    public ImageButton tempButton6;
    public ImageButton tempButton7;
    public ImageButton tempButton8;
    public ImageButton tempButton9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_units);
        getSupportActionBar().hide();

        tempButton1=(ImageButton)findViewById(R.id.button1);
        tempButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tempUnits.this,byteUnits.class);
                startActivity(intent);
            }
        });
        tempButton2=(ImageButton)findViewById(R.id.button2);
        tempButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tempUnits.this,coinUnits.class);
                startActivity(intent);
            }
        });
        tempButton3=(ImageButton)findViewById(R.id.button3);
        tempButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tempUnits.this,fuelUnits.class);
                startActivity(intent);
            }
        });
        tempButton4=(ImageButton)findViewById(R.id.button4);
        tempButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tempUnits.this,kitchUnits.class);
                startActivity(intent);
            }
        });
        tempButton5=(ImageButton)findViewById(R.id.button5);
        tempButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tempUnits.this,lengthUnits.class);
                startActivity(intent);
            }
        });
        tempButton6=(ImageButton)findViewById(R.id.button6);
        tempButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tempUnits.this,pressUnits.class);
                startActivity(intent);
            }
        });
        tempButton7=(ImageButton)findViewById(R.id.button7);
        tempButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tempUnits.this,tempUnits.class);
                startActivity(intent);
            }
        });
        tempButton8=(ImageButton)findViewById(R.id.button8);
        tempButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tempUnits.this,timeUnits.class);
                startActivity(intent);
            }
        });
        tempButton9=(ImageButton)findViewById(R.id.button9);
        tempButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tempUnits.this,weightUnits.class);
                startActivity(intent);
            }
        });



        Spinner spinner = (Spinner)findViewById(R.id.spinner7);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitsTemp, R.layout.scroll);
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
        tempInputB = (EditText) findViewById(R.id.tempNum);
        tempInputB.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()== KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                    if(tempInputB.getText().toString().equals("")||tempInputB.getText().toString().equals(".")){
                        base=0.0;
                    }
                    else{
                        base=Double.parseDouble(tempInputB.getText().toString());
                    }
                    ArrayList<Double> arrayList=new ArrayList<>();

                    if(adapterView.getItemAtPosition(a).toString().equals("°C")){
                        listV=(ListView)findViewById(R.id.list3);
                        arrayList.add((double)(base)); //°C
                        arrayList.add((double)((9.0/5.0)*base+32)); //°F
                        arrayList.add((double)(base+273.15)); //K
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("°F")){
                        listV=(ListView)findViewById(R.id.list3);
                        arrayList.add((double)((base-32)*5/9)); //°C
                        arrayList.add((double)(base)); //°F
                        arrayList.add((double)((base-32)*5/9+273.15)); //K
                    }



                    if(adapterView.getItemAtPosition(a).toString().equals("K")){
                        listV=(ListView)findViewById(R.id.list3);
                        arrayList.add((double)(base-273.15)); //°C
                        arrayList.add((double)((base-273.15)*9/5+32)); //F
                        arrayList.add((double)(base)); //K
                    }

                    closeKeyboard();
                    ArrayAdapter arrayAdapter=new ArrayAdapter(tempUnits.this, R.layout.row,arrayList);
                    listV.setAdapter(arrayAdapter);

                    return true;
                }
                return false;
            }
        });
    }

}