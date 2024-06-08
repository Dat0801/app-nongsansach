/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDon {

    String MaHang, MaHD, TenHang, DVT, HinhAnh;
    double SoLuong, SoLuongTon, DonGia, ThanhTien;

    public void setSoLuongTon(double SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public double getSoLuongTon() {
        return SoLuongTon;
    }

    public String getMaHang() {
        return MaHang;
    }

    public String getMaHD() {
        return MaHD;
    }

    public double getSoLuong() {
        return SoLuong;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public String getDVT() {
        return DVT;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public ChiTietHoaDon(HangHoa hangHoa, int soLuong) {
        this.MaHang = hangHoa.getMaHang();
        this.TenHang = hangHoa.getTenHang();
        this.HinhAnh = hangHoa.getHinhAnh();
        this.DVT = hangHoa.getdVT();
        this.SoLuong = soLuong;
        this.SoLuongTon = hangHoa.getSoLuongTon();
        this.DonGia = hangHoa.getGiaBan();
        this.ThanhTien = 1 * hangHoa.getGiaBan();
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public void setSoLuong(double SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public String getTenHang() {
        return TenHang;
    }

    public double getDonGia() {
        return DonGia;
    }

    public ChiTietHoaDon(ResultSet rs) throws SQLException {
        this.MaHang = rs.getString("MaHang");
        this.MaHD = rs.getString("MaHD");
        this.HinhAnh = rs.getString("HinhAnh");
        this.TenHang = rs.getString("TenHang");
        this.SoLuong = rs.getDouble("SoLuong");        
        this.SoLuongTon = rs.getDouble("SoLuongTon");
        this.DVT = rs.getString("DVT");
        this.DonGia = rs.getDouble("GiaBan");
        this.ThanhTien = rs.getDouble("ThanhTien");
    }
    
    public ChiTietHoaDon() {
        
    }
    
}
