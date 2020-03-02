<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/aptechonline/css/style.css">
    <title>AptechOnline | Home</title>
</head>
<body>

<header>
    <div class="container">
        <nav>
            <a class="brand" href="">AptechOnline</a>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Politics</a></li>
                <li><a href="#">LifeStyle</a></li>
                <li><a href="#">Entertainment</a></li>
            </ul>
        </nav>
    </div>
</header>

<main>
    <div class="container">
        <section>
            <c:forEach items="${allPosts}" var="post">
                <article>
                    <h1><a href="">${post.title}</a></h1>
                    <span>${post.createdAt}</span>

                    <img src="/aptechonline/uploads/${post.image}" alt="">
                    <p>${post.content}</p>
                    <a class="readmore" href="#">Readmore</a>
                </article>
            </c:forEach>
        </section>
        <aside>
            <h3>Recent Updates</h3>
            <ul>
                <li><a href="">Link 1</a></li>
                <li><a href="">Link 1</a></li>
                <li><a href="">Link 1</a></li>
                <li><a href="">Link 1</a></li>
                <li><a href="">Link 1</a></li>
            </ul>
        </aside>
    </div>
</main>

<footer>
    <div class="container">
        <p>&copy; copyright 2020, AptechOnline.</p>
    </div>
</footer>

</body>
</html>