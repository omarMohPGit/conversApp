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

public class timeUnits extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText timeInputB;
    double base;
    ListView listV;

    public ImageButton timeButton1;
    public ImageButton timeButton2;
    public ImageButton timeButton3;
    public ImageButton timeButton4;
    public ImageButton timeButton5;
    public ImageButton timeButton6;
    public ImageButton timeButton7;
    public ImageButton timeButton8;
    public ImageButton timeButton9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_units);
        getSupportActionBar().hide();

        timeButton1=(ImageButton)findViewById(R.id.button1);
        timeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(timeUnits.this,byteUnits.class);
                startActivity(intent);
            }
        });
        timeButton2=(ImageButton)findViewById(R.id.button2);
        timeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(timeUnits.this,coinUnits.class);
                startActivity(intent);
            }
        });
        timeButton3=(ImageButton)findViewById(R.id.button3);
        timeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(timeUnits.this,fuelUnits.class);
                startActivity(intent);
            }
        });
        timeButton4=(ImageButton)findViewById(R.id.button4);
        timeButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(timeUnits.this,kitchUnits.class);
                startActivity(intent);
            }
        });
        timeButton5=(ImageButton)findViewById(R.id.button5);
        timeButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(timeUnits.this,lengthUnits.class);
                startActivity(intent);
            }
        });
        timeButton6=(ImageButton)findViewById(R.id.button6);
        timeButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(timeUnits.this,pressUnits.class);
                startActivity(intent);
            }
        });
        timeButton7=(ImageButton)findViewById(R.id.button7);
        timeButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(timeUnits.this,tempUnits.class);
                startActivity(intent);
            }
        });
        timeButton8=(ImageButton)findViewById(R.id.button8);
        timeButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(timeUnits.this,timeUnits.class);
                startActivity(intent);
            }
        });
        timeButton9=(ImageButton)findViewById(R.id.button9);
        timeButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(timeUnits.this,weightUnits.class);
                startActivity(intent);
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.spinner8);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitsTime,R.layout.scroll);
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
        timeInputB = (EditText) findViewById(R.id.timeNum);
        timeInputB.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()== KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                    if(timeInputB.getText().toString().equals("")||timeInputB.getText().toString().equals(".")){
                        base=0.0;
                    }
                    else{
                        base=Double.parseDouble(timeInputB.getText().toString());
                    }
                    ArrayList<Double> arrayList=new ArrayList<>();

                    if(adapterView.getItemAtPosition(a).toString().equals("ms")){
                        listV=(ListView)findViewById(R.id.list2);
                        arrayList.add((double)(base)); //ms
                        arrayList.add((double)(base)/1000); //sec
                        arrayList.add((double)(base/60000)); // min
                        arrayList.add((double)(base/3.6e+6)); // hour
                        arrayList.add((double)(base/8.64e+7)); //day
                        arrayList.add((double)(base/6.048e+8));// week
                        arrayList.add((double)(base/2.628e+9));// month
                        arrayList.add((double)(base/ 3.154e+10));// year
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("sec")){
                        listV=(ListView)findViewById(R.id.list2);
                        arrayList.add((double)(base*1000)); //ms
                        arrayList.add((double)(base)); //sec
                        arrayList.add((double)(base/60)); // min
                        arrayList.add((double)(base/3600)); // hour
                        arrayList.add((double)(base/86400)); //day
                        arrayList.add((double)(base/604800));// week
                        arrayList.add((double)(base/2.628e+6));// month
                        arrayList.add((double)(base/3.154e+7));// year
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("min")){
                        listV=(ListView)findViewById(R.id.list2);
                        arrayList.add((double)(base*60000)); //ms
                        arrayList.add((double)(base*60)); //sec
                        arrayList.add((double)(base)); // min
                        arrayList.add((double)(base/60)); // hour
                        arrayList.add((double)(base/1440)); //day
                        arrayList.add((double)(base/10080));// week
                        arrayList.add((double)(base/43800));// month
                        arrayList.add((double)(base/525600));// year
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("hour")){
                        listV=(ListView)findViewById(R.id.list2);
                        arrayList.add((double)(base*3.6e+6)); //ms
                        arrayList.add((double)(base*3600)); //sec
                        arrayList.add((double)(base*60)); // min
                        arrayList.add((double)(base)); // hour
                        arrayList.add((double)(base/24)); //day
                        arrayList.add((double)(base/168));// week
                        arrayList.add((double)(base/730));// month
                        arrayList.add((double)(base/8760));// year
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("day")){
                        listV=(ListView)findViewById(R.id.list2);
                        arrayList.add((double)(base*8.64e+7)); //ms
                        arrayList.add((double)(base* 86400)); //sec
                        arrayList.add((double)(base* 1440)); // min
                        arrayList.add((double)(base*24)); // hour
                        arrayList.add((double)(base)); //day
                        arrayList.add((double)(base/7));// week
                        arrayList.add((double)(base/30.417));// month
                        arrayList.add((double)(base/365));// year
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("week")){
                        listV=(ListView)findViewById(R.id.list2);
                        arrayList.add((double)(base*6.048e+8)); //ms
                        arrayList.add((double)(base* 604800)); //sec
                        arrayList.add((double)(base* 10080)); // min
                        arrayList.add((double)(base*168)); // hour
                        arrayList.add((double)(base*7)); //day
                        arrayList.add((double)(base));// week
                        arrayList.add((double)(base/4.345));// month
                        arrayList.add((double)(base/52.143));// year
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("month")){
                        listV=(ListView)findViewById(R.id.list2);
                        arrayList.add((double)(base*2.628e+9)); //ms
                        arrayList.add((double)(base* 2.628e+6)); //sec
                        arrayList.add((double)(base* 43800)); // min
                        arrayList.add((double)(base* 730)); // hour
                        arrayList.add((double)(base* 30.417)); //day
                        arrayList.add((double)(base*4.345));// week
                        arrayList.add((double)(base));// month
                        arrayList.add((double)(base/12));// year
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("year")){
                        listV=(ListView)findViewById(R.id.list2);
                        arrayList.add((double)(base*3.154e+10)); //ms
                        arrayList.add((double)(base*3.154e+7)); //sec
                        arrayList.add((double)(base* 525600)); // min
                        arrayList.add((double)(base*  8760)); // hour
                        arrayList.add((double)(base* 365)); //day
                        arrayList.add((double)(base*52.143));// week
                        arrayList.add((double)(base*12));// month
                        arrayList.add((double)(base));// year
                    }

                    closeKeyboard();
                    ArrayAdapter arrayAdapter=new ArrayAdapter(timeUnits.this, R.layout.row,arrayList);
                    listV.setAdapter(arrayAdapter);

                    return true;
                }
                return false;
            }
        });
    }
}