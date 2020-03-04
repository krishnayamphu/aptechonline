<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/aptechonline/css/style.css">
    <title>AptechOnline | Home</title>
</head>
<body>

<%@include file="header.jsp" %>

<main>
    <div class="container">
        <section>
            <c:forEach items="${singlePost}" var="post">
                <div class="single-post">
                    <h1 class="post-title">${post.title}</h1>
                    <span class="timestamp">${post.createdAt}</span>

                    <img class="post-image" src="/aptechonline/uploads/${post.image}" alt="">
                    <p class="post-content">${post.content}</p>
                </div>
            </c:forEach>
        </section>
        <aside>
            <h3>Recent Updates</h3>
            <ul>
                <c:forEach items="${recentPosts}" var="post">
                    <li><a href="/aptechonline/post?id=${post.id}">${post.title}</a></li>
                </c:forEach>
            </ul>
        </aside>
    </div>
</main>

<%@include file="footer.jsp" %>

</body>
</html>