/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class ThongKe {
    Date ngay;
    float doanhthu, tanggiam;
    int sodonhang;
    float soluong;
    String tenHang;

    public void setSoluong(float soluong) {
        this.soluong = soluong;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public float getSoluong() {
        return soluong;
    }

    public String getTenHang() {
        return tenHang;
    }
    public Date getNgay() {
        return ngay;
    }

    public float getDoanhthu() {
        return doanhthu;
    }

    public int getSodonhang() {
        return sodonhang;
    }

    public float getTanggiam() {
        return tanggiam;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public void setDoanhthu(float doanhthu) {
        this.doanhthu = doanhthu;
    }

    public void setSodonhang(int sodonhang) {
        this.sodonhang = sodonhang;
    }

    public void setTanggiam(float tanggiam) {
        this.tanggiam = tanggiam;
    }
    
}
