<%--
  Created by IntelliJ IDEA.
  User: rdelarosa
  Date: 11/16/20
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${ad.title}" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<body>
<div class="container d-flex justify-content-center">
    <div class="card d-flex justify-content-center" style="width: 80%;">
<%--        <img class="card-img-top" src="..." alt="Card image cap">--%>
        <div class="list-group list-group-flush">
            <div class="list-group-item">
                <h4 class="card-title"><c:out value="${ad.title}"/></h4>
            </div>
            <div class="list-group-item">
                Show Users Info here needed from need to get user by id on user ad dao
            </div>
            <div class="list-group-item">
                <h5>Description</h5>
                <p class="card-text"><c:out value="${ad.description}"/></p>
            </div>
            <div class="list-group-item d-flex justify-content-between">
                <a href="/ads" class="card-link">View All Ads</a>
                <a href="#" class="card-link">Link to users profile</a>
            </div>
        </div>
    </div>
    
</div>
<jsp:include page="/WEB-INF/partials/head.jsp"/>
</body>
</html>
