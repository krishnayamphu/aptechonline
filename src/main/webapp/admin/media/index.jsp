<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Media</title>
</head>
<body>
<%@include file="/admin/admin-header.jsp" %>
<br><br>
<form method="POST" enctype="multipart/form-data" action="media">
    File to upload: <input type="file" name="upfile"><br/>
    <br/>
    <input type="submit" value="Upload">
</form>
<hr>

<h2>Manage Media Files</h2>
<c:forEach items="${allFileList}" var="f;;ile">
    <a href="http://localhost:8080/webdemo/preview?name=${file}">
        <img style="width: 100px; margin:5px;" src="http://localhost:8080/aptechonline/uploads/${file}" alt="">
    </a>
</c:forEach>

</body>
</html>
