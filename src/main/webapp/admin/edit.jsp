<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<%@include file="admin-header.jsp" %>
<h2>User Details</h2>

<form action="edit" method="post">
    <c:forEach items="${singleUser}" var="user">
        <input type="hidden" name="id" value="${user.id}">

        <input type="text" placeholder="Enter Firstname" name="firstname" value="${user.firstname}" required>
        <br><br>

        <input type="text" placeholder="Enter Lastname" name="lastname" value="${user.lastname}" required>
        <br><br>

        <input type="text" placeholder="Enter Username" name="username" value="${user.username}" required>
        <br><br>

        <input type="password" placeholder="Enter Password" name="password" value="${user.password}" required>
        <br><br>

        <input type="password" placeholder="Enter Confirm Passowrd" name="cpassword" required>
    </c:forEach>

    <br><br>
    <button type="submit">Update</button>
</form>

</body>
</html>
