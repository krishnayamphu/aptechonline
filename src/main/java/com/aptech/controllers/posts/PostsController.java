package com.aptech.controllers.posts;

import com.aptech.dao.PostDao;
import com.aptech.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/posts")
public class PostsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = new Post();
        post.setId(id);

        PostDao.deletePost(post);
        response.sendRedirect("posts");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> allPosts = PostDao.getAllPosts();
        request.setAttribute("allPosts", allPosts);
        request.getRequestDispatcher("posts/index.jsp").forward(request, response);
    }
}
