/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonDAO {
    private static HoaDonDAO instance;

    public static HoaDonDAO getInstance() {
        if (instance == null) {
            instance = new HoaDonDAO();
        }
        return instance;
    }

    private HoaDonDAO() {

    }

    public ArrayList<HoaDon> getListHoaDon() {
        ArrayList<HoaDon> listPN = new ArrayList<HoaDon>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("Select * from HoaDon");
            while (rs.next()) {
                HoaDon hoadon = new HoaDon(rs);
                listPN.add(hoadon);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listPN;
    }
    
    public HoaDon getHoaDon(String maHD) {
        ResultSet rs = DataProvider.getInstance().executeQuery("Select * from HoaDon where MaHD=?", maHD);
        HoaDon hoadon = null;
        try {
            while (rs.next()) {
                hoadon = new HoaDon(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return hoadon;
    }
    
    public HoaDon getLastHoaDon() {

        ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getLastHoaDon");
        HoaDon hoadon = null;
        try {
            while (rs.next()) {
                hoadon = new HoaDon(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return hoadon;
    }
}
