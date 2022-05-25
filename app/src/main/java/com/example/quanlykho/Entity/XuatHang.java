package com.example.quanlykho.Entity;

public class XuatHang {
    private int id;
    private String nguoiXuat, ngayXuat, congTy;

    public XuatHang() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNguoiXuat() {
        return nguoiXuat;
    }

    public void setNguoiXuat(String nguoiXuat) {
        this.nguoiXuat = nguoiXuat;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getCongTy() {
        return congTy;
    }

    public void setCongTy(String congTy) {
        this.congTy = congTy;
    }

    public XuatHang(int id, String nguoiXuat, String ngayXuat, String congTy) {
        this.id = id;
        this.nguoiXuat = nguoiXuat;
        this.ngayXuat = ngayXuat;
        this.congTy = congTy;
    }

    @Override
    public String toString() {
        return String.format(" Người xuất hàng: %s\n Ngày xuất hàng: %s \n Công ty: %s", nguoiXuat, ngayXuat, congTy);
    }
}
