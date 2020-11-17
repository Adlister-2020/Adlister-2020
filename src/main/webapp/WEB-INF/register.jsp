<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="post" class="needs-validation" novalidate>
    <c:choose>
        <c:when test="${sessionScope.usernameError != null}">
            <jsp:include page="partials/error.jsp">
                <jsp:param name="id" value="username"/>
                <jsp:param name="type" value="text"/>
                <jsp:param name="message" value="Please choose a different username"/>
            </jsp:include>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
                <p>it works</p>
            </div>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${sessionScope.emailError != null}">
            <jsp:include page="partials/error.jsp">
                <jsp:param name="id" value="email"/>
                <jsp:param name="type" value="text"/>
                <jsp:param name="message" value="Please choose a different email"/>
            </jsp:include>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" placeholder="email@example.com">
                <p>it works</p>
            </div>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${sessionScope.passError != null}">
            <jsp:include page="partials/error.jsp">
                <jsp:param name="id" value="password"/>
                <jsp:param name="type" value="password"/>
                <jsp:param name="message" value="Please choose a different password"/>
            </jsp:include>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${sessionScope.matchError != null}">
            <jsp:include page="partials/error.jsp">
                <jsp:param name="id" value="confirm_password"/>
                <jsp:param name="type" value="password"/>
                <jsp:param name="message" value="Passwords do not match"/>
            </jsp:include>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
        </c:otherwise>
    </c:choose>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</body>
</html>
