<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/aptechonline/css/style.css">
    <title>AptechOnline | ${title}</title>
</head>
<body>

<%@include file="header.jsp" %>

<main>
    <div class="container">
        <section>
            <c:forEach items="${allCategoryPosts}" var="post">
                <article>
                    <h1><a href="/aptechonline/post?id=${post.id}">${post.title}</a></h1>
                    <span>${post.createdAt}</span>

                    <img src="/aptechonline/uploads/${post.image}" alt="">
                    <p>${post.content}</p>
                    <a class="readmore" href="/aptechonline/post?id=${post.id}">Read more</a>
                </article>
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