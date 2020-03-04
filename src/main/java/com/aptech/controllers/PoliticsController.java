package com.aptech.controllers;

import com.aptech.dao.PostDao;
import com.aptech.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/politics")
public class PoliticsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post post = new Post();
        post.setCategory("Politics");
        List<Post> allCategoryPosts = PostDao.getPostsByCategory(post);
        List<Post> recentPosts = PostDao.getRecentPostsByCategory(post);

        request.setAttribute("title", "Politics");
        request.setAttribute("allCategoryPosts", allCategoryPosts);
        request.setAttribute("recentPosts", recentPosts);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }
}
