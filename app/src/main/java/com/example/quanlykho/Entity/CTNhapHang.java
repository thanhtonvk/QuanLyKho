package com.example.quanlykho.Entity;

public class CTNhapHang {
    private int id;
    private String tenHH, loaiHH;
    private float kichThuoc;
    private int soLuong;
    private String donViTinh;
    private int idNhapHang;

    public CTNhapHang() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public String getLoaiHH() {
        return loaiHH;
    }

    public void setLoaiHH(String loaiHH) {
        this.loaiHH = loaiHH;
    }

    public float getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(float kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getIdNhapHang() {
        return idNhapHang;
    }

    public void setIdNhapHang(int idNhapHang) {
        this.idNhapHang = idNhapHang;
    }

    public CTNhapHang(int id, String tenHH, String loaiHH, float kichThuoc, int soLuong, String donViTinh, int idNhapHang) {
        this.id = id;
        this.tenHH = tenHH;
        this.loaiHH = loaiHH;
        this.kichThuoc = kichThuoc;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.idNhapHang = idNhapHang;
    }

    @Override
    public String toString() {
        return String.format(" Tên hàng hóa: %s \n Loại hàng hóa: %s \n Kích thước: %s \n Số lượng còn: %s \n Đơn vị tính: %s", tenHH, loaiHH, kichThuoc, soLuong, donViTinh);
    }
}
