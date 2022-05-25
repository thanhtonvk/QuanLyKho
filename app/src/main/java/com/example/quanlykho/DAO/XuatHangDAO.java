package com.example.quanlykho.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlykho.Database.DBHelper;
import com.example.quanlykho.Entity.XuatHang;

import java.util.ArrayList;
import java.util.List;

public class XuatHangDAO {
    public DBHelper dbHelper;
    public Context context;
    SQLiteDatabase database;

    public XuatHangDAO(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    private Cursor getCursor() {
        Cursor cursor = database.rawQuery("select * from XuatHang", null);
        return cursor;
    }

    public List<XuatHang> getXuatHangs() {
        Cursor cursor = getCursor();
        cursor.moveToFirst();
        List<XuatHang> XuatHangList = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            XuatHang XuatHang = new XuatHang();
            XuatHang.setId(cursor.getInt(0));
            XuatHang.setNguoiXuat(cursor.getString(1));
            XuatHang.setNgayXuat(cursor.getString(2));
            XuatHang.setCongTy(cursor.getString(3));
            XuatHangList.add(XuatHang);
            cursor.moveToNext();
        }
        return XuatHangList;
    }

    public int updateXuatHang(XuatHang XuatHang, boolean isUpdate) {
        ContentValues values = new ContentValues();
        values.put("nguoiXuat", XuatHang.getNguoiXuat());
        values.put("ngayXuat", XuatHang.getNgayXuat());
        values.put("congTy", XuatHang.getCongTy());
        int rs = -1;
        if (isUpdate) {
            rs = database.update("XuatHang", values, "id = ?", new String[]{XuatHang.getId() + ""});
        } else {
            rs = (int) database.insert("XuatHang", null, values);
        }
        return rs;
    }

    public int deleteXuatHang(int id) {
        int rs = database.delete("XuatHang", "id = ?", new String[]{id + ""});
        return rs;
    }
}
