package com.example.quanlykho.ActivityNhapHang;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykho.DAO.NhapHangDAO;
import com.example.quanlykho.Entity.NhapHang;
import com.example.quanlykho.R;

import java.time.LocalDate;

public class ThemNhapHangActivity extends AppCompatActivity {

    EditText edtNguoiNhap, edtNgayNhap, edtCongTy;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhap_hang);
        edtNguoiNhap = findViewById(R.id.edtNguoiNhap);
        edtNgayNhap = findViewById(R.id.edtNgayNhap);
        edtCongTy = findViewById(R.id.edtCongTy);
        edtNgayNhap.setText(LocalDate.now().toString());
        NhapHangDAO nhapHangDAO = new NhapHangDAO(getApplicationContext());
        findViewById(R.id.btnThem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhapHang nhapHang = new NhapHang();
                nhapHang.setNgayNhap(edtNgayNhap.getText().toString());
                nhapHang.setNguoiNhap(edtNguoiNhap.getText().toString());
                nhapHang.setCongTy(edtCongTy.getText().toString());
                nhapHangDAO.updateNhapHang(nhapHang, false);
                finish();
                startActivity(new Intent(getApplicationContext(), QuanLyNhapHangActivit.class));
            }
        });
    }
}