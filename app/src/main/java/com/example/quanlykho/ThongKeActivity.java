package com.example.quanlykho;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.example.quanlykho.DAO.CTNhapHangDAO;
import com.example.quanlykho.DAO.CTXuatHangDAO;
import com.example.quanlykho.Entity.CTNhapHang;
import com.example.quanlykho.Entity.CTXuatHang;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ThongKeActivity extends AppCompatActivity {

    LineChart lineChart_nhap, lineChart_xuat;
    LineData data_nhap, data_xuat;
    LineDataSet lineDataSet_nhap, lineDataSet_xuat;
    ArrayList lineList_nhap, lineList_xuat;
    CTNhapHangDAO nhapHangDAO;
    CTXuatHangDAO xuatHangDAO;
    List<CTNhapHang> ctNhapHangList;
    List<CTXuatHang> ctXuatHangList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        init();
        nhapHangDAO = new CTNhapHangDAO(this);
        xuatHangDAO = new CTXuatHangDAO(this);
        ctNhapHangList = nhapHangDAO.getAllCTNhapHang();
        Log.e("COUNT",ctNhapHangList.size()+" ");
        ctXuatHangList = xuatHangDAO.getAllXuatHang();
        loadEntries();
        lineDataSet_nhap = new LineDataSet(lineList_nhap, "Nhập hàng");
        data_nhap = new LineData(lineDataSet_nhap);
        lineChart_nhap.setData(data_nhap);
        lineDataSet_nhap.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet_nhap.setValueTextColor(Color.BLUE);
        lineDataSet_nhap.setValueTextSize(18f);


        lineDataSet_xuat = new LineDataSet(lineList_xuat, "Xuất hàng");
        data_xuat = new LineData(lineDataSet_xuat);
        lineChart_xuat.setData(data_xuat);
        lineDataSet_xuat.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet_xuat.setValueTextColor(Color.RED);
        lineDataSet_xuat.setValueTextSize(18f);
    }

    private void init() {
        lineChart_nhap = findViewById(R.id.char_nhap);
        lineChart_xuat = findViewById(R.id.char_xuat);
    }

    private void loadEntries() {
        lineList_nhap = new ArrayList();
        int i = 0;


        for (CTNhapHang ctNhapHang : ctNhapHangList) {
            lineList_nhap.add(new Entry(i,ctNhapHang.getSoLuong()));
            i++;
        }
        int j = 0;
        lineList_xuat = new ArrayList();
        for (CTXuatHang ctXuatHang : ctXuatHangList) {
            lineList_xuat.add(new Entry(j,ctXuatHang.getSoLuong()));
            j++;
        }

    }
}