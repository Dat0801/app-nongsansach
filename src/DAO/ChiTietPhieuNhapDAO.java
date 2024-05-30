/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.ChiTietPhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Quang
 */
public class ChiTietPhieuNhapDAO {
    private static ChiTietPhieuNhapDAO instance;

    public static ChiTietPhieuNhapDAO getInstance() {
        if (instance == null) {
            instance = new ChiTietPhieuNhapDAO();
        }
        return instance;
    }

    private ChiTietPhieuNhapDAO() {

    }

    public ArrayList<ChiTietPhieuNhap> getListCTPN() {
        ArrayList<ChiTietPhieuNhap> listCTPN = new ArrayList<>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getListCTPN");
            while (rs.next()) {
                ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(rs);
                listCTPN.add(ctpn);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
            
        }
        return listCTPN;
    }
    
     public int insertChiTietPhieuNhap(ChiTietPhieuNhap ctpn) {
        int rs = DataProvider.getInstance().executeNonQuery("call sp_insertCTPN", ctpn.getMaHang(), ctpn.getMaPN(), ctpn.getGiaNhap(), ctpn.getSoLuong(),
                ctpn.getThanhTien());
        return rs;
    }
     
}
