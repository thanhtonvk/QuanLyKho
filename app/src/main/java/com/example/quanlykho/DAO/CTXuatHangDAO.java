package com.example.quanlykho.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quanlykho.Database.DBHelper;
import com.example.quanlykho.Entity.CTNhapHang;
import com.example.quanlykho.Entity.CTXuatHang;

import java.util.ArrayList;
import java.util.List;

public class CTXuatHangDAO {
    public DBHelper dbHelper;
    public Context context;
    SQLiteDatabase database;

    public CTXuatHangDAO(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    private Cursor getCursor(int idXuatHang) {
        String query = "select CTXuatHang.id,XuatHang.id,CTXuatHang.soLuong,CTNhapHang.tenHH,CTNhapHang.loaiHH,CTNhapHang.kichThuoc,CTNhapHang.donViTinh from XuatHang,CTXuatHang,CTNhapHang where XuatHang.id = CTXuatHang.idXuatHang and CTXuatHang.idCTNhapHang = CTNhapHang.id and XuatHang.id = " + idXuatHang;
        Cursor cursor = database.rawQuery(query, null);
        return cursor;
    }

    public List<CTNhapHang> getAllCTNhapHang() {
        Cursor cursor = database.rawQuery("select * from CTNhapHang", null);
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

    public List<CTXuatHang> getCTXuatHangs(int idXuatHang) {
        Cursor cursor = getCursor(idXuatHang);
        List<CTXuatHang> ctXuatHangList = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CTXuatHang ctXuatHang = new CTXuatHang();
            ctXuatHang.setId(cursor.getInt(0));
            ctXuatHang.setIdXuatHang(cursor.getInt(1));
            ctXuatHang.setSoLuong(cursor.getInt(2));
            ctXuatHang.setTenHH(cursor.getString(3));
            ctXuatHang.setLoaiHH(cursor.getString(4));
            ctXuatHang.setKichThuoc(cursor.getFloat(5));
            ctXuatHang.setDonViTinh(cursor.getString(6));
            cursor.moveToNext();
            ctXuatHangList.add(ctXuatHang);
        }
        return ctXuatHangList;
    }

    public int addXuatHang(CTXuatHang ctXuatHang) {
        ContentValues values = new ContentValues();
        values.put("idXuatHang", ctXuatHang.getIdXuatHang());
        values.put("idCTNhapHang", ctXuatHang.getIdCTNhapHang());
        values.put("soLuong", ctXuatHang.getSoLuong());
        CTNhapHangDAO nhapHangDAO = new CTNhapHangDAO(context);
        CTNhapHang ctNhapHang = nhapHangDAO.getCTNhapHang(ctXuatHang.getIdCTNhapHang());

        if (ctXuatHang.getSoLuong() > ctNhapHang.getSoLuong()) {
            return -1;
        } else {
            database.insert("CTXuatHang", null, values);
            ctNhapHang.setSoLuong(ctNhapHang.getSoLuong() - ctXuatHang.getSoLuong());
            ContentValues valueCTNhapHang = new ContentValues();
            valueCTNhapHang.put("id", ctNhapHang.getId());
            valueCTNhapHang.put("tenHH", ctNhapHang.getTenHH());
            valueCTNhapHang.put("loaiHH", ctNhapHang.getLoaiHH());
            valueCTNhapHang.put("kichThuoc", ctNhapHang.getKichThuoc());
            valueCTNhapHang.put("soLuong", ctNhapHang.getSoLuong());
            valueCTNhapHang.put("donViTinh", ctNhapHang.getDonViTinh());
            valueCTNhapHang.put("idNhapHang", ctNhapHang.getIdNhapHang());
            return database.update("CTNhapHang", valueCTNhapHang, "id = ?", new String[]{ctNhapHang.getId() + ""});
        }
    }

}
