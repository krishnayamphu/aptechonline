package com.aptech.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/admin", "/admin/register", "/admin/media", "/posts", "/posts/edit", "/posts/create"})
public class AdminAuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        boolean isLoggedIn = session != null && session.getAttribute("admin") != null;
        if (isLoggedIn) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("/aptechonline/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
