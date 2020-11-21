<%--
  Created by IntelliJ IDEA.
  User: rdelarosa
  Date: 11/21/20
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
