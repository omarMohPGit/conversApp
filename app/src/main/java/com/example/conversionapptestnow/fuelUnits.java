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

public class fuelUnits extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText fuelInputB;
    double base;
    ListView listV;

    public ImageButton fuelButton1;
    public ImageButton fuelButton2;
    public ImageButton fuelButton3;
    public ImageButton fuelButton4;
    public ImageButton fuelButton5;
    public ImageButton fuelButton6;
    public ImageButton fuelButton7;
    public ImageButton fuelButton8;
    public ImageButton fuelButton9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_units);
        getSupportActionBar().hide();

        fuelButton1=(ImageButton)findViewById(R.id.button1);
        fuelButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fuelUnits.this,byteUnits.class);
                startActivity(intent);
            }
        });
        fuelButton2=(ImageButton)findViewById(R.id.button2);
        fuelButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fuelUnits.this,coinUnits.class);
                startActivity(intent);
            }
        });
        fuelButton3=(ImageButton)findViewById(R.id.button3);
        fuelButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fuelUnits.this,fuelUnits.class);
                startActivity(intent);
            }
        });
        fuelButton4=(ImageButton)findViewById(R.id.button4);
        fuelButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fuelUnits.this,kitchUnits.class);
                startActivity(intent);
            }
        });
        fuelButton5=(ImageButton)findViewById(R.id.button5);
        fuelButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fuelUnits.this,lengthUnits.class);
                startActivity(intent);
            }
        });
        fuelButton6=(ImageButton)findViewById(R.id.button6);
        fuelButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fuelUnits.this,pressUnits.class);
                startActivity(intent);
            }
        });
        fuelButton7=(ImageButton)findViewById(R.id.button7);
        fuelButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fuelUnits.this,tempUnits.class);
                startActivity(intent);
            }
        });
        fuelButton8=(ImageButton)findViewById(R.id.button8);
        fuelButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fuelUnits.this,timeUnits.class);
                startActivity(intent);
            }
        });
        fuelButton9=(ImageButton)findViewById(R.id.button9);
        fuelButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fuelUnits.this,weightUnits.class);
                startActivity(intent);
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitsFuel, R.layout.scroll);
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
    public void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view !=null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);

        }
    }
    public void runTest(AdapterView<?> adapterView, View view, int a, long l ){
        fuelInputB = (EditText) findViewById(R.id.fuelNum);
        fuelInputB.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()== KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                    if(fuelInputB.getText().toString().equals("")||fuelInputB.getText().toString().equals(".")){
                        base=0.0;
                    }
                    else{
                        base=Double.parseDouble(fuelInputB.getText().toString());
                    }
                    ArrayList<Double> arrayList=new ArrayList<>();

                    if(adapterView.getItemAtPosition(a).toString().equals("km/l")){
                        listV=(ListView)findViewById(R.id.list6);
                        arrayList.add((double)(base)); //km/l
                        arrayList.add((double)(base/1.609344)); //mi/l
                        arrayList.add((double)(base*3.78541178)); // km/gal
                        arrayList.add((double)(base*2.35215)); // mi/gal
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("mi/l")){
                        listV=(ListView)findViewById(R.id.list6);
                        arrayList.add((double)(base*1.609)); //km/l
                        arrayList.add((double)(base)); //mi/l
                        arrayList.add((double)(base*6.09203)); // km/gal
                        arrayList.add((double)(base*3.78541178)); // mi/gal
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("km/gal")){
                        listV=(ListView)findViewById(R.id.list6);
                        arrayList.add((double)(base/3.785)); //km/l
                        arrayList.add((double)(base/6.092)); //mi/l
                        arrayList.add((double)(base)); // km/gal
                        arrayList.add((double)(base*0.62137119)); // mi/gal
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("mi/gal")){
                        listV=(ListView)findViewById(R.id.list6);
                        arrayList.add((double)(base/2.352)); //km/l
                        arrayList.add((double)(base*0.2642)); //mi/l
                        arrayList.add((double)(base/2.352)); // km/gal
                        arrayList.add((double)(base)); // mi/gal
                    }
                    closeKeyboard();
                    ArrayAdapter arrayAdapter=new ArrayAdapter(fuelUnits.this, R.layout.row,arrayList);
                    listV.setAdapter(arrayAdapter);

                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}