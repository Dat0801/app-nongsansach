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
 * @author Quang
 */
public class ChiTietPhieuNhap {
    String MaPN, MaHang, TenHang, DVT;
    double GiaNhap, SoLuong, ThanhTien, SoLuongTon, DonGia;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(HangHoa hangHoa) {
        this.MaHang = hangHoa.getMaHang();
        this.TenHang = hangHoa.getTenHang();
        this.DVT = hangHoa.getdVT();
        this.SoLuong = 1;
        this.SoLuongTon = hangHoa.getSoLuongTon();
        this.DonGia = hangHoa.getGiaBan();
        this.ThanhTien = 1 * hangHoa.getGiaBan();
    }
    
    public ChiTietPhieuNhap(ResultSet rs) throws SQLException {
        this.MaHang = rs.getString("MaHang");
        this.MaPN = rs.getString("MaPN");
        this.TenHang = rs.getString("TenHang");
        this.SoLuong = rs.getDouble("SoLuong");        
        this.SoLuongTon = rs.getDouble("SoLuongTon");
        this.DVT = rs.getString("DVT");
        this.GiaNhap = rs.getDouble("GiaNhap"); 
        this.DonGia = rs.getDouble("GiaBan");               
        this.ThanhTien = rs.getDouble("ThanhTien");
    }
    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public void setSoLuong(double SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public void setSoLuongTon(double SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public String getMaPN() {
        return MaPN;
    }

    public String getMaHang() {
        return MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public String getDVT() {
        return DVT;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public double getSoLuong() {
        return SoLuong;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public double getSoLuongTon() {
        return SoLuongTon;
    }

    public double getDonGia() {
        return DonGia;
    }
}
