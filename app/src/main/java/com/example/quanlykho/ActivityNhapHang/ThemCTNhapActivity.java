package com.example.quanlykho.ActivityNhapHang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykho.DAO.CTNhapHangDAO;
import com.example.quanlykho.Entity.CTNhapHang;
import com.example.quanlykho.Entity.Common;
import com.example.quanlykho.R;

public class ThemCTNhapActivity extends AppCompatActivity {
    EditText edtTenHH, edtLoaiHH, edtKichThuoc, edtSoLuong, edtDonViTinh;
    Button btnThem;

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
        loadDuLieu();
        btnThem = findViewById(R.id.btnThem);
        if (Common.isUpdate) {
            btnThem.setText("Sửa");
        }
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTNhapHang ctNhapHang = new CTNhapHang();
                ctNhapHang.setIdNhapHang(Common.nhapHang.getId());
                ctNhapHang.setSoLuong(Integer.parseInt(edtSoLuong.getText().toString()));
                ctNhapHang.setDonViTinh(edtDonViTinh.getText().toString());
                ctNhapHang.setLoaiHH(edtLoaiHH.getText().toString());
                ctNhapHang.setKichThuoc(edtKichThuoc.getText().toString());
                ctNhapHang.setTenHH(edtTenHH.getText().toString());
                ctNhapHangDAO.insert(ctNhapHang, Common.isUpdate);
                Common.isUpdate = false;
                finish();
                startActivity(new Intent(getApplicationContext(), QuanLyChiTietNhapHangActivity.class));
            }
        });
    }

    private void loadDuLieu() {
        if (Common.isUpdate) {
            if(Common.ctNhapHang!=null){
                edtTenHH.setText(Common.ctNhapHang.getTenHH());
                edtLoaiHH.setText(Common.ctNhapHang.getLoaiHH());
                edtKichThuoc.setText(Common.ctNhapHang.getKichThuoc() + "");
                edtSoLuong.setText(Common.ctNhapHang.getSoLuong() + "");
                edtDonViTinh.setText(Common.ctNhapHang.getDonViTinh());
            }

        }
    }
}