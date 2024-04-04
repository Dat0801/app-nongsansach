/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HangHoa;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HangHoaDAO {

    private static HangHoaDAO instance;

    public static HangHoaDAO getInstance() {
        if (instance == null) {
            instance = new HangHoaDAO();
        }
        return instance;
    }

    private HangHoaDAO() {

    }

    public ArrayList<HangHoa> getListHangHoa() {
        ArrayList<HangHoa> listHH = new ArrayList<HangHoa>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("Select * from hanghoa");
            while (rs.next()) {
                HangHoa hanghoa = new HangHoa(rs);
                listHH.add(hanghoa);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listHH;
    }

    public HangHoa getHangHoa(int maHH) {
        ResultSet rs = DataProvider.getInstance().executeQuery("Select * from hanghoa where MaHangHoa=" + maHH);
        HangHoa hanghoa = new HangHoa(rs);
        return hanghoa;
    }

    public int updateHangHoa(HangHoa hanghoa) {
        int rs = DataProvider.getInstance().executeNonQuery("Update hanghoa set MaNhomHang=" + hanghoa.getMaNhomHang() + ", MaNCC=" + hanghoa.getMaNCC() + 
        ", TenHang=N'" + hanghoa.getTenHang() + "', DVT=N'" + hanghoa.getdVT() + "', GiaNhap=" + hanghoa.getGiaNhap()+ ", HeSo=" + hanghoa.getHeSo() + ", HinhAnh='" + hanghoa.getHinhAnh() +
        "', TrangThai='" + hanghoa.getTrangThai() + "'");
        return rs;
    }
}
