<%--
  Created by IntelliJ IDEA.
  User: rdelarosa
  Date: 11/21/20
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/register" method="post" class="needs-validation" novalidate>
    <c:choose>
        <c:when test="${requestScope.usernameError != null}">
            <jsp:include page="error.jsp">
                <jsp:param name="id" value="username"/>
                <jsp:param name="type" value="text"/>
                <jsp:param name="message" value="Please choose a different username"/>
            </jsp:include>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${requestScope.emailError != null}">
            <jsp:include page="error.jsp">
                <jsp:param name="id" value="email"/>
                <jsp:param name="type" value="text"/>
                <jsp:param name="message" value="Please choose a different email"/>
            </jsp:include>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" placeholder="email@example.com">
            </div>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${requestScope.passError != null}">
            <jsp:include page="error.jsp">
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
        <c:when test="${requestScope.matchError != null}">
            <jsp:include page="error.jsp">
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
    <div class="form-group">
        <label for="passRecover" >Enter your secret phrase(This will be used in the case that you forget your password. We recommend using the name of a loved one or the street you grew up on.)</label>
        <input id="passRecover" name="passRecover" class="form-control" type="text">
    </div>
    <input type="submit" class="btn btn-primary btn-block">
</form>
