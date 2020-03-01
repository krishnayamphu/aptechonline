package com.aptech.dao;

import com.aptech.models.Admin;
import com.aptech.models.Post;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.aptech.dbhelper.ConnectDatabase.connect;

public class AdminDao {

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

    // show all admin users
    public static List<Admin> getAllAdmins() {
        Connection con = connect();
        List<Admin> allAdmins = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM admins");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(Integer.parseInt(rs.getString("id")));
                admin.setFirstname(rs.getString("firstname"));
                admin.setLastname(rs.getString("lastname"));
                admin.setUsername(rs.getString("username"));
                admin.setCreatedAt(rs.getString("created_at"));
                admin.setUpdatedAt(rs.getString("updated_at"));

                allAdmins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allAdmins;
    }

    // get single admin user
    public static List<Admin> getSingleAdmin(Admin user) {
        Connection con = connect();
        List<Admin> singleUser = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM admins WHERE id=?");
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(Integer.parseInt(rs.getString("id")));
                admin.setFirstname(rs.getString("firstname"));
                admin.setLastname(rs.getString("lastname"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setCreatedAt(rs.getString("created_at"));
                admin.setUpdatedAt(rs.getString("updated_at"));

                singleUser.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return singleUser;
    }

    //update admin user
    public static void updateUser(Admin user) {
        Connection con = connect();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE admins SET firstname=?,lastname=?,username=?,password=?,updated_at=? WHERE id=?");
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getUpdatedAt());
            ps.setInt(6, user.getId());
            ps.executeUpdate();

            System.out.println("Data Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete admin user
    public static void deleteAdmin(Admin user) {
        Connection con = connect();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM admins WHERE id=?");
            ps.setInt(1, user.getId());
            ps.executeUpdate();

            System.out.println("Data Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
