<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Media</title>
</head>
<body>

<form method="POST" enctype="multipart/form-data" action="media">
    File to upload: <input type="file" name="upfile"><br/>
    <br/>
    <input type="submit" value="Upload">
</form>
<hr>
<a href="http://localhost:8080/webdemo/dashboard">Dashboard</a> |
<a href="http://localhost:8080/webdemo/users">Users</a>
<hr>

<h2>Manage Media Files</h2>
<c:forEach items="${allFileList}" var="file">
    <a href="http://localhost:8080/webdemo/preview?name=${file}">
        <img style="width: 100px; margin:5px;" src="http://localhost:8080/aptechonline/uploads/${file}" alt="">
    </a>
</c:forEach>

</body>
</html>
