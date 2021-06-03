package com.example.myapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class portfolio extends AppCompatActivity {
    TextView int1;
    TextView int2;
    TextView int3;
    TextView textView10;
    TextView textView17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        Double b = 10000.00;
        String ss = Double.toString(b);
        textView10= findViewById(R.id.textView10);
        textView17= findViewById(R.id.textView17);

//        SharedPreferences shrd = getSharedPreferences("price",MODE_PRIVATE);
//        SharedPreferences.Editor editor= shrd.edit();
//
//        editor.putString("pr",ss);
//        editor.apply();

        SharedPreferences shd = getSharedPreferences("price",MODE_PRIVATE);
        String left = shd.getString("pr","");

        SharedPreferences shd1 = getSharedPreferences("stock",MODE_PRIVATE);
        String left1 = shd1.getString("st","");

//        Intent t = getIntent();
//        String sss = t.getStringExtra(buyStock.EXTRA_DEDUCT);
//        int dd= Integer.parseInt(sss);



        textView17.setText(left1);

        textView10.setText("$"+left);
        int1 = findViewById(R.id.int1);
        int2 = findViewById(R.id.int2);
        int3 = findViewById(R.id.int3);
    }
}