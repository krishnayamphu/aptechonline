package com.aptech.controllers.posts;

import com.aptech.dao.PostDao;
import com.aptech.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/posts/create")
public class PostCreateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String image = request.getParameter("image");
        String category = request.getParameter("category");

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setImage(image);
        post.setCategory(category);

        PostDao.savePost(post);
        response.sendRedirect("/aptechonline/posts");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> allFileList = new ArrayList<>();

        String root = getServletContext().getRealPath("/");
        File path = new File(root + "/uploads");

        File[] allFiles = path.listFiles();
        if (allFiles != null) {
            for (File f : allFiles) {
                allFileList.add(f.getName());
                System.out.println(f.getName());
            }
        }
        request.setAttribute("allFileList", allFileList);
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }
}
