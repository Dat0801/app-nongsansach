/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HangHoa;
import DTO.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ThongKeDAO {
     private static ThongKeDAO instance;

    public static ThongKeDAO getInstance() {
        if (instance == null) {
            instance = new ThongKeDAO();
        }
        return instance;
    }

    private ThongKeDAO() {

    }
    
    public ArrayList<HoaDon> thongKeDoanhThuTheoNgay() {
        ArrayList<HoaDon> listHD = new ArrayList<>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_DoanhThuTheoNgay");
            while (rs.next()) {
                HoaDon hoadon = new HoaDon();
                hoadon.setNgayTao(rs.getDate("Ngay"));
                hoadon.setTongTien(rs.getFloat("DoanhThu"));
                listHD.add(hoadon);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return listHD;
    }
    
    public ArrayList<HangHoa> thongKeHangHoaBanChayTheoSoLuong() {
        ArrayList<HangHoa> listHH = new ArrayList<>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_HangHoaBanChayTheoSoLuong");
            while (rs.next()) {
                HangHoa hanghoa = new HangHoa();
                hanghoa.setTenHang(rs.getString("TenHang"));
                hanghoa.setSoLuongTon(rs.getFloat("SoLuong"));
                listHH.add(hanghoa);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return listHH;
    }
}
