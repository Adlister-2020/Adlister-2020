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
        <div id="carousel<c:out value="${ad.id}"/>" class="carousel slide carousel-fade" data-ride="carousel">
            <div class="carousel-inner">
                <c:forEach items="${ad.getImages()}" var="img" varStatus="loop">
                    <c:choose>
                        <c:when test="${loop.index == 0}">
                            <div class="carousel-item active">
                                <img src="${img.url}" class="d-block w-100" alt="...">
                            </div>
                        </c:when>
                        <c:when test="${loop.index > 0}">
                            <div class="carousel-item">
                                <img src="${img.url}" class="d-block w-100" alt="...">
                            </div>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </div>
            <a class="carousel-control-prev" href="#carousel<c:out value="${ad.id}"/>" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carousel<c:out value="${ad.id}"/>" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <div class="list-group list-group-flush">
            <div class="list-group-item">
                <h4 class="card-title"><c:out value="${ad.title}"/></h4>
            </div>
            <div class="list-group-item">
                <img src="<c:out value="${ad.getAuthor().getAvatar()}"/>" class="rounded-circle" width="80px;" height="80px">
                <a href="<c:out value="/profile?author=${ad.getAuthor().getId()}"/>" class="card-text"><c:out value="${ad.getAuthor().getUsername()}"/></a>
            </div>
            <div class="list-group-item">
                <h5>Description</h5>
                <p class="card-text"><c:out value="${ad.description}"/></p>
                <c:if test="${sessionScope.user.username != null}">
                    <c:if test="${sessionScope.user.id == ad.userId}">
                        <button type="button" class="btn btn-primary card-link" data-toggle="modal" data-target="#editModal">
                            Edit
                        </button>
                    </c:if>

                </c:if>
            </div>
            <div class="list-group-item d-flex justify-content-between">
                <a href="/ads" class="card-link">View All Ads</a>
                <p>Created: <c:out value="${ad.creation}"/> </p>
            </div>
<%--            Edit Pop-up Modal --%>
            <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content" >
                        <form action="/ad-update" method="POST">
                            <div class="modal-header">
                               <input id="id" name="addId" type="hidden" value="<c:out value='${ad.id}'/>">
                               <input id="title" name="title" class="modal-title" value="<c:out value='${ad.title}'/>">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
    <%--                            Ad Description for editing in modal--%>
                                <input id="description" name="description" class="modal-title" value="<c:out value='${ad.description}'/>">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <button type="Submit" class="btn btn-primary">Save changes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</div>
<jsp:include page="/WEB-INF/partials/head.jsp"/>
<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
