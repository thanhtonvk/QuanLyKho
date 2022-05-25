package com.example.quanlykho.Entity;

public class CTXuatHang {
    private int id, idXuatHang, idCTNhapHang, soLuong;
    private String tenHH, loaiHH;
    private float kichThuoc;
    private String donViTinh;

    public CTXuatHang() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdXuatHang() {
        return idXuatHang;
    }

    public void setIdXuatHang(int idXuatHang) {
        this.idXuatHang = idXuatHang;
    }

    public int getIdCTNhapHang() {
        return idCTNhapHang;
    }

    public void setIdCTNhapHang(int idCTNhapHang) {
        this.idCTNhapHang = idCTNhapHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public CTXuatHang(int id, int idXuatHang, int idCTNhapHang, int soLuong, String tenHH, String loaiHH, float kichThuoc, String donViTinh) {
        this.id = id;
        this.idXuatHang = idXuatHang;
        this.idCTNhapHang = idCTNhapHang;
        this.soLuong = soLuong;
        this.tenHH = tenHH;
        this.loaiHH = loaiHH;
        this.kichThuoc = kichThuoc;
        this.donViTinh = donViTinh;
    }

    @Override
    public String toString() {
        return String.format(" Tên hàng hóa: %s \n Loại hàng hóa: %s \n Kích thước: %s \n Số lượng xuất: %s \n Đơn vị tính: %s", tenHH, loaiHH, kichThuoc, soLuong, donViTinh);
    }
}
