<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<%@include file="admin-header.jsp" %>
<h2>Compose New Message</h2>

<form action="mail" method="post">
    <input type="email" placeholder="to:example@gmail.com" name="to" required>
    <br><br>

    <input type="text" placeholder="subject" name="subject" required>
    <br><br>

    <textarea name="message" cols="30" rows="10" placeholder="message" required></textarea>
    <br><br>

    <button type="submit">Send</button>
</form>

</body>
</html>
