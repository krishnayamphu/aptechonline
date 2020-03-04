package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/admin/edit")
public class AdminEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        if (password.equals(cpassword)) {
            MessageDigest digest = null;
            try {
                digest = MessageDigest.getInstance("SHA-256");
                digest.update(password.getBytes());
                byte[] hash = digest.digest();

                //Converting the byte array in to HexString format
                StringBuffer hexString = new StringBuffer();
                for (int i = 0; i < hash.length; i++) {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
                String hashPassword = hexString.toString();

                Admin user = new Admin();
                user.setFirstname(firstname);
                user.setLastname(lastname);
                user.setUsername(username);
                user.setPassword(hashPassword);
                user.setUpdatedAt(timeStamp);
                user.setId(id);

                AdminDao.updateUser(user);
                response.sendRedirect("/aptechonline/admin/edit?id=" + id);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/aptechonline/admin/edit?id=" + id);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Admin user = new Admin();

        user.setId(id);
        List<Admin> singleUser = AdminDao.getSingleAdmin(user);
        request.setAttribute("singleUser", singleUser);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }
}
