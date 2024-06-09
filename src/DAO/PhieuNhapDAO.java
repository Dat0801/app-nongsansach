/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Quang
 */
import DTO.PhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhieuNhapDAO {
    private static PhieuNhapDAO instance;

    public static PhieuNhapDAO getInstance() {
        if (instance == null) {
            instance = new PhieuNhapDAO();
        }
        return instance;
    }

    private PhieuNhapDAO() {

    }

    public ArrayList<PhieuNhap> getListPhieuNhap() {
        ArrayList<PhieuNhap> listPN = new ArrayList<PhieuNhap>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getListPN");
            while (rs.next()) {
                PhieuNhap phieunhap = new PhieuNhap(rs);
                listPN.add(phieunhap);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listPN;
    }
    
    public PhieuNhap getPhieuNhap(String maPN) {
        ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getListPNByMaPN", maPN);
        PhieuNhap phieunhap = null;
        try {
            while (rs.next()) {
                phieunhap = new PhieuNhap(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return phieunhap;
    }
    public PhieuNhap getLastPhieuNhap() {

        ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getLastPhieuNhap");
        PhieuNhap pn = null;
        try {
            while (rs.next()) {
                pn = new PhieuNhap(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return pn;
    }
    public int insertPhieuNhap(PhieuNhap phieunhap) {
        int rs = DataProvider.getInstance().executeNonQuery("call sp_insertPN", phieunhap.getMaPN(), phieunhap.getMaNV(), phieunhap.getMaNCC(), phieunhap.getTongTien());
        return rs;
    }
}
