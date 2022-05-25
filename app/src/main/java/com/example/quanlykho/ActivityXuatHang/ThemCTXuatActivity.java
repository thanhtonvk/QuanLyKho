package com.example.quanlykho.ActivityXuatHang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlykho.DAO.CTXuatHangDAO;
import com.example.quanlykho.Entity.CTNhapHang;
import com.example.quanlykho.Entity.CTXuatHang;
import com.example.quanlykho.Entity.Common;
import com.example.quanlykho.R;

import java.util.List;

public class ThemCTXuatActivity extends AppCompatActivity {

    EditText edtTenHH, edtSoLuong;
    Button btnThem, btnThoat;
    ListView lvHangHoa;
    List<CTNhapHang> ctNhapHangList;
    ArrayAdapter<CTNhapHang> adapter;
    CTXuatHangDAO ctXuatHangDAO;
    CTNhapHang ctNhapHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_ctxuat);
        anhXaView();
        ctXuatHangDAO = new CTXuatHangDAO(getApplicationContext());
        ctNhapHangList = ctXuatHangDAO.getAllCTNhapHang();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ctNhapHangList);
        lvHangHoa.setAdapter(adapter);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), QuanLyChiTietXuatHangActivity.class));
            }
        });
        lvHangHoa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ctNhapHang = ctNhapHangList.get(i);
                edtTenHH.setText(ctNhapHang.getTenHH());
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTXuatHang ctXuatHang = new CTXuatHang();
                ctXuatHang.setIdXuatHang(Common.xuatHang.getId());
                ctXuatHang.setIdCTNhapHang(ctNhapHang.getId());
                ctXuatHang.setSoLuong(Integer.parseInt(edtSoLuong.getText().toString()));
                if(ctXuatHangDAO.addXuatHang(ctXuatHang)>0){
                    Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Số lượng không đủ",Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    private void anhXaView() {
        edtTenHH = findViewById(R.id.edtTenHH);
        edtSoLuong = findViewById(R.id.edtSoLuong);
        btnThem = findViewById(R.id.btnThem);
        btnThoat = findViewById(R.id.btnThoat);
        lvHangHoa = findViewById(R.id.lvHangHoa);
    }
}