package com.example.myapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class sellactivity extends AppCompatActivity {

    TextView textView13;
    TextView textView15;
    TextView textView14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellactivity);

        textView13 = findViewById(R.id.textView13);
        textView14 = findViewById(R.id.textView14);
        textView15 = findViewById(R.id.textView15);

        textView13.setText("Balance : ");
        textView15.setText("Congratulations!\nYou Sold the Stock !");

        Intent tt = getIntent();
        String ss = tt.getStringExtra(buyStock.EXTRA_DEDUCT);
        double dd= Double.parseDouble(String.valueOf(ss));



        SharedPreferences shd4 = getSharedPreferences("stock",MODE_PRIVATE);
        String l1 = shd4.getString("st","");
        Double left1 = Double.parseDouble(String.valueOf(l1));

    if(left1>0){
        String ll1 = Double.toString(left1-1);


        SharedPreferences shd111 = getSharedPreferences("stock",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = shd111.edit();
        editor1.putString("st",ll1);
        editor1.apply();

        SharedPreferences shd3 = getSharedPreferences("price",MODE_PRIVATE);
        String l = shd3.getString("pr","");
        Double left = Double.parseDouble(String.valueOf(l));


        String ll = Double.toString(left+dd);


        SharedPreferences shd11 = getSharedPreferences("price",MODE_PRIVATE);
        SharedPreferences.Editor editor = shd11.edit();
        editor.putString("pr",ll);
        editor.apply();

        textView14.setText("$"+ll);

    }
    else{
        Toast.makeText(this, "You don't own any stock !", Toast.LENGTH_SHORT).show();
        SharedPreferences shd3 = getSharedPreferences("price",MODE_PRIVATE);
        String l = shd3.getString("pr","");
        textView14.setText("$"+l);
    }

        }

    }
