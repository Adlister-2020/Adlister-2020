<%--
  Created by IntelliJ IDEA.
  User: thomascrowder
  Date: 11/20/20
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <h1>So you've forgotten your password</h1>
    <form action="/user/recovery" method="POST">
        <div class="form-check">
            <input class="form-check-input" type="radio" name="reset-password" id="resetPassword" value="1">
            <label class="form-check-label" for="resetPassword">
                Please send password reset link
            </label>
        </div>
        <div class="form-group">
            <label for="recoveryName">Enter Username</label>
            <input id="recoveryName" name="recovery-user" class="form-control" type="text">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>
<jsp:include page="../partials/footer.jsp"/>
</body>
</html>
