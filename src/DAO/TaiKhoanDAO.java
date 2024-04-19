package DAO;

import DTO.NhanVien;
import DAO.DataProvider;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class TaiKhoanDAO {
    private static TaiKhoanDAO instance;

    public static TaiKhoanDAO getInstance() {
        if (instance == null) {
            instance = new TaiKhoanDAO();
        }
        return instance;
    }

    private TaiKhoanDAO() {

    }
    
    public NhanVien Login(String username, String password) {
        ResultSet rs = DataProvider.getInstance().executeQuery("call sp_Login", username, password);
        NhanVien nv = null;
        try {
            if (rs.next()) {
                nv = new NhanVien(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return nv;
    }
}
