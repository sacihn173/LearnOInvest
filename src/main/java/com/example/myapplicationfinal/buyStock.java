package com.example.myapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class buyStock extends AppCompatActivity {

    public static final  String EXTRA_DEDUCT = "com.example.myapplicationfinal.extra.deduct";
    TextView textView9;
    Button button ;
    Button button4;
    TextView textView19;
    double stockvalue = 125.57;
    String send = Double.toString(stockvalue);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_stock);

        Intent t = getIntent();
        String ss = t.getStringExtra(Allstock.EXTRA_NAME);

        textView9 = findViewById(R.id.textView9);
        textView19 = findViewById(R.id.textView19);
        textView9.setText("   " +ss);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(buyStock.this,balancededuct.class);

                t.putExtra(EXTRA_DEDUCT,send);
                startActivity(t);
            }
        });

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(buyStock.this,sellactivity.class);
                t.putExtra(EXTRA_DEDUCT,send);
                startActivity(t);
            }
        });



        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET,
                "https://api.polygon.io/v1/open-close/AAPL/2021-05-31?unadjusted=true&apiKey=t9K_QGpBtcXLL9o3C5SWoEgPZaST7yI7", //https://api.polygon.io/v1/open-close/crypto/BTC/USD/2021-05-29?unadjusted=true&apiKey=t9K_QGpBtcXLL9o3C5SWoEgPZaST7yI7
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("myapp","Response : "+response.getString("open"));
                    String a = response.getString("open");
                    textView19.setText("$"+a);


                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp","something wrong");
            }
        });

        requestQueue.add(jsonRequest);





    }
}