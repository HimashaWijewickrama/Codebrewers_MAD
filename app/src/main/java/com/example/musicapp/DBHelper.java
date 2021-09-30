package com.example.musicapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Trackdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        //sqlite query for create track details table
        DB.execSQL("create Table Trackdetails(trackName TEXT primary key,txttrack TEXT,txtart TEXT,txtdes TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

        //sqlite query for drop track details table
        DB.execSQL("drop Table if exists Trackdetails");


    }
    //insert data to the trackdetails table
    public Boolean inserttrackdata(String trackName,String txttrack,String txtart,String txtdes){
        //pass data to the table
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("trackName",trackName);
        contentValues.put("txttrack",txttrack);
        contentValues.put("txtart",txtart);
        contentValues.put("txtdes",txtdes);
        long result=DB.insert("Trackdetails",null,contentValues);
        if(result==-1){
            return false;

        }else{
            return true;
        }

    }

    //update data without trackID of the trackdetails table
    public boolean updatetrackdata(String trackName,String txttrack,String txtart,String txtdes){
        //pass data to the table
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("txttrack",txttrack);
        contentValues.put("txtart",txtart);
        contentValues.put("txtdes",txtdes);
        Cursor cursor=DB.rawQuery("Select * from Trackdetails where trackName=?",new String[]{trackName});
        if(cursor.getCount()>0)
        {


            long result = DB.update("Trackdetails", contentValues, "trackName=?", new String[]{trackName});
            if (result == -1) {
                return false;

            } else {
                return true;
            }
        }else
        {
            return false;
        }

    }
    //delete track table data

    public Boolean deletedata(String trackName){
        //pass data to the table
        SQLiteDatabase DB=this.getWritableDatabase();

        Cursor cursor=DB.rawQuery("Select * from Trackdetails where trackName=?",new String[]{trackName});
        if(cursor.getCount()>0)
        {


            long result = DB.delete("Trackdetails", "trackName=?", new String[]{trackName});
            if (result == -1) {
                return false;

            } else {
                return true;
            }
        }else
        {
            return false;
        }

    }

    //get data from the trackdetails table
    public Cursor getdata(){
        SQLiteDatabase DB=this.getWritableDatabase();



        Cursor cursor=DB.rawQuery("Select * from Trackdetails",null);

        return cursor;
    }

}


    //insert data to the table method
    //public Boolean insertalbumdata(String editID, String editTitle, String editCreate, String editDesc) {
        //pass data to the table
        //SQLiteDatabase DB = this.getWritableDatabase();
        //ContentValues contentValues = new ContentValues();
        //contentValues.put("editID", editID);
        //contentValues.put("editTitle", editTitle);
        //contentValues.put("editCreate", editCreate);
        //contentValues.put("editDesc", editDesc);
        //long result = DB.insert("Albumdetails", null, contentValues);
        //if (result == -1) {
            //return false;
        //}else{
           // return true;
        //}



    //}









