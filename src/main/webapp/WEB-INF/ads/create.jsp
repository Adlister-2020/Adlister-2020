<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
    <div class="container">
        <h1 class="text-center">Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title(required)</label>
                <input id="title" name="title" class="form-control" type="text" required>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <div class="form-group">
                <label>Category(required, choose all that apply)</label><br>
                <c:forEach var="category" items="${categories}">
                    <input type="checkbox" id="${category.getTitle()}" name="category" value="${category.getTitle()}">
                    <label for="${category.getTitle()}"><c:out value="${category.getCaplizedFirstLetterTitle()}" /></label><br>
                </c:forEach>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
    <jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
