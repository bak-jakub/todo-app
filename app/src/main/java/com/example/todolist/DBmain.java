package com.example.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmain extends SQLiteOpenHelper {
    public static final String DBNAME = "todo.db";
    public static final String TABLENAME = "tasks";
    public static final String TYTUL = "tytul";
    public static final String OPIS = "opis";
    public static final String DATA_ROZPOCZECIA = "data_rozpoczecia";
    public static final String ID = "id";
    public static final int VER = 1;
    public DBmain(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table "+TABLENAME+"(id integer primary key, tytul text, opis text, data_rozpoczecia text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="drop table if exists "+TABLENAME;
        db.execSQL(query);

        onCreate(db);
    }
    public boolean insertData(String tytul, String opis, String data_rozpoczecia){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TYTUL, tytul);
        cv.put(OPIS, opis);
        cv.put(DATA_ROZPOCZECIA, data_rozpoczecia);

        long results = db.insert(TABLENAME, null, cv);
        return results != -1;
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * FROM "+TABLENAME;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLENAME, "id = ?", new String[]{id});
    }
    public boolean updateData(String id, String tytul, String opis){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TYTUL, tytul);
        cv.put(OPIS, opis);
        Integer result = db.update(TABLENAME, cv, "id=?", new String[]{id});
        if(result < 0){
            return true;
        } else{
            return false;
        }
    }
}
