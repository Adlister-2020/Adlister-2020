<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Categories"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Here Are all the categories!</h1>

    <c:forEach var="category" items="${categories}">
        <div class="col-md-6">
            <h3><a href="<c:url value='/ads?category=${category.title}'/>">
                    ${category.title}</a></h3>
        </div>
    </c:forEach>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
