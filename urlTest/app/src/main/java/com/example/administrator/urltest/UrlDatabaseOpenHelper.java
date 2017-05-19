package com.example.administrator.urltest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yh on 2017-05-16.
 */

public class UrlDatabaseOpenHelper extends SQLiteOpenHelper{

    public UrlDatabaseOpenHelper(Context context, String name , SQLiteDatabase.CursorFactory factory , int version){
            super(context, name, factory, version);
    }
    @Override
    public  void onCreate(SQLiteDatabase db){
        db.execSQL("create table url_list(title text, url text, date text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion){

    }

    public void insert(String _query) { // 레코드 추가
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void update(String _query) { //레코드 변경
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void delete(String _query) { // 레코드 삭제
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public Cursor PrintData() { // 데이터 출력
        SQLiteDatabase db = getReadableDatabase();
        String str = "";

        Cursor cursor = db.rawQuery("select * from url_list", null);
       /* while(cursor.moveToNext()) {
            str += cursor.getInt(0)
                    + " : foodName "
                    + cursor.getString(1)
                    + ", price = "
                    + cursor.getInt(2)
                    + "\n";
        }*/

        return cursor;
    }
}
