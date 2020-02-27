package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDao adminDao = new AdminDao();
        boolean isLogin = adminDao.isLogin(username, password);

        if (isLogin) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", "Admin");
            response.sendRedirect("dashboard");
        } else {
            String msg = "Invalid username or password.";
            request.setAttribute("errMsg", msg);
            request.getRequestDispatcher("admin/login.jsp")
                    .include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("admin/login.jsp")
                .forward(request, response);
    }
}
