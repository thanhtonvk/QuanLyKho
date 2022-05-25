package com.example.quanlykho.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlykho.Database.DBHelper;
import com.example.quanlykho.Entity.NhapHang;

import java.util.ArrayList;
import java.util.List;

public class NhapHangDAO {
    public DBHelper dbHelper;
    public Context context;
    SQLiteDatabase database;

    public NhapHangDAO(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    private Cursor getCursor() {
        Cursor cursor = database.rawQuery("select * from NhapHang", null);
        return cursor;
    }

    public List<NhapHang> getNhapHangs() {
        Cursor cursor = getCursor();
        cursor.moveToFirst();
        List<NhapHang> nhapHangList = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            NhapHang nhapHang = new NhapHang();
            nhapHang.setId(cursor.getInt(0));
            nhapHang.setNguoiNhap(cursor.getString(1));
            nhapHang.setNgayNhap(cursor.getString(2));
            nhapHang.setCongTy(cursor.getString(3));
            nhapHangList.add(nhapHang);
            cursor.moveToNext();
        }
        return nhapHangList;
    }

    public int updateNhapHang(NhapHang nhapHang, boolean isUpdate) {
        ContentValues values = new ContentValues();
        values.put("nguoiNhap", nhapHang.getNguoiNhap());
        values.put("ngayNhap", nhapHang.getNgayNhap());
        values.put("congTy", nhapHang.getCongTy());
        int rs = -1;
        if (isUpdate) {
            rs = database.update("NhapHang", values, "id = ?", new String[]{nhapHang.getId() + ""});
        } else {
            rs = (int) database.insert("NhapHang", null, values);
        }
        return rs;
    }

    public int deleteNhapHang(int id) {
        int rs = database.delete("NhapHang", "id = ?", new String[]{id + ""});
        return rs;
    }

}
