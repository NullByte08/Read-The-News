package com.example.admin.sqlitedemoapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase sqLiteDatabase=this.openOrCreateDatabase("EventsOfLife", Context.MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("DROP TABLE if exists EventsOfLife");
        sqLiteDatabase.execSQL("CREATE TABLE if not exists EventsOfLife  (NameOfEvent VARCHAR,Year INT(10))");
        sqLiteDatabase.execSQL("INSERT INTO EventsOfLife VALUES ('Joined College',2017)");
        sqLiteDatabase.execSQL("INSERT INTO EventsOfLife VALUES ('Completed School',2016)");
        Cursor c=sqLiteDatabase.rawQuery("SELECT * FROM EventsOfLife",null);
        Log.i("C is:",Integer.toString(c.getCount()));
        int nameindex=c.getColumnIndex("NameOfEvent");
        int yearindex=c.getColumnIndex("Year");
        c.moveToFirst();
        while(c.getPosition()!=c.getCount()){
            
            Log.i("Postition",Integer.toString(c.getPosition()));
            Log.i("name:",c.getString(nameindex));
            Log.i("Year",Integer.toString(c.getInt(yearindex)));
            c.moveToNext();
        }

    }
}
