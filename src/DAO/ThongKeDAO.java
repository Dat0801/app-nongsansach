/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ThongKe;
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

    public ArrayList<ThongKe> thongKeDoanhThuTheoNgay() {
        ArrayList<ThongKe> listHD = new ArrayList<>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_DoanhThuTheoNgay");
            while (rs.next()) {
                ThongKe thongke = new ThongKe();
                thongke.setNgay(rs.getDate("Ngay"));
                thongke.setDoanhthu(rs.getFloat("DoanhThu"));
                listHD.add(thongke);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return listHD;
    }

    public ArrayList<ThongKe> thongKeThongKeBanChayTheoSoLuong() {
        ArrayList<ThongKe> listHH = new ArrayList<>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_HangHoaBanChayTheoSoLuong");
            while (rs.next()) {
                ThongKe thongke = new ThongKe();
                thongke.setTenHang(rs.getString("TenHang"));
                thongke.setSoluong(rs.getFloat("SoLuong"));
                listHH.add(thongke);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return listHH;
    }

    public ThongKe thongKeDoanhThuVaSoHoaDonTheoNgayHienTai() {
        ThongKe thongke = new ThongKe();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_DoanhThuVaSoHoaDonHomNay");
            while (rs.next()) {
                thongke.setNgay(rs.getDate("Ngay"));
                thongke.setDoanhthu(rs.getFloat("DoanhThu"));
                thongke.setSodonhang(rs.getInt("SoLuongHoaDon"));
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return thongke;
    }
    
    public ThongKe tangGiamSoVoiHomQua() {
        ThongKe thongke = new ThongKe();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_TangGiamPhanTramDoanhThu");
            while (rs.next()) {
                thongke.setTanggiam(rs.getFloat("PhanTramThayDoi"));
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return thongke;
    }
}
