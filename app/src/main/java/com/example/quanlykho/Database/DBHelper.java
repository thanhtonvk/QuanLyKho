package com.example.quanlykho.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "CSDL.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create  table NhapHang(" +
                "id integer primary key autoincrement," +
                "nguoiNhap nvarchar(50)," +
                "ngayNhap nvarchar(50)," +
                "congTy nvarchar(50))");
        sqLiteDatabase.execSQL("create table CTNhapHang(" +
                "id integer primary key autoincrement," +
                "tenHH nvarchar(50)," +
                "loaiHH nvarchar(50)," +
                "kichThuoc float," +
                "soLuong integer," +
                "donViTinh nvarchar(50)," +
                "idNhapHang integer)");
        sqLiteDatabase.execSQL("create table XuatHang(" +
                "id integer primary key autoincrement," +
                "nguoiXuat nvarchar(50)," +
                "ngayXuat nvarchar(50)," +
                "congTy nvarchar(50))");
        sqLiteDatabase.execSQL("create table CTXuatHang(" +
                "id integer primary key autoincrement," +
                "idXuatHang integer," +
                "idCTNhapHang integer," +
                "soLuong integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
