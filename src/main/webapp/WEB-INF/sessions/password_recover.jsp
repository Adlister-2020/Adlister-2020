<%--
  Created by IntelliJ IDEA.
  User: thomascrowder
  Date: 11/20/20
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <h1>So you've forgotten your password</h1>
    <h2>Hopefully you remember your secret phrase!</h2>

    <form action="/login" method="POST">
        <label for="secret_phrase">Please enter your secret phrase</label>
        <input id="secret_phrase" type="text">
    </form>




<jsp:include page="../partials/footer.jsp"/>
</body>
</html>
