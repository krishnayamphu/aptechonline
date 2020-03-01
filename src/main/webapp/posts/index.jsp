<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Post</title>
</head>
<body>

<h2>Manage Posts</h2>
<table border="1">
    <tr>
        <th>#ID</th>
        <th>Title</th>
        <th>Image</th>
        <th>Category</th>
        <th>Date</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${allPosts}" var="post">
        <tr>
            <td>${post.id}</td>
            <td>${post.title}</td>
            <td>${post.image}</td>
            <td>${post.category}</td>
            <td>${post.createdAt}</td>
            <td><a href="aptechonline/posts/edit?id=${post.id}">
                <button>Edit</button>
            </a>
                <form action="posts" method="post">
                    <input type="hidden" name="id" value="${post.id}">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
