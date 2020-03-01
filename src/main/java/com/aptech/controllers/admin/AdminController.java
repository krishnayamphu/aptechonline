package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;
import com.aptech.dao.PostDao;
import com.aptech.models.Admin;
import com.aptech.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Admin user = new Admin();
        user.setId(id);

        AdminDao.deleteAdmin(user);
        response.sendRedirect("admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Admin> allAdmins = AdminDao.getAllAdmins();
        request.setAttribute("allAdmins", allAdmins);
        request.getRequestDispatcher("admin/index.jsp").forward(request, response);
    }
}
