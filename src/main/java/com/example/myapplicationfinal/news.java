package com.example.myapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplicationfinal.newsadapter;

public class news extends AppCompatActivity {
//        private String[] arr = {"Buy google.","Don't buy stocks."};
//    ListView list;
    TextView textView6;
//    ImageView imageView8;
//    ImageView imageView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
//        newsadapter t = new newsadapter(this,R.layout.newslayout, arr);
//        list.setAdapter(t);
        textView6 = findViewById(R.id.textView7);
//        imageView8 = findViewById(R.id.imageView8);
//        imageView9 = findViewById(R.id.imageView9);
        textView6.setText("M&M and MVML Q4 results: Companies report combined \nnet profit of Rs 163 cr, beat estimates; to pay Rs 8.75 \ndividend.\n\n"
                +"Bulk deals: SBI MF raises stake in Kalpataru Power; Saif India cuts\nholding in Pennar Industries\n\n"+
                "Berger Paints share price falls 4% on muted Q4 results; brokerages maintain \nunderperform rating\n\n"+
                "Tata Motors share price rises 2% as CLSA maintains 'buy'");

    }
}