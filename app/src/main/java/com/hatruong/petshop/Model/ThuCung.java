package com.hatruong.petshop.Model;

public class ThuCung {
    private String maThuCung;
    private String maLoaiThuCung;
    private String tenThuCung;
    private double gia;
    private int soLuong;

    public ThuCung() {
    }

    public ThuCung(String maLoaiThuCung, String maThuCung, String tenThuCung, double gia, int soLuong) {
        this.maLoaiThuCung = maLoaiThuCung;
        this.maThuCung = maThuCung;
        this.tenThuCung = tenThuCung;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public String getMaLoaiThuCung() {
        return maLoaiThuCung;
    }

    public void setMaLoaiThuCung(String maLoaiThuCung) {
        this.maLoaiThuCung = maLoaiThuCung;
    }

    public String getMaThuCung() {
        return maThuCung;
    }

    public void setMaThuCung(String maThuCung) {
        this.maThuCung = maThuCung;
    }

    public String getTenThuCung() {
        return tenThuCung;
    }

    public void setTenThuCung(String tenThuCung) {
        this.tenThuCung = tenThuCung;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "ThuCung{" +
                "maLoaiThuCung='" + maLoaiThuCung + '\'' +
                ", maThuCung='" + maThuCung + '\'' +
                ", tenThuCung='" + tenThuCung + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                '}';
    }
}
