package com.example.quanlykho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykho.ActivityNhapHang.QuanLyNhapHangActivit;
import com.example.quanlykho.ActivityXuatHang.QuanLyXuatHangActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnNhap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), QuanLyNhapHangActivit.class));
            }
        });
        findViewById(R.id.btnXuat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), QuanLyXuatHangActivity.class));
            }
        });
    }
}