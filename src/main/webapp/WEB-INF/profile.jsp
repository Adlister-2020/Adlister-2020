<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${profileOwner.username}>" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <div class="col-md-4">
                <img src="<c:out value="${profileOwner.avatar}"/>" class="rounded-circle" width="200px;" height="200px">
                <p> Joined on: <c:out value="${profileOwner.creation}"/></p>
                <c:if test = "${profileOwner.id == sessionScope.user.id}">
                    <a href="/profile/update">Edit Profile</a>
                    <a href="/profile/settings">Settings</a>
                </c:if>
            <div>
                <c:if test = "${profileOwner.role.equals(\"admin\")}">
                    <a href="/admin" style="color: red">Admin Dashboard</a>
                </c:if>
            </div>
        </div>
        <h1><c:out value="${profileOwner.username}"/>!</h1>
    </div>

    <div class="container">
        <h1>Ads</h1>
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <h3><c:out value ="${ad.title}"/></h3>
                <p><c:out value ="${ad.description}"/></p>
            </div>
        </c:forEach>
    </div>
<jsp:include page="partials/footer.jsp"/>
</body>
</html>
