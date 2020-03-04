package com.aptech.dao;

import com.aptech.models.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.aptech.dbhelper.ConnectDatabase.connect;

public class PostDao {
    //save post
    public static void savePost(Post post) {
        Connection con = connect();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO posts (title,content,image,category) VALUES (?,?,?,?)");
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setString(3, post.getImage());
            ps.setString(4, post.getCategory());
            int staus = ps.executeUpdate();
            System.out.println("Data Saved");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // show all posts
    public static List<Post> getAllPosts() {
        Connection con = connect();
        List<Post> allPosts = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM posts");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(Integer.parseInt(rs.getString("id")));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setCategory(rs.getString("category"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));

                allPosts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPosts;
    }

    // show all posts
    public static List<Post> getAllPostsByOrder() {
        Connection con = connect();
        List<Post> allPosts = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM posts ORDER BY id DESC LIMIT 10");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(Integer.parseInt(rs.getString("id")));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setCategory(rs.getString("category"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));

                allPosts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPosts;
    }

    // get all posts by category
    public static List<Post> getPostsByCategory(Post myPost) {
        Connection con = connect();
        List<Post> allPosts = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM posts WHERE category=?");
            ps.setString(1, myPost.getCategory());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(Integer.parseInt(rs.getString("id")));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setCategory(rs.getString("category"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));

                allPosts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPosts;
    }

    // get recent posts
    public static List<Post> getRecentPosts() {
        Connection con = connect();
        List<Post> allPosts = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM posts ORDER BY id DESC LIMIT 5");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(Integer.parseInt(rs.getString("id")));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setCategory(rs.getString("category"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
                allPosts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPosts;
    }

    // get recent posts by category
    public static List<Post> getRecentPostsByCategory(Post myPost) {
        Connection con = connect();
        List<Post> allPosts = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM posts WHERE category=? ORDER BY id DESC LIMIT 5");
            ps.setString(1, myPost.getCategory());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(Integer.parseInt(rs.getString("id")));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setCategory(rs.getString("category"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
                allPosts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPosts;
    }

    // get single post
    public static List<Post> getPost(Post myPost) {
        Connection con = connect();
        List<Post> singlePost = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM posts WHERE id=?");
            ps.setInt(1, myPost.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(Integer.parseInt(rs.getString("id")));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setCategory(rs.getString("category"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));

                singlePost.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return singlePost;
    }

    //save post
    public static void updatePost(Post post) {
        Connection con = connect();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE posts SET title=?,content=?,image=?,category=?,updated_at=? WHERE id=?");
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setString(3, post.getImage());
            ps.setString(4, post.getCategory());
            ps.setString(5, post.getUpdatedAt());
            ps.setInt(6, post.getId());
            int staus = ps.executeUpdate();
            System.out.println("Data Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete post
    public static void deletePost(Post post) {
        Connection con = connect();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM posts WHERE id=?");
            ps.setInt(1, post.getId());
            ps.executeUpdate();

            System.out.println("Data Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
