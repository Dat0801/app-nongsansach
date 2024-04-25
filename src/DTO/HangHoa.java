/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class HangHoa {

    boolean trangThai;
    String maHang, maNhomHang, maNCC, tenHang, dVT, hinhAnh;
    double giaBan, giaNhap, heSo, soLuongTon;

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getMaNhomHang() {
        return maNhomHang;
    }

    public void setMaNhomHang(String maNhomHang) {
        this.maNhomHang = maNhomHang;
    }

    public double getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(double soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getdVT() {
        return dVT;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public void setdVT(String dVT) {
        this.dVT = dVT;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public double getHeSo() {
        return heSo;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setHeSo(double heSo) {
        this.heSo = heSo;
    }

    public HangHoa() {

    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public HangHoa(ResultSet rs) {
        try {
            this.maHang = rs.getString("MaHang");
            this.maNhomHang = rs.getString("MaNhomHang");
            this.maNCC = rs.getString("MaNCC");
            this.tenHang = rs.getString("TenHang");
            this.soLuongTon = rs.getDouble("SoLuongTon");
            this.dVT = rs.getString("DVT");
            this.hinhAnh = rs.getString("HinhAnh");
            this.giaBan = rs.getDouble("GiaBan");
            this.heSo = rs.getDouble("HeSo");
            this.giaNhap = rs.getDouble("GiaNhap");
            this.trangThai = rs.getBoolean("TrangThai");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
