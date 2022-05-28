package com.example.quanlykho.ActivityXuatHang;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykho.DAO.CTXuatHangDAO;
import com.example.quanlykho.Entity.CTXuatHang;
import com.example.quanlykho.Entity.Common;
import com.example.quanlykho.R;

import java.util.List;

public class QuanLyChiTietXuatHangActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    Button btnThem;
    ListView lvXuatHang;
    List<CTXuatHang> xuatHangList;
    CTXuatHangDAO ctXuatHangDAO;
    ArrayAdapter<CTXuatHang> xuatHangArrayAdapter;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_chi_tiet_xuat_hang);
        anhXaView();
        ctXuatHangDAO = new CTXuatHangDAO(getApplicationContext());
        xuatHangList = ctXuatHangDAO.getCTXuatHangs(Common.xuatHang.getId());
        xuatHangArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, xuatHangList);
        autoCompleteTextView.setAdapter(xuatHangArrayAdapter);
        lvXuatHang.setAdapter(xuatHangArrayAdapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ThemCTXuatActivity.class));
                finish();
            }
        });
        lvXuatHang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                Log.e("TAG", i + "");
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
                Common.ctXuatHang = xuatHangList.get(index);
                Common.isUpdate = true;
                startActivity(new Intent(getApplicationContext(), ThemCTXuatActivity.class));
                finish();
            }
        });
        builder.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Common.ctXuatHang = xuatHangList.get(index);
                ctXuatHangDAO.delete(Common.ctXuatHang.getId());
                xuatHangList = ctXuatHangDAO.getCTXuatHangs(Common.xuatHang.getId());
                xuatHangArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, xuatHangList);
                autoCompleteTextView.setAdapter(xuatHangArrayAdapter);
                lvXuatHang.setAdapter(xuatHangArrayAdapter);
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
        btnThem = findViewById(R.id.btnThem);
        lvXuatHang = findViewById(R.id.lvXuatHang);
    }
}