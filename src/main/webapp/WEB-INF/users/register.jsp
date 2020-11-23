<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <jsp:include page="register_form.jsp"/>
    </div>
    <jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
