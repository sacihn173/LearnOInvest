package com.example.myapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class todaytips extends AppCompatActivity {

    TextView textView8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todaytips);

        textView8 = findViewById(R.id.textView8);
        textView8.setText("No tips for today !");

    }
}