/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class SessionData {
    private static NhanVien nv;
    private static KhachHang kh;

    public static void setKh(KhachHang kh) {
        SessionData.kh = kh;
    }

    public static KhachHang getKh() {
        return kh;
    }

    public static NhanVien getNv() {
        return nv;
    }

    public static void setNv(NhanVien nv) {
        SessionData.nv = nv;
    }

    public SessionData(NhanVien nv) {
        this.nv = nv;
    }
    
    

}
