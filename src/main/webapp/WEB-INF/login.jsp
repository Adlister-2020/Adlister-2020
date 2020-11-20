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


            <c:if test="${requestScope.loginError != null}">
                <h3 style="color: red">There was an error logging you in?!?!?</h3>
                <p style="color: red">Please check your fields for the correct data</p>
            </c:if>
                    <div class="form-group">
                        <label for="username2">Username</label>
                        <input id="username2" name="username2" class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <label for="password2">Password</label>
                        <input id="password2" name="password2" class="form-control" type="password">
                    </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
        <form action="/register" method="get">
            <input type="submit" class="btn btn-secondary btn-block" value="Register.">
        </form>
        <p>If you have forgotten your password, please contact us as 1+(800)-867-5309 with your secret phrase to reset your password.</p>
    </div>


</body>
</html>
