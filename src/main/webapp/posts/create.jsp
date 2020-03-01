<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Post</title>
</head>
<body>

<h2>Create New Post</h2>
<form action="create" method="post">
    <input type="text" name="title" placeholder="title">
    <br><br>

    <textarea name="content" placeholder="content"></textarea>
    <br><br>

    <input type="text" name="image" placeholder="select image" value="default.jpg">
    <br><br>

    <input type="text" name="category" placeholder="category" value="Uncategory">
    <br><br>
    <button type="submit">Create Post</button>
</form>
</body>
</html>
