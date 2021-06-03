package com.example.myapplicationfinal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplicationfinal.Model.Price;
import com.example.myapplicationfinal.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyHandler  extends SQLiteOpenHelper {

    public MyHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE" + Params.TABLE_NAME +"("+Params.KEY_ID+" INTEGER PRIMARY KEY,"
                /*+Params.KEY_NAME+" TEXT,"*/+Params.KEY_PRICE+" TEXT"+")";

        Log.d("sdb", "query is runned "+create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStock(Price price){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        values.put(Params.KEY_NAME, price.getName());
        values.put(Params.KEY_PRICE, price.getPrice());

        db.insert(Params.TABLE_NAME, null, values);//inserts in database
        db.close();

    }

    public List<Price> getAllstocks(){     // to recieve
        List<Price> priceList = new ArrayList<Price>();
        SQLiteDatabase db = this.getReadableDatabase();

        // query to read
        String select = "SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor  = db.rawQuery(select, null);

        //loop
        if(cursor.moveToNext()){
            do{
                Price p = new Price();
                p.setId(Integer.parseInt(cursor.getString(0)));
//                p.setName(cursor.getString(1));
                p.setPrice(cursor.getString(2));
                priceList.add(p);
            }while(cursor.moveToNext());
        }
        return priceList;
    }

    public int updatePrice(Price price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
//        values.put(Params.KEY_NAME,price.getName());
        values.put(Params.KEY_PRICE,price.getPrice());

        return db.update(Params.TABLE_NAME,values,Params.KEY_ID+"=?"
        ,new String[]{String.valueOf(price.getId())});
    }

    public void  deleteStock(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME, Params.KEY_ID+"=?",
                new String[]{String.valueOf(id)});
    }

}
