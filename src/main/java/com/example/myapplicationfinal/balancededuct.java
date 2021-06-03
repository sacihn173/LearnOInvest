package com.example.myapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class balancededuct extends AppCompatActivity {

    TextView textView12;
    TextView textView11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balancededuct);

        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);

        textView12.setText("Current balance is : ");

        Intent t = getIntent();
        String ss = t.getStringExtra(buyStock.EXTRA_DEDUCT);
        Double dd= Double.parseDouble(String.valueOf(ss));

        SharedPreferences shd = getSharedPreferences("price",MODE_PRIVATE);
        String l = shd.getString("pr","");
        Double left = Double.parseDouble(String.valueOf(l));





        if(left > dd){
            String ll = Double.toString(left-dd);
//
//            SharedPreferences.Editor edit ;
//            ed = shd.edit();
//            ed.putString("pv",l);
//            ed.apply();

//             edit = PreferenceManager.getDefaultSharedPreferences(this).edit();
//            edit.putString("pr",l);
//            edit.apply();
            String s = "s";
            SharedPreferences shd1 = getSharedPreferences("price",MODE_PRIVATE);
            SharedPreferences.Editor editor = shd1.edit();


                        editor.putString("pr",ll);
                        editor.apply();

                        textView11.setText("$"+ll);






        }
        else{
            Toast.makeText(this, "Invalid Transition !", Toast.LENGTH_SHORT).show();
            textView11.setText("$"+ss);
        }


        SharedPreferences shd1 = getSharedPreferences("stock",MODE_PRIVATE);
        String l1 = shd1.getString("st","");
        Double left1 = Double.parseDouble(String.valueOf(l1));

        String ll1 = Double.toString(left1+1);

        SharedPreferences shd11 = getSharedPreferences("stock",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = shd11.edit();
        editor1.putString("st",ll1);
        editor1.apply();

    }
}