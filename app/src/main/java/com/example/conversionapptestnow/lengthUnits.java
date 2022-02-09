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

public class lengthUnits extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText lengthInputB;
    double base;
    ListView listV;

    public ImageButton lenButton1;
    public ImageButton lenButton2;
    public ImageButton lenButton3;
    public ImageButton lenButton4;
    public ImageButton lenButton5;
    public ImageButton lenButton6;
    public ImageButton lenButton7;
    public ImageButton lenButton8;
    public ImageButton lenButton9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_units);
        getSupportActionBar().hide();

        lenButton1=(ImageButton)findViewById(R.id.button1);
        lenButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lengthUnits.this,byteUnits.class);
                startActivity(intent);
            }
        });
        lenButton2=(ImageButton)findViewById(R.id.button2);
        lenButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lengthUnits.this,coinUnits.class);
                startActivity(intent);
            }
        });
        lenButton3=(ImageButton)findViewById(R.id.button3);
        lenButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lengthUnits.this,fuelUnits.class);
                startActivity(intent);
            }
        });
        lenButton4=(ImageButton)findViewById(R.id.button4);
        lenButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lengthUnits.this,kitchUnits.class);
                startActivity(intent);
            }
        });
        lenButton5=(ImageButton)findViewById(R.id.button5);
        lenButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lengthUnits.this,lengthUnits.class);
                startActivity(intent);
            }
        });
        lenButton6=(ImageButton)findViewById(R.id.button6);
        lenButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lengthUnits.this,pressUnits.class);
                startActivity(intent);
            }
        });
        lenButton7=(ImageButton)findViewById(R.id.button7);
        lenButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lengthUnits.this,tempUnits.class);
                startActivity(intent);
            }
        });
        lenButton8=(ImageButton)findViewById(R.id.button8);
        lenButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lengthUnits.this,timeUnits.class);
                startActivity(intent);
            }
        });
        lenButton9=(ImageButton)findViewById(R.id.button9);
        lenButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lengthUnits.this,weightUnits.class);
                startActivity(intent);
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitsLength, R.layout.scroll);
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
        lengthInputB = (EditText) findViewById(R.id.lengthNum);
        lengthInputB.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()== KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                    if(lengthInputB.getText().toString().equals("")||lengthInputB.getText().toString().equals(".")){
                        base=0.0;
                    }
                    else{
                        base=Double.parseDouble(lengthInputB.getText().toString());
                    }
                    ArrayList<Double> arrayList=new ArrayList<>();

                    if(adapterView.getItemAtPosition(a).toString().equals("mm")){
                        listV=(ListView)findViewById(R.id.list7);
                        arrayList.add((double)(base)); //mm
                        arrayList.add((double)(base)/10); //cm
                        arrayList.add((double)(base/1000)); //m
                        arrayList.add((double)(base/1e+6)); // km
                        arrayList.add((double)(base/25.4));// inch
                        arrayList.add((double)(base/305));// foot
                        arrayList.add((double)(base/914));// yard
                        arrayList.add((double)(base/1.609e+6));// mile
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("cm")){
                        listV=(ListView)findViewById(R.id.list7);
                        arrayList.add((double)(base*10)); //mm
                        arrayList.add((double)(base)); //cm
                        arrayList.add((double)(base/100)); //m
                        arrayList.add((double)(base/100000)); // km
                        arrayList.add((double)(base/ 2.54));// inch
                        arrayList.add((double)(base/30.48));// foot
                        arrayList.add((double)(base/91.44));// yard
                        arrayList.add((double)(base/160934));// mile
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("m")){
                        listV=(ListView)findViewById(R.id.list7);
                        arrayList.add((double)(base*1000)); //mm
                        arrayList.add((double)(base*100)); //cm
                        arrayList.add((double)(base)); //m
                        arrayList.add((double)(base/1000)); // km
                        arrayList.add((double)(base* 39.37));// inch
                        arrayList.add((double)(base*3.281));// foot
                        arrayList.add((double)(base*1.094));// yard
                        arrayList.add((double)(base/1609));// mile
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("km")){
                        listV=(ListView)findViewById(R.id.list7);
                        arrayList.add((double)(base*1e+6)); //mm
                        arrayList.add((double)(base*100000)); //cm
                        arrayList.add((double)(base*1000)); //m
                        arrayList.add((double)(base)); // km
                        arrayList.add((double)(base* 39370));// inch
                        arrayList.add((double)(base*3281));// foot
                        arrayList.add((double)(base*1094));// yard
                        arrayList.add((double)(base/1.609));// mile
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("inch")){
                        listV=(ListView)findViewById(R.id.list7);
                        arrayList.add((double)(base*25.4)); //mm
                        arrayList.add((double)(base*2.54)); //cm
                        arrayList.add((double)(base/39.37)); //m
                        arrayList.add((double)(base/39370)); // km
                        arrayList.add((double)(base));// inch
                        arrayList.add((double)(base/12));// foot
                        arrayList.add((double)(base/36));// yard
                        arrayList.add((double)(base/63360));// mile
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("foot")){
                        listV=(ListView)findViewById(R.id.list7);
                        arrayList.add((double)(base*304.8)); //mm
                        arrayList.add((double)(base*30.48)); //cm
                        arrayList.add((double)(base/3.281)); //m
                        arrayList.add((double)(base/3281)); // km
                        arrayList.add((double)(base*12));// inch
                        arrayList.add((double)(base));// foot
                        arrayList.add((double)(base/3));// yard
                        arrayList.add((double)(base/5280));// mile
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("yard")){
                        listV=(ListView)findViewById(R.id.list7);
                        arrayList.add((double)(base*914.4)); //mm
                        arrayList.add((double)(base*91.44)); //cm
                        arrayList.add((double)(base/1.094)); //m
                        arrayList.add((double)(base/1094)); // km
                        arrayList.add((double)(base*36));// inch
                        arrayList.add((double)(base*3));// foot
                        arrayList.add((double)(base));// yard
                        arrayList.add((double)(base/ 1760));// mile
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("mile")){
                        listV=(ListView)findViewById(R.id.list7);
                        arrayList.add((double)(base*1.609e+6)); //mm
                        arrayList.add((double)(base*160934)); //cm
                        arrayList.add((double)(base*1609)); //m
                        arrayList.add((double)(base*1.609)); // km
                        arrayList.add((double)(base*63360));// inch
                        arrayList.add((double)(base*5280));// foot
                        arrayList.add((double)(base*1760));// yard
                        arrayList.add((double)(base));// mile
                    }


                    closeKeyboard();
                    ArrayAdapter arrayAdapter=new ArrayAdapter(lengthUnits.this, R.layout.row,arrayList);
                    listV.setAdapter(arrayAdapter);

                    return true;
                }
                return false;
            }
        });
    }
}