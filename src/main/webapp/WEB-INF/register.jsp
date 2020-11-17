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
        <c:when test="${sessionScope.registerError != null}">
            <jsp:include page="partials/error.jsp">
                <jsp:param name="id" value="username"/>
                <jsp:param name="type" value="text"/>
            </jsp:include>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="correctUsername">Username</label>
                <input id="correctUsername" name="username" class="form-control" type="text">
                <p>it works</p>
            </div>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${sessionScope.registerError != null}">
            <jsp:include page="partials/error.jsp">
                <jsp:param name="id" value="email"/>
                <jsp:param name="type" value="text"/>
            </jsp:include>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="correctEmail">Email</label>
                <input id="correctEmail" name="correctEmail" class="form-control" type="text" placeholder="email@example.com">
                <p>it works</p>
            </div>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${sessionScope.registerError != null}">
            <jsp:include page="partials/error.jsp">
                <jsp:param name="id" value="password"/>
                <jsp:param name="type" value="password"/>
            </jsp:include>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="correctPassword">Password</label>
                <input id="correctPassword" name="correctPassword" class="form-control" type="password">
            </div>
        </c:otherwise>
    </c:choose>
    <c:choose>

        <c:when test="${sessionScope.registerError != null}">
            <jsp:include page="partials/error.jsp">
                <jsp:param name="id" value="confirmPassword"/>
                <jsp:param name="type" value="password"/>
            </jsp:include>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="confirm_passwordYes">Confirm Password</label>
                <input id="confirm_passwordYes" name="confirm_passwordYes" class="form-control" type="password">
            </div>
        </c:otherwise>
    </c:choose>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</body>
</html>
