<%--
  Created by IntelliJ IDEA.
  User: rdelarosa
  Date: 11/18/20
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${profileOwner.username} Settings>" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />

<div class="container">
    <h1>Please update  your information.</h1>
    <form action="/profile/settings" method="post">
        <div class="form-check">
            <input class="form-check-input" type="radio" name="end_service" id="end_service" value="1">
            <label class="form-check-label" for="end_service">
                Deactivate Account
            </label>
        </div>
        <div class="form-group">
            <label for="password">Current Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
