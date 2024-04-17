/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhaCungCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NhaCungCapDAO {
    private static NhaCungCapDAO instance;

    public static NhaCungCapDAO getInstance() {
        if (instance == null) {
            instance = new NhaCungCapDAO();
        }
        return instance;
    }

    private NhaCungCapDAO() {

    }

    public ArrayList<NhaCungCap> getListNhaCungCap() {
        ArrayList<NhaCungCap> listNCC = new ArrayList<NhaCungCap>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("Select * from NhaCungCap");
            while (rs.next()) {
                NhaCungCap nhacungcap = new NhaCungCap(rs);
                listNCC.add(nhacungcap);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listNCC;
    }
    
    public NhaCungCap getNhaCungCap(int maNCC) {
        ResultSet rs = DataProvider.getInstance().executeQuery("Select * from NhaCungCap where MaNCC=" + maNCC);
        NhaCungCap nhacungcap = null;
        try {
            while (rs.next()) {
                nhacungcap = new NhaCungCap(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return nhacungcap;
    }
    public int updateNhaCungCap(NhaCungCap ncc) {
        int rs = DataProvider.getInstance().executeNonQuery("Update nhacungcap set MaNCC=" + ncc.getMaNCC()+ ", TenNCC=N'" + ncc.getTenNCC() + 
        "', SDT='" + ncc.getSDT()+ "', DiaChi=N'" + ncc.getDiaChi()+ "', TrangThai='" + ncc.getTrangThai() + "' where MaNCC=" + ncc.getMaNCC());
        return rs;
    }
    
    public int insertNhaCungCap(NhaCungCap ncc) {
        int rs = DataProvider.getInstance().executeNonQuery("Insert into nhacungcap values(" + ncc.getMaNCC()+ ", N'" + ncc.getTenNCC()+ 
        "','" + ncc.getSDT()+ "', N'" + ncc.getDiaChi()+ "', " + ncc.getTrangThai() + ")");
        return rs;
    }
    
    public int deleteNhaCungCap(int maNhaCungCap) {
        int rs = DataProvider.getInstance().executeNonQuery("Update nhacungcap set TrangThai=0 where MaNCC=" + maNhaCungCap);
        return rs;
    }
}
