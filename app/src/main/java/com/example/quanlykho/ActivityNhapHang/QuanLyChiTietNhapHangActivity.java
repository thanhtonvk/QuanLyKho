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

import com.example.quanlykho.ActivityXuatHang.ThemCTXuatActivity;
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
    int index;

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
        lvNhapHang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                setDialog();
            }
        });
    }

    private void setDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Tùy chọn");
        builder.setPositiveButton("Sửa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Common.ctNhapHang = nhapHangList.get(index);
                Common.isUpdate = true;
                startActivity(new Intent(getApplicationContext(), ThemCTNhapActivity.class));
                finish();
            }
        });
        builder.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Common.ctNhapHang = nhapHangList.get(index);
                ctNhapHangDAO.delete(Common.ctNhapHang.getId());
                nhapHangList = ctNhapHangDAO.getCTNhapHangs(Common.nhapHang.getId());
                nhapHangArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, nhapHangList);
                autoCompleteTextView.setAdapter(nhapHangArrayAdapter);
                lvNhapHang.setAdapter(nhapHangArrayAdapter);
            }
        });
        builder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }


    private void anhXaView() {

        autoCompleteTextView = findViewById(R.id.autoComplete);
        btnThem = findViewById(R.id.btnNhap);
        lvNhapHang = findViewById(R.id.lvNhapHang);
    }
}