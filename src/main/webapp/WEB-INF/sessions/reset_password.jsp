<%--
  Created by IntelliJ IDEA.
  User: rdelarosa
  Date: 11/22/20
  Time: 12:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Reset Password" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />
<div class="container">
    <h1>Please update  your information.</h1>
    <form action="/profile/update" method="post">
        <div class="form-group">
            <label for="new_password">New Password</label>
            <input id="new_password" name="new_password" class="form-control" type="password">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>
<jsp:include page="../partials/footer.jsp"/>
<script>

</script>
</body>
</html>
