package com.example.administrator.lifecare;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017-05-24.
 */

public class Database  extends SQLiteOpenHelper {
    public Database(Context context, String name , SQLiteDatabase.CursorFactory factory , int version){
        super(context, name, factory, version);
    }
    @Override
    public  void onCreate(SQLiteDatabase db){
        db.execSQL("create table alarm(title text, time text, date text )");
        db.execSQL("create table setting(title text, flag text)");
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

    public Cursor PrintData(String str) { // 데이터 출력
        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor = db.rawQuery("select * from "+str, null);
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
