package com.hoangthang11051.nguyenhoangthang;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class thoitiet_db extends SQLiteOpenHelper {
    public static final String DATABASE = "THOITIET";
    public static final String NAME = "TEN";
    public static final String NHIETDO = "NHIETDO";
    public static final String KIEU = "KIEU";

    private SQLiteDatabase db;

    public thoitiet_db(Context context) {
        super(context, DATABASE, null, 1);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table THOITIET (TEN nvarchar(50), NHIETDO int, KIEU char(10))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists THOITIET";
        this.db.execSQL(sql);
    }

    public long insertTT(ItemThoitiet tt) {
        ContentValues cv = new ContentValues();
        cv.put(NAME, tt.tenquocgia);
        cv.put(NHIETDO, tt.nhietdo);
        cv.put(KIEU, tt.getKieuThoiTiet());
        return db.insert("THOITIET", null, cv);
    }
}
