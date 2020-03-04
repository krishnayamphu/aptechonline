package com.aptech.controllers;

import com.aptech.dao.PostDao;
import com.aptech.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/post")
public class SinglePageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = new Post();
        post.setId(id);

        List<Post> singlePost = PostDao.getPost(post);
        List<Post> recentPosts = PostDao.getRecentPosts();

        request.setAttribute("singlePost", singlePost);
        request.setAttribute("recentPosts", recentPosts);
        request.getRequestDispatcher("single.jsp").forward(request, response);
    }
}
