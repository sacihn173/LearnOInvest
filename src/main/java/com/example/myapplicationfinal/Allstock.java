package com.example.myapplicationfinal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Allstock extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.myapplicationfinal.extra,name";


    public class sachinAdapter extends ArrayAdapter<String> {


        private String[] s;


        public sachinAdapter(@NonNull Context context, int resource, @NonNull String []s) {
            super(context, resource, s);
            this.s  = s;

        }

        @Nullable
        @Override
        public String getItem(int position) {
            return s[position];
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.sachinlayout,parent,false);
            TextView t = convertView.findViewById(R.id.textView5);
            Button button2 = convertView.findViewById(R.id.button2);
            Button button3 = convertView.findViewById(R.id.button3);
            String s = t.getText().toString();




            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent t = new Intent(Allstock.this, buyStock.class);
//                    t.putExtra(EXTRA_NAME,s);
                    startActivity(t);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent t = new Intent(Allstock.this, buyStock.class);
//                    t.putExtra(EXTRA_NAME,s);
                    startActivity(t);
                }
            });


            t.setText(getItem(position));

            return convertView;
        }

    }

    ListView listView;
//    Button button2;

    private String[]s = {"\n Google  \n",
            "\n Apple  \n",
            "\n Tesla \n ",
            "\n Reliance  \n",
            "\n ITC Ltd \n ",
            "\n TCS Ltd \n ",
            "\n Microsoft \n",
            "\n Axis Bank \n",
            "\n Tata  \n",
            "\n Github \n",
            "\n Tata Steel \n ",
            "\n SBI  \n",
            "\n Netflix \n ",
            "\n Jindal Steel \n ",
            "\n Tata Tea \n",
            "\n Tata Motors \n",
            "\n Maruti  \n"};
   private String[]p = {"Current Price : $10","Current Price : $120","Current Price : $15","Current Price : $149","Current Price : $10","Current Price : $30","Current Price : $164.3","Current Price : $12.33","Current Price : $10.22","Current Price : $111","Current Price : $18","Current Price : $19.22","Current Price : $199","Current Price : $11","Current Price : $10","Current Price : $10","Current Price : $10"};
//    private String []c ={"Previous Closing : $12","Previous Closing : $120","Previous Closing : $15","Previous Closing : $150","Previous Closing : $12","Previous Closing : $12","Previous Closing : $33","Previous Closing : $170","Previous Closing : $12","Previous Closing : $12","Previous Closing : $122","Previous Closing : $19","Previous Closing : $210","Previous Closing : $12","Previous Closing : $18.2","Previous Closing : $11.1","Previous Closing : $12"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsac);
        listView = findViewById(R.id.listView);



        // using built in adapter
        ArrayAdapter<String> ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,s);
//        sachinAdapter ad = new sachinAdapter(this,R.layout.sachinlayout,s);

        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent t = new Intent(Allstock.this,buyStock.class);
                t.putExtra(EXTRA_NAME,s[position]);
                startActivity(t);
            }
        });
//        Intent t = new Intent(Allstock.this, buyStock.class);
//        startActivity(t);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(Allstock.this,"hii", Toast.LENGTH_SHORT).show();
//                Intent t = new Intent(Allstock.this, buyStock.class);
//                startActivity(t);
//            }
//        });





//        listView.setAdapter(ad);
//        MyHandler h = new MyHandler(Allstock.this );
//
//        Price google = new Price(); // adding to database
//        google.setName("Google");
//        google.setPrice("$12");
//        h.addStock(google);
//
//        Price googl = new Price();
//        googl.setName("Google");
//        googl.setPrice("$12");
//        h.addStock(googl);
//
//        List<Price> allprice = h.getAllstocks();  // recieving from database
//        for(Price price : allprice){
//                Log.d();
//        }
//
//
//        // updating in database using method from myhandler
//        google.setId(1);
//        google.setPrice("$10");
//        h.updatePrice(google);






    }

}