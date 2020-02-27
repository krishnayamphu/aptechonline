package com.aptech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.aptech.dbhelper.ConnectDatabase.connect;

public class AdminDao {

    /*Authenticating user login*/
    public boolean isLogin(String username, String password) {
        boolean isLogin = false;
        Connection con = connect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM admins WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                isLogin = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isLogin;
    }
}
