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
        ArrayList<ChiTietHoaDon> listCTHD = new ArrayList<ChiTietHoaDon>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT chitiethoadon.MaHang, MaHD, TenHang, SoLuong, DVT, GiaBan, ThanhTien FROM chitiethoadon JOIN hanghoa ON chitiethoadon.MaHang = hanghoa.MaHang;");
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon(rs);
                listCTHD.add(cthd);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listCTHD;
    }
}
