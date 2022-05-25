package com.example.quanlykho.ActivityXuatHang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykho.DAO.XuatHangDAO;
import com.example.quanlykho.Entity.Common;
import com.example.quanlykho.Entity.XuatHang;
import com.example.quanlykho.R;

import java.util.List;

public class QuanLyXuatHangActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    Button btnThem;
    ListView lvXuatHang;
    List<XuatHang> XuatHangList;
    XuatHangDAO xuatHangDAO;
    ArrayAdapter<XuatHang> XuatHangArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_xuat_hang);
        anhXaView();
        xuatHangDAO = new XuatHangDAO(getApplicationContext());
        XuatHangList = xuatHangDAO.getXuatHangs();
        XuatHangArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, XuatHangList);
        autoCompleteTextView.setAdapter(XuatHangArrayAdapter);
        lvXuatHang.setAdapter(XuatHangArrayAdapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ThemXuatHangActivity.class));
                finish();
            }
        });
        lvXuatHang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Common.xuatHang = XuatHangList.get(i);
                startActivity(new Intent(getApplicationContext(), QuanLyChiTietXuatHangActivity.class));
            }
        });
    }

    private void anhXaView() {
        autoCompleteTextView = findViewById(R.id.autoComplete);
        btnThem = findViewById(R.id.btnThem);
        lvXuatHang = findViewById(R.id.lvXuatHang);
    }
}