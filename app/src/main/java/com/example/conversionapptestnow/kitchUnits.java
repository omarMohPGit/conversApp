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

public class kitchUnits extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText kitchInputB;
    double base;
    ListView listV;

    public ImageButton kitchButton1;
    public ImageButton kitchButton2;
    public ImageButton kitchButton3;
    public ImageButton kitchButton4;
    public ImageButton kitchButton5;
    public ImageButton kitchButton6;
    public ImageButton kitchButton7;
    public ImageButton kitchButton8;
    public ImageButton kitchButton9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitch_units);
        getSupportActionBar().hide();

        kitchButton1=(ImageButton)findViewById(R.id.button1);
        kitchButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(kitchUnits.this,byteUnits.class);
                startActivity(intent);
            }
        });
        kitchButton2=(ImageButton)findViewById(R.id.button2);
        kitchButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(kitchUnits.this,coinUnits.class);
                startActivity(intent);
            }
        });
        kitchButton3=(ImageButton)findViewById(R.id.button3);
        kitchButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(kitchUnits.this,fuelUnits.class);
                startActivity(intent);
            }
        });
        kitchButton4=(ImageButton)findViewById(R.id.button4);
        kitchButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(kitchUnits.this,kitchUnits.class);
                startActivity(intent);
            }
        });
        kitchButton5=(ImageButton)findViewById(R.id.button5);
        kitchButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(kitchUnits.this,lengthUnits.class);
                startActivity(intent);
            }
        });
        kitchButton6=(ImageButton)findViewById(R.id.button6);
        kitchButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(kitchUnits.this,pressUnits.class);
                startActivity(intent);
            }
        });
        kitchButton7=(ImageButton)findViewById(R.id.button7);
        kitchButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(kitchUnits.this,tempUnits.class);
                startActivity(intent);
            }
        });
        kitchButton8=(ImageButton)findViewById(R.id.button8);
        kitchButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(kitchUnits.this,timeUnits.class);
                startActivity(intent);
            }
        });
        kitchButton9=(ImageButton)findViewById(R.id.button9);
        kitchButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(kitchUnits.this,weightUnits.class);
                startActivity(intent);
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.spinner5);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitsKitch, R.layout.scroll);
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
        kitchInputB = (EditText) findViewById(R.id.kitchNum);
        kitchInputB.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()== KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                    if(kitchInputB.getText().toString().equals("")||kitchInputB.getText().toString().equals(".")){
                        base=0.0;
                    }
                    else{
                        base=Double.parseDouble(kitchInputB.getText().toString());
                    }
                    ArrayList<Double> arrayList=new ArrayList<>();

                    if(adapterView.getItemAtPosition(a).toString().equals("ml")){
                        listV=(ListView)findViewById(R.id.list5);
                        arrayList.add((double)(base)); //ml
                        arrayList.add((double)(base)/4.929); //teaspoon
                        arrayList.add((double)(base/14.787)); // tablespoon
                        arrayList.add((double)(base/ 237)); // cup
                        arrayList.add((double)(base/29.574)); // fl oz
                        arrayList.add((double)(base/568));// pt
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("teaspoon")){
                        listV=(ListView)findViewById(R.id.list5);
                        arrayList.add((double)(base*4.92892)); //ml
                        arrayList.add((double)(base)); //teaspoon
                        arrayList.add((double)(base/3)); // tablespoon
                        arrayList.add((double)(base/ 48)); // cup
                        arrayList.add((double)(base/6)); // fl oz
                        arrayList.add((double)(base/96));// pt
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("tablespoon")){
                        listV=(ListView)findViewById(R.id.list5);
                        arrayList.add((double)(base*14.7868)); //ml
                        arrayList.add((double)(base*3)); //teaspoon
                        arrayList.add((double)(base)); // tablespoon
                        arrayList.add((double)(base/ 16)); // cup
                        arrayList.add((double)(base/2)); // fl oz
                        arrayList.add((double)(base/32));// pt
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("Cup")){
                        listV=(ListView)findViewById(R.id.list5);
                        arrayList.add((double)(base*236.588)); //ml
                        arrayList.add((double)(base*48)); //teaspoon
                        arrayList.add((double)(base* 16)); // tablespoon
                        arrayList.add((double)(base)); // cup
                        arrayList.add((double)(base*8)); // fl oz
                        arrayList.add((double)(base/2));// pt
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("fl oz")){
                        listV=(ListView)findViewById(R.id.list5);
                        arrayList.add((double)(base*29.574)); //ml
                        arrayList.add((double)(base*6)); //teaspoon
                        arrayList.add((double)(base*2)); // tablespoon
                        arrayList.add((double)(base/8)); // cup
                        arrayList.add((double)(base)); // fl oz
                        arrayList.add((double)(base/16));// pt
                    }
                    if(adapterView.getItemAtPosition(a).toString().equals("pt")){
                        listV=(ListView)findViewById(R.id.list5);
                        arrayList.add((double)(base*473.176473)); //ml
                        arrayList.add((double)(base*96)); //teaspoon
                        arrayList.add((double)(base*32)); // tablespoon
                        arrayList.add((double)(base*2)); // cup
                        arrayList.add((double)(base*16)); // fl oz
                        arrayList.add((double)(base));// pt
                    }
                    closeKeyboard();
                    ArrayAdapter arrayAdapter=new ArrayAdapter(kitchUnits.this, R.layout.row,arrayList);
                    listV.setAdapter(arrayAdapter);

                    return true;
                }
                return false;
            }
        });
    }
}