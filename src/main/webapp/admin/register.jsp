<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Admin</title>
</head>
<body>

<h2>Register New Admin User</h2>

<form action="register" method="post">
    <input type="text" placeholder="Enter Firstname" name="firstname" required>
    <br><br>

    <input type="text" placeholder="Enter Lastname" name="lastname" required>
    <br><br>

    <input type="text" placeholder="Enter Username" name="username" required>
    <br><br>

    <input type="password" placeholder="Enter Password" name="password" required>
    <br><br>

    <input type="password" placeholder="Enter Confirm Passowrd" name="cpassword" required>
    <c:if test="${errMsg!=null}">
        <p style="color:red">${errMsg}</p>
    </c:if>

    <br><br>
    <button type="submit">Register</button>
</form>

</body>
</html>
