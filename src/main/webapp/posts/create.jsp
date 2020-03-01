<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Post</title>
    <style>
        .modal {
            width: 100%;
            height: 100%;
            position: fixed;
            top: 0;
            left: 0;
            background-color: rgba(0, 0, 0, 0.5);
            display: none;
        }

        .modal-dialog {
            width: 600px;
            height: 400px;
            background-color: white;
            margin: 50px auto;
            position: relative;
            box-shadow: 0 0 10px #222222;
            padding: 15px;
        }

        #close {
            padding: 0 5px;
            border: 1px solid #cccccc;
            cursor: pointer;
        }
    </style>
</head>
<body>

<h2>Create New Post</h2>
<form name="myForm" action="create" method="post">
    <input type="text" name="title" placeholder="title">
    <br><br>

    <textarea name="content" placeholder="content"></textarea>
    <br><br>

    <input type="text" name="image" placeholder="select image" value="default.jpg">
    <button type="button" id="btnImage">Choose Image</button>
    <br><br>

    <input type="text" name="category" placeholder="category" value="Uncategory">
    <br><br>
    <button type="submit">Create Post</button>
</form>

<div class="modal">
    <div class="modal-dialog">
        <span id="close">&times;</span>
        <hr>
        <p>all media files</p>
        <c:forEach items="${allFileList}" var="file">
            <img id="closeImage" onclick="setImage('${file}')" style="width: 100px; margin:5px;" src="http://localhost:8080/aptechonline/uploads/${file}"
                 alt="">
        </c:forEach>
    </div>
</div>

<script src="/aptechonline/js/jquery.min.js"></script>
<script>
    $(function () {
        //show modal
        $("#btnImage").click(function () {
            $(".modal").css({"display": "block"});
        });

        //hide modal
        $("#close").click(function () {
            $(".modal").css({"display": "none"});
        });

        //hide modal
        $("#closeImage").click(function () {
            $(".modal").css({"display": "none"});
        });
    });

    function setImage(name) {
        document.forms['myForm'].image.value = name;
    }
</script>
</body>
</html>
