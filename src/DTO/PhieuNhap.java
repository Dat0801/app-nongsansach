/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Quang
 */
public class PhieuNhap {
    Date ngayNhap;
    float tongTien;
    String maPN, maNV, maNCC, trangThai;
    
    public PhieuNhap(ResultSet rs) {
        try {
            this.maPN = rs.getString("MaPN");
            this.maNV = rs.getString("MaNV");
            this.maNCC = rs.getString("MaNCC");
            this.ngayNhap = rs.getDate("NgayNhap");
            this.tongTien = rs.getFloat("TongTien");
            this.trangThai = rs.getString("TrangThai");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public PhieuNhap() {
    }

    public PhieuNhap(String maPN, String maNV, String maNCC, Date ngayNhap, float tongTien, String trangThai) {
        this.maPN = maPN;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getMaPN() {
        return maPN;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public PhieuNhap(String maPN, String maNV, String maNCC, float tongTien) {
        this.tongTien = tongTien;
        this.maPN = maPN;
        this.maNV = maNV;
        this.maNCC = maNCC;
    }
}
