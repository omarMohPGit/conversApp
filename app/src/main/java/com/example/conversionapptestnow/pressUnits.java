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

public class pressUnits extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText pressInputB;
    double base;
    ListView listV;

    public ImageButton pressButton1;
    public ImageButton pressButton2;
    public ImageButton pressButton3;
    public ImageButton pressButton4;
    public ImageButton pressButton5;
    public ImageButton pressButton6;
    public ImageButton pressButton7;
    public ImageButton pressButton8;
    public ImageButton pressButton9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press_units);
        getSupportActionBar().hide();

        pressButton1=(ImageButton)findViewById(R.id.button1);
        pressButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pressUnits.this,byteUnits.class);
                startActivity(intent);
            }
        });
        pressButton2=(ImageButton)findViewById(R.id.button2);
        pressButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pressUnits.this,coinUnits.class);
                startActivity(intent);
            }
        });
        pressButton3=(ImageButton)findViewById(R.id.button3);
        pressButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pressUnits.this,fuelUnits.class);
                startActivity(intent);
            }
        });
        pressButton4=(ImageButton)findViewById(R.id.button4);
        pressButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pressUnits.this,kitchUnits.class);
                startActivity(intent);
            }
        });
        pressButton5=(ImageButton)findViewById(R.id.button5);
        pressButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pressUnits.this,lengthUnits.class);
                startActivity(intent);
            }
        });
        pressButton6=(ImageButton)findViewById(R.id.button6);
        pressButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pressUnits.this,pressUnits.class);
                startActivity(intent);
            }
        });
        pressButton7=(ImageButton)findViewById(R.id.button7);
        pressButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pressUnits.this,tempUnits.class);
                startActivity(intent);
            }
        });
        pressButton8=(ImageButton)findViewById(R.id.button8);
        pressButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pressUnits.this,timeUnits.class);
                startActivity(intent);
            }
        });
        pressButton9=(ImageButton)findViewById(R.id.button9);
        pressButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pressUnits.this,weightUnits.class);
                startActivity(intent);
            }
        });


        Spinner spinner = (Spinner)findViewById(R.id.spinner6);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitsPres, R.layout.scroll);
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
        pressInputB = (EditText) findViewById(R.id.pressNum);
        pressInputB.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()== KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                    if(pressInputB.getText().toString().equals("")||pressInputB.getText().toString().equals(".")){
                        base=0.0;
                    }
                    else{
                        base=Double.parseDouble(pressInputB.getText().toString());
                    }
                    ArrayList<Double> arrayList=new ArrayList<>();

                    if(adapterView.getItemAtPosition(a).toString().equals("atm")){
                        listV=(ListView)findViewById(R.id.list4);
                        arrayList.add((double)(base)); //atm
                        arrayList.add((double)(base*1.01325)); //bar
                        arrayList.add((double)(base*1013.25)); // mbar
                        arrayList.add((double)(base/9.869)); // MPa
                        arrayList.add((double)(base*101.325)); // kPa
                        arrayList.add((double)(base* 101325));// Pa
                        arrayList.add((double)(base*2116.2));// psf
                        arrayList.add((double)(base*14.696));// psi
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("bar")){
                        listV=(ListView)findViewById(R.id.list4);
                        arrayList.add((double)(base/1.013)); //atm
                        arrayList.add((double)(base)); //bar
                        arrayList.add((double)(base*1000)); // mbar
                        arrayList.add((double)(base/10)); // MPa
                        arrayList.add((double)(base*100)); // kPa
                        arrayList.add((double)(base*100000));// Pa
                        arrayList.add((double)(base* 2088.58));// psf
                        arrayList.add((double)(base*14.5038));// psi
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("mbar")){
                        listV=(ListView)findViewById(R.id.list4);
                        arrayList.add((double)(base/1013)); //atm
                        arrayList.add((double)(base/1000)); //bar
                        arrayList.add((double)(base)); // mbar
                        arrayList.add((double)(base/10000)); // MPa
                        arrayList.add((double)(base/10)); // kPa
                        arrayList.add((double)(base*100));// Pa
                        arrayList.add((double)(base*2.0885));// psf
                        arrayList.add((double)(base/ 68.948));// psi
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("MPa")){
                        listV=(ListView)findViewById(R.id.list4);
                        arrayList.add((double)(base*9.86923)); //atm
                        arrayList.add((double)(base*10)); //bar
                        arrayList.add((double)(base*10000)); // mbar
                        arrayList.add((double)(base)); // MPa
                        arrayList.add((double)(base*1000)); // kPa
                        arrayList.add((double)(base*1e+6));// Pa
                        arrayList.add((double)(base*20885.43));// psf
                        arrayList.add((double)(base*145.038));// psi
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("kPa")){
                        listV=(ListView)findViewById(R.id.list4);
                        arrayList.add((double)(base/101)); //atm
                        arrayList.add((double)(base/100)); //bar
                        arrayList.add((double)(base*10)); // mbar
                        arrayList.add((double)(base/1000)); // MPa
                        arrayList.add((double)(base)); // kPa
                        arrayList.add((double)(base*1000));// Pa
                        arrayList.add((double)(base*20.88543));// psf
                        arrayList.add((double)(base/6.895));// psi
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("Pa")){
                        listV=(ListView)findViewById(R.id.list4);
                        arrayList.add((double)(base/101325)); //atm
                        arrayList.add((double)(base/100000)); //bar
                        arrayList.add((double)(base/100)); // mbar
                        arrayList.add((double)(base/1e+6)); // MPa
                        arrayList.add((double)(base/1000)); // kPa
                        arrayList.add((double)(base));// Pa
                        arrayList.add((double)(base*0.020885));// psf
                        arrayList.add((double)(base/6895));// psi
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("psf")){
                        listV=(ListView)findViewById(R.id.list4);
                        arrayList.add((double)(base*2116)); //atm
                        arrayList.add((double)(base*0.000479)); //bar
                        arrayList.add((double)(base*0.478802)); // mbar
                        arrayList.add((double)(base*0.000047880258)); // MPa
                        arrayList.add((double)(base*0.047880258)); // kPa
                        arrayList.add((double)(base*47.880208));// Pa
                        arrayList.add((double)(base));// psf
                        arrayList.add((double)(base*0.00694444));// psi
                    }

                    if(adapterView.getItemAtPosition(a).toString().equals("psi")){
                        listV=(ListView)findViewById(R.id.list4);
                        arrayList.add((double)(base/14.696)); //atm
                        arrayList.add((double)(base/14.504)); //bar
                        arrayList.add((double)(base*68.9476)); // mbar
                        arrayList.add((double)(base/145)); // MPa
                        arrayList.add((double)(base*6.89476)); // kPa
                        arrayList.add((double)(base*6894.76));// Pa
                        arrayList.add((double)(base*144));// psf
                        arrayList.add((double)(base));// psi
                    }
                    closeKeyboard();
                    ArrayAdapter arrayAdapter=new ArrayAdapter(pressUnits.this, R.layout.row,arrayList);
                    listV.setAdapter(arrayAdapter);

                    return true;
                }
                return false;
            }
        });
    }
}