package com.example.quanlykho.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quanlykho.Database.DBHelper;
import com.example.quanlykho.Entity.CTNhapHang;

import java.util.ArrayList;
import java.util.List;

public class CTNhapHangDAO {
    public DBHelper dbHelper;
    public Context context;
    SQLiteDatabase database;

    public CTNhapHangDAO(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    private Cursor getCursor(int idNhapHang) {
        Cursor cursor = database.rawQuery("select * from CTNhapHang where idNhapHang = " + idNhapHang, null);
        return cursor;
    }

    public List<CTNhapHang> getCTNhapHangs(int idNhapHang) {
        Cursor cursor = getCursor(idNhapHang);
        cursor.moveToFirst();
        List<CTNhapHang> ctNhapHangList = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            CTNhapHang ctNhapHang = new CTNhapHang();
            ctNhapHang.setId(cursor.getInt(0));
            ctNhapHang.setTenHH(cursor.getString(1));
            ctNhapHang.setLoaiHH(cursor.getString(2));
            ctNhapHang.setKichThuoc(cursor.getString(3));
            ctNhapHang.setSoLuong(cursor.getInt(4));
            ctNhapHang.setDonViTinh(cursor.getString(5));
            ctNhapHang.setIdNhapHang(cursor.getInt(6));
            ctNhapHangList.add(ctNhapHang);
            cursor.moveToNext();
        }
        Log.e("logra", String.valueOf(ctNhapHangList.size()));
        return ctNhapHangList;
    }

    public void insert(CTNhapHang ctNhapHang, boolean isUpdate) {
        ContentValues values = new ContentValues();
        values.put("tenHH", ctNhapHang.getTenHH());
        values.put("loaiHH", ctNhapHang.getLoaiHH());
        values.put("kichThuoc", ctNhapHang.getKichThuoc());
        values.put("soLuong", ctNhapHang.getSoLuong());
        values.put("donViTinh", ctNhapHang.getDonViTinh());
        values.put("idNhapHang", ctNhapHang.getIdNhapHang());
        if (isUpdate) {
            values.put("id", ctNhapHang.getId());
            database.update("CTNhapHang", values, "id = ?", new String[]{ctNhapHang.getId() + ""});
        } else {
            database.insert("CTNhapHang", null, values);
        }

    }

    public void delete(int id) {
        database.delete("CTNhapHang", "id = ?", new String[]{id + ""});
    }

    public CTNhapHang getCTNhapHang(int id) {
        Cursor cursor = database.rawQuery("select * from CTNhapHang where id=" + id, null);
        cursor.moveToFirst();
        CTNhapHang ctNhapHang = new CTNhapHang();
        ctNhapHang.setId(cursor.getInt(0));
        ctNhapHang.setId(cursor.getInt(0));
        ctNhapHang.setTenHH(cursor.getString(1));
        ctNhapHang.setLoaiHH(cursor.getString(2));
        ctNhapHang.setKichThuoc(cursor.getString(3));
        ctNhapHang.setSoLuong(cursor.getInt(4));
        ctNhapHang.setDonViTinh(cursor.getString(5));
        ctNhapHang.setIdNhapHang(cursor.getInt(6));
        return ctNhapHang;
    }
}
