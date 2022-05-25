package com.example.quanlykho.Entity;

public class NhapHang {
    private int id;
    private String nguoiNhap, ngayNhap, congTy;

    public NhapHang() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getCongTy() {
        return congTy;
    }

    public void setCongTy(String congTy) {
        this.congTy = congTy;
    }

    public NhapHang(int id, String nguoiNhap, String ngayNhap, String congTy) {
        this.id = id;
        this.nguoiNhap = nguoiNhap;
        this.ngayNhap = ngayNhap;
        this.congTy = congTy;
    }

    @Override
    public String toString() {
        return String.format(" Người nhập hàng: %s\n Ngày nhập hàng: %s \n Công ty: %s", nguoiNhap, ngayNhap, congTy);
    }
}
