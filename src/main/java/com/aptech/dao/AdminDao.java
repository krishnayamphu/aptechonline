package com.aptech.dao;

import com.aptech.models.Admin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.aptech.dbhelper.ConnectDatabase.connect;

public class AdminDao {
    //save admin user
    public static void saveAdmin(Admin user) {
        Connection con = connect();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO admins (firstname,lastname,username,password) VALUES (?,?,?,?)");
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            int staus = ps.executeUpdate();
            System.out.println("Data Saved");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*Authenticating user login*/
    public boolean isLogin(String username, String password) {
        boolean isLogin = false;
        MessageDigest digest = null;
        Connection con = connect();
        try {
            digest = MessageDigest.getInstance("SHA-256");//MD5, SHA-1, SHA-256
            digest.update(password.getBytes());
            byte[] hash = digest.digest();

            //Converting the byte array in to HexString format
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
            String hashPassword = hexString.toString();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM admins WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, hashPassword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                isLogin = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return isLogin;
    }
}
