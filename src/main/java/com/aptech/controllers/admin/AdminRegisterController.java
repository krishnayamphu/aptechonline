package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/register")
public class AdminRegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");

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

                AdminDao.saveAdmin(user);
                response.sendRedirect("admin");


            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } else {
            String errMsg = "Confirm password do not match !";
            request.setAttribute("errMsg", errMsg);
            request.getRequestDispatcher("admin/register.jsp").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("admin/register.jsp").forward(request, response);
    }
}
