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

    int maHang, maNhomHang, maNCC, soLuongTon;
    String tenHang, dVT, hinhAnh;
    double giaBan, giaNhap, heSo;

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public int getMaNhomHang() {
        return maNhomHang;
    }

    public void setMaNhomHang(int maNhomHang) {
        this.maNhomHang = maNhomHang;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
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

    public int getMaNCC() {
        return maNCC;
    }

    public double getHeSo() {
        return heSo;
    }

    public void setMaNCC(int maNCC) {
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
            this.maHang = rs.getInt("MaHang");
            this.maNhomHang = rs.getInt("MaNhomHang");
            this.maNCC = rs.getInt("MaNCC");
            this.tenHang = rs.getString("TenHang");
            this.soLuongTon = rs.getInt("SoLuongTon");
            this.dVT = rs.getString("DVT");
            this.hinhAnh = rs.getString("HinhAnh");
            this.giaBan = rs.getDouble("GiaBan");           
            this.giaBan = rs.getDouble("HeSo");
            this.giaNhap = rs.getDouble("GiaNhap");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
