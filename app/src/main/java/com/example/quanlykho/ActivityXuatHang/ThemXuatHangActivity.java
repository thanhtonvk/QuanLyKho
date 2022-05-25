package com.example.quanlykho.ActivityXuatHang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykho.DAO.XuatHangDAO;
import com.example.quanlykho.Entity.XuatHang;
import com.example.quanlykho.R;

public class ThemXuatHangActivity extends AppCompatActivity {
    EditText edtNguoiXuat, edtNgayXuat, edtCongTy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_xuat_hang);
        edtNguoiXuat = findViewById(R.id.edtNguoiNhap);
        edtNgayXuat = findViewById(R.id.edtNgayNhap);
        edtCongTy = findViewById(R.id.edtCongTy);
        XuatHangDAO xuatHangDAO = new XuatHangDAO(getApplicationContext());
        findViewById(R.id.btnThem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuatHang xuatHang = new XuatHang();
                xuatHang.setNgayXuat(edtNgayXuat.getText().toString());
                xuatHang.setNguoiXuat(edtNguoiXuat.getText().toString());
                xuatHang.setCongTy(edtCongTy.getText().toString());
                xuatHangDAO.updateXuatHang(xuatHang, false);
                finish();
                startActivity(new Intent(getApplicationContext(), QuanLyXuatHangActivity.class));
            }
        });
    }
}