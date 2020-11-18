<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/ads">Adlister</a>
        <form class="form-inline" action="/ads" method="get">
            <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${sessionScope.user.username == null}">
                <li class="nav-item"><a class="nav-link" href="/login">Log in</a></li>
                <li class="nav-item"><a class="nav-link" href="/register">Register</a></li>
            </c:if>
            <c:if test="${sessionScope.user.username != null}">
                <li class="nav-item"><a class="nav-link" href="/ads/create">Create an Ad</a></li>
                <li class="nav-item"><a class="nav-link" href="/profile">${sessionScope.user.username}</a></li>
                <li class="nav-item"><a class="nav-link" href="/logout">Log out</a></li>
            </c:if>
            <li><a href="/about">About</a></li>
        </ul>
    </div>
</nav>
