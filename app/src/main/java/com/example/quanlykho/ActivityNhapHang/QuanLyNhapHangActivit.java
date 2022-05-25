package com.example.quanlykho.ActivityNhapHang;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykho.DAO.NhapHangDAO;
import com.example.quanlykho.Entity.Common;
import com.example.quanlykho.Entity.NhapHang;
import com.example.quanlykho.R;

import java.util.List;

public class QuanLyNhapHangActivit extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    Button btnThem;
    ListView lvNhapHang;
    List<NhapHang> nhapHangList;
    NhapHangDAO nhapHangDAO;
    ArrayAdapter<NhapHang> nhapHangArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_nhap_hang);
        nhapHangDAO = new NhapHangDAO(getApplicationContext());
        anhXaView();
        nhapHangList = nhapHangDAO.getNhapHangs();
        nhapHangArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nhapHangList);
        lvNhapHang.setAdapter(nhapHangArrayAdapter);
        autoCompleteTextView.setAdapter(nhapHangArrayAdapter);
        lvNhapHang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Common.nhapHang = nhapHangList.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(QuanLyNhapHangActivit.this);
                builder.setTitle("Tùy chọn");
                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        nhapHangDAO.deleteNhapHang(Common.nhapHang.getId());
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton("Thêm chi tiết nhập hàng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), QuanLyChiTietNhapHangActivity.class));
                    }
                });
                builder.show();

            }
        });
        findViewById(R.id.btnNhapHang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ThemNhapHangActivity.class));
                finish();
            }
        });
    }

    private void anhXaView() {
        autoCompleteTextView = findViewById(R.id.autoComplete);
        btnThem = findViewById(R.id.btnNhapHang);
        lvNhapHang = findViewById(R.id.lvNhapHang);
    }
}