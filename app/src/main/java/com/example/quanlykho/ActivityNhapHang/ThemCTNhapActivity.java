package com.example.quanlykho.ActivityNhapHang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykho.DAO.CTNhapHangDAO;
import com.example.quanlykho.Entity.CTNhapHang;
import com.example.quanlykho.Entity.Common;
import com.example.quanlykho.R;

public class ThemCTNhapActivity extends AppCompatActivity {
    EditText edtTenHH, edtLoaiHH, edtKichThuoc, edtSoLuong, edtDonViTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_ctnhap);
        edtTenHH = findViewById(R.id.edtTenHH);
        edtLoaiHH = findViewById(R.id.edtLoaiHH);
        edtKichThuoc = findViewById(R.id.edtKichThuoc);
        edtSoLuong = findViewById(R.id.edtSoLuong);
        edtDonViTinh = findViewById(R.id.edtDonViTinh);
        CTNhapHangDAO ctNhapHangDAO = new CTNhapHangDAO(getApplicationContext());
        findViewById(R.id.btnThem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTNhapHang ctNhapHang = new CTNhapHang();
                ctNhapHang.setIdNhapHang(Common.nhapHang.getId());
                ctNhapHang.setSoLuong(Integer.parseInt(edtSoLuong.getText().toString()));
                ctNhapHang.setDonViTinh(edtDonViTinh.getText().toString());
                ctNhapHang.setLoaiHH(edtLoaiHH.getText().toString());
                ctNhapHang.setKichThuoc(Float.parseFloat(edtKichThuoc.getText().toString()));
                ctNhapHang.setTenHH(edtTenHH.getText().toString());
                ctNhapHangDAO.insert(ctNhapHang);
                finish();
                startActivity(new Intent(getApplicationContext(), QuanLyChiTietNhapHangActivity.class));
            }
        });
    }
}