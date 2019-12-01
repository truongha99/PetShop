package com.hatruong.petshop.Model;

public class LoaiThuCung {
    private String maLoaiThuCung;
    private String tenLoaiThuCung;
    private String moTa;

    public LoaiThuCung() {
    }

    public LoaiThuCung(String maLoaiThuCung, String tenLoaiThuCung, String moTa) {
        this.maLoaiThuCung = maLoaiThuCung;
        this.tenLoaiThuCung = tenLoaiThuCung;
        this.moTa = moTa;
    }

    public String getMaLoaiThuCung() {
        return maLoaiThuCung;
    }

    public void setMaLoaiThuCung(String maLoaiThuCung) {
        this.maLoaiThuCung = maLoaiThuCung;
    }

    public String getTenLoaiThuCung() {
        return tenLoaiThuCung;
    }

    public void setTenLoaiThuCung(String tenLoaiThuCung) {
        this.tenLoaiThuCung = tenLoaiThuCung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return getMaLoaiThuCung() + " | " + getTenLoaiThuCung();
    }
}
