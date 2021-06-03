package com.example.myapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {

    private String [] uname = {"aman","ayush","sachin"};
    private String [] passw = {"123","542","876"};

    EditText username;
    EditText password;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    CheckBox checkBox;
    Button login;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        login = findViewById(R.id.login);

        String ss = "10000";
        SharedPreferences shrd = getSharedPreferences("price",MODE_PRIVATE);
        SharedPreferences.Editor editor= shrd.edit();

        editor.putString("pr",ss);
        editor.apply();





        String ss1 = "10";
        SharedPreferences shrd1 = getSharedPreferences("stock",MODE_PRIVATE);
        SharedPreferences.Editor editor1= shrd1.edit();


                    editor1.putString("st",ss1);
                    editor1.apply();








        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Entering market", Toast.LENGTH_SHORT).show();

                String inputName = username.getText().toString();
                String inputPassword = password.getText().toString();
                if(inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter details!", Toast.LENGTH_SHORT).show();
                }
                else{
                        flag = check(inputName,inputPassword);
                        if(flag == false){
                            Toast.makeText(MainActivity.this, "Invalid login", Toast.LENGTH_SHORT).show();

                        }
                        else{
                           // direct to next activity
                            Toast.makeText(MainActivity.this, "Login Successful !", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,homepage.class);
                            startActivity(intent);
                        }
                }
            }
        });
    }

    private boolean check(String name , String pass){
        boolean f = false;
        int index=0;
        for(int i=0; i<uname.length; i++){
            if(name.equals(uname[i])){
                f = true;
                index = i;
//                break;
            }
        }
        if(f){
            if(pass.equals(passw[index])){
                return true;
            }
            else
                return false;
        }
        return false;
    }
}