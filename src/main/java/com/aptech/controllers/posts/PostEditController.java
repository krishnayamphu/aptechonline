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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/posts/edit")
public class PostEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String image = request.getParameter("image");
        String category = request.getParameter("category");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setImage(image);
        post.setCategory(category);
        post.setUpdatedAt(timeStamp);

        PostDao.updatePost(post);
        response.sendRedirect("/aptechonline/posts/edit?id=" + id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = new Post();
        post.setId(id);
        List<Post> singlePost = PostDao.getPost(post);
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
        request.setAttribute("singlePost", singlePost);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }
}
