<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

    <div class="container">
        <h1>Ads</h1>
            <c:forEach var="ad" items="${ads}">
                <div class="col-md-6">
                    <h3>${ad.title}</h3>
                    <p>${ad.description}</p>
            </c:forEach>
        </div>
    </div>

</body>
</html>
