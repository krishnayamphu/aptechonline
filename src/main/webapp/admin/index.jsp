<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Admin Users</title>
</head>
<body>
<a href="admin/register">Create Admin User</a>
<h2>Manage Admin Users</h2>
<table border="1">
    <tr>
        <th>#ID</th>
        <th>Full Name</th>
        <th>Username</th>
        <th>Date</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${allAdmins}" var="admin">
        <tr>
            <td>${admin.id}</td>
            <td>${admin.firstname} ${admin.lastname}</td>
            <td>${admin.username}</td>
            <td>${admin.createdAt}</td>
            <td><a href="admin/edit?id=${admin.id}">
                <button>Edit</button>
            </a>

                <form action="admin" method="post">
                    <input type="hidden" name="id" value="${admin.id}">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
