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
}
