package com.example.quanlykho.ActivityNhapHang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykho.DAO.CTNhapHangDAO;
import com.example.quanlykho.Entity.CTNhapHang;
import com.example.quanlykho.Entity.Common;
import com.example.quanlykho.R;

import java.util.List;

public class QuanLyChiTietNhapHangActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    Button btnThem;
    ListView lvNhapHang;
    List<CTNhapHang> nhapHangList;
    CTNhapHangDAO ctNhapHangDAO;
    ArrayAdapter<CTNhapHang> nhapHangArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_chi_tiet_nhap_hang);
        anhXaView();
        ctNhapHangDAO = new CTNhapHangDAO(getApplicationContext());
        nhapHangList = ctNhapHangDAO.getCTNhapHangs(Common.nhapHang.getId());
        nhapHangArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nhapHangList);
        autoCompleteTextView.setAdapter(nhapHangArrayAdapter);
        lvNhapHang.setAdapter(nhapHangArrayAdapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ThemCTNhapActivity.class));
                finish();
            }
        });
    }

    private void anhXaView() {

        autoCompleteTextView = findViewById(R.id.autoComplete);
        btnThem = findViewById(R.id.btnNhap);
        lvNhapHang = findViewById(R.id.lvNhapHang);
    }
}