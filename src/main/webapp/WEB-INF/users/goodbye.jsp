<%--
  Created by IntelliJ IDEA.
  User: rdelarosa
  Date: 11/18/20
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Goodbye" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />
     <div class="container d-flex justify-content-center">
         <h1>Thank you for your choosing us. We hope to see you again soon.</h1>
     </div>
<jsp:include page="/WEB-INF/partials/footer.jsp"/>
<script>
    setTimeout(function(){
        window.location.href = "/login";
    }, 3500);
</script>
</body>
</html>
