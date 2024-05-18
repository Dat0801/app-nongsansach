/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietHoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDonDAO {
    private static ChiTietHoaDonDAO instance;

    public static ChiTietHoaDonDAO getInstance() {
        if (instance == null) {
            instance = new ChiTietHoaDonDAO();
        }
        return instance;
    }

    private ChiTietHoaDonDAO() {

    }

    public ArrayList<ChiTietHoaDon> getListCTHD() {
        ArrayList<ChiTietHoaDon> listCTHD = new ArrayList<>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getListCTHD");
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon(rs);
                listCTHD.add(cthd);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
            
        }
        return listCTHD;
    }
    
     public int insertChiTietHoaDon(ChiTietHoaDon cthd) {
        int rs = DataProvider.getInstance().executeNonQuery("call sp_insertChiTietHoaDon", cthd.getMaHang(), cthd.getMaHD(), cthd.getSoLuong(),
                cthd.getThanhTien());
        return rs;
    }
}
