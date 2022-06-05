package com.example.quanlykho.ActivityXuatHang;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykho.DAO.XuatHangDAO;
import com.example.quanlykho.Entity.XuatHang;
import com.example.quanlykho.R;

import java.time.LocalDate;

public class ThemXuatHangActivity extends AppCompatActivity {
    EditText edtNguoiXuat, edtNgayXuat, edtCongTy;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_xuat_hang);
        edtNguoiXuat = findViewById(R.id.edtNguoiNhap);
        edtNgayXuat = findViewById(R.id.edtNgayNhap);
        edtCongTy = findViewById(R.id.edtCongTy);
        edtNgayXuat.setText(LocalDate.now().toString());
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