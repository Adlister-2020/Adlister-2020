<%--
  Created by IntelliJ IDEA.
  User: rdelarosa
  Date: 11/21/20
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/login" method="POST" class="needs-validation" novalidate>
    <c:if test="${requestScope.loginError != null}">
        <h4 style="color: red">There was an error logging you in.</h4>
        <p style="color: red">Please check your fields for the correct data</p>
    </c:if>
    <div class="form-group">
        <label for="username2">Username</label>
        <input id="username2" name="username2" class="form-control" type="text" required>
        <div class="invalid-feedback">
            Please provide a valid username.
        </div>

    </div>
    <div class="form-group">
        <label for="password2">Password</label>
        <input id="password2" name="password2" class="form-control" type="password" required>
        <div class="invalid-feedback">
            Please provide a valid password.
        </div>

    </div>
    <input type="submit" class="btn btn-primary btn-block" value="Log In">
    <p class="hint-text text-center mt-3 small text text-muted">
        <a href="${pageContext.request.contextPath}/user/recovery">I forgot my password?</a>
    </p>
</form>
