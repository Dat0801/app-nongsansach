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
 * @author Admin
 */
public class HoaDon {

    Date ngayTao;
    float tongTien;
    String maHD, maNV, maKH, trangThai;

    public Date getNgayTao() {
        return ngayTao;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public HoaDon(ResultSet rs) {
        try {
            this.maHD = rs.getString("maHD");
            this.maNV = rs.getString("MaNV");
            this.maKH = rs.getString("maKH");
            this.ngayTao = rs.getDate("ngayTao");
            this.tongTien = rs.getFloat("TongTien");
            this.trangThai = rs.getString("TrangThai");
        } catch (SQLException e) {
            
        }
    }

    public HoaDon() {
        
    }
    
    public HoaDon(String maHD, String maNV, String maKH, float tongTien) {
        this.tongTien = tongTien;
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
    }
    
}
