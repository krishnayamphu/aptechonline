package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminDao adminDao = new AdminDao();
        boolean isLoggedIn = adminDao.isLogin(username, password);
        if (isLoggedIn) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", "Admin");
            response.sendRedirect("dashboard");
        } else {
            String errMsg = "Invalid username or password.";
            request.setAttribute("errMsg", errMsg);
            request.getRequestDispatcher("admin/login.jsp")
                    .include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("admin/login.jsp")
                .forward(request, response);
    }
}
