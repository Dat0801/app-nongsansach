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

    public ArrayList<NhaCungCap> getListNhaCungCap(int trangthai) {
        ArrayList<NhaCungCap> listNCC = new ArrayList<NhaCungCap>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getListNCC", trangthai);
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
    public ArrayList<NhaCungCap> search(String searchStr) {
        ArrayList<NhaCungCap> listNCC = new ArrayList<>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sp_SearchNCC", searchStr);
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs);
                listNCC.add(ncc);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            // For example, printing the stack trace
        }
        return listNCC;
    }
    public NhaCungCap getNhaCungCap(String maNCC) {
        ResultSet rs = DataProvider.getInstance().executeQuery("call sp_getListNCCByMaNCC", maNCC);
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
        int rs = DataProvider.getInstance().executeNonQuery("call sp_updateNCC", ncc.getMaNCC(), ncc.getTenNCC(), 
        ncc.getSDT(), ncc.getDiaChi());
        return rs;
    }
    
    public int insertNhaCungCap(NhaCungCap ncc) {
        int rs = DataProvider.getInstance().executeNonQuery("call sp_insertNCC", ncc.getMaNCC(), ncc.getTenNCC(),
        ncc.getSDT(), ncc.getDiaChi());
        return rs;
    }
    
    public int deleteNhaCungCap(String maNhaCungCap) {
        int rs = DataProvider.getInstance().executeNonQuery("call sp_deleteNCC", maNhaCungCap);
        return rs;
    }
    public int deletePermanentNhaCungCap(String maNCC) {
        int rs = DataProvider.getInstance().executeNonQuery("call sp_deletePermanentNCC", maNCC);
        return rs;
    }
    
    public int recoveryNhaCungCap(String maNCC) {
        int rs = DataProvider.getInstance().executeNonQuery("call sp_recoverNCC", maNCC);
        return rs;
    }
}
