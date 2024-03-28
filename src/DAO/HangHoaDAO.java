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

    public ArrayList<HangHoa> loadListHangHoa() {
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

    public String inHangHoa() {
        ArrayList<HangHoa> listHH = loadListHangHoa();
        String tenHang = "";
        for (HangHoa i : listHH) {
            tenHang = i.getTenHang();
        }
        return String.valueOf(tenHang);
    }
}
