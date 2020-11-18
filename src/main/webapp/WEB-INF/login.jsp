<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Please Log In</h1>
        <form action="/login" method="POST">
            <c:choose>
                <c:when test="${sessionScope.userError != null}">
                    <jsp:include page="partials/error.jsp">
                        <jsp:param name="id" value="username"/>
                        <jsp:param name="type" value="text"/>
                        <jsp:param name="message" value="the username field was blank"/>
                    </jsp:include>
                </c:when>
                <c:otherwise>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input id="username" name="username" class="form-control" type="text">
                    </div>
                </c:otherwise>
            </c:choose>

            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
        <form action="/register" method="get">
            <input type="submit" class="btn btn-secondary btn-block" value="Register">
        </form>
    </div>
</body>
</html>
