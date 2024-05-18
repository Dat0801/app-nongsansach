/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class KhachHangDAO {
    private static KhachHangDAO instance;

    public static KhachHangDAO getInstance() {
        if (instance == null) {
            instance = new KhachHangDAO();
        }
        return instance;
    }

    private KhachHangDAO() {

    }

    public ArrayList<KhachHang> getListKhachHang(int trangthai) {
        ArrayList<KhachHang> listKH = new ArrayList<>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getListKhachHang", trangthai);
            while (rs.next()) {
                KhachHang khachhang = new KhachHang(rs);
                listKH.add(khachhang);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return listKH;
    }
    
    public KhachHang getKhachHang(String maKH) {
        ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getKhachHang", maKH);
        KhachHang khachhang = null;
        try {
            while (rs.next()) {
                khachhang = new KhachHang(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return khachhang;
    }
    
    public KhachHang getKhachHangTheoSDT(String sdt) {
        ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getKhachHangTheoSDT", sdt);
        KhachHang khachhang = null;
        try {
            while (rs.next()) {
                khachhang = new KhachHang(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return khachhang;
    }
    
    public KhachHang getLastKhachHang() {

        ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getLastKhachHang");
        KhachHang khachhang = null;
        try {
            while (rs.next()) {
                khachhang = new KhachHang(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return khachhang;
    }
    
    public int updateKhachHang(KhachHang ncc) {
        int rs = DataProvider.getInstance().executeNonQuery("call sp_updateKH", ncc.getMaKH(), ncc.getTenKH(), 
        ncc.getSDT(), ncc.getDiaChi());
        return rs;
    }
    
    public int insertKhachHang(KhachHang ncc) {
        int rs = DataProvider.getInstance().executeNonQuery("call sp_insertKH", ncc.getMaKH(), ncc.getTenKH(),
        ncc.getSDT(), ncc.getDiaChi());
        return rs;
    }
    
    public int deleteKhachHang(String maKhachHang) {
        int rs = DataProvider.getInstance().executeNonQuery("call sp_deleteKhachHang", maKhachHang);
        return rs;
    }
    
    public int recoveryKhachHang(String maKH) {
        int rs = DataProvider.getInstance().executeNonQuery("call sp_recoverKhachHang", maKH);
        return rs;
    }
}
