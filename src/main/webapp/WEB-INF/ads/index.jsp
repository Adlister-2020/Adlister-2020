<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">

    <h1>Here Are all the ads!</h1>
    <c:if test="${category != null}">
        <h3>In the category of ${category.getTitle()}</h3>
    </c:if>

    <div class="row d-flex justify-content-center">
        <h1 class="text-center my-3">Here Are all the ads!</h1>
        <c:forEach var="ad" items="${ads}">
            <div class=" col-12 my-3">
                <div class="card shadow d-flex justify-content-center" style="width: 100%;">
                        <%--        <img class="card-img-top" src="..." alt="Card image cap">--%>
                    <div class="list-group list-group-flush">
                        <div class="list-group-item">
                            <h4 class="card-title"><c:out value="${ad.title}"/></h4>
                        </div>
                        <div class="list-group-item">
                            <h5>Description</h5>
                            <p class="card-text"><c:out value="${ad.description}"/></p>
                            <c:if test="${categoriesDao.getCategoriesOfAd(ad) != null}">
                                <div><strong>Categories: </strong>
                                    <c:forEach var="cat" items="${categoriesDao.getCategoriesOfAd(ad)}">
                                        <span class="bg-secondary p-2 m-2 rounded-pill">
                                            <a class="text-white" href="<c:url value='/ads?category=${cat.getTitle()}'/>">
                                                <c:out value="${cat.getCaplizedFirstLetterTitle()}" />
                                            </a>
                                        </span>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>
                        <div class="list-group-item d-flex justify-content-between">
                            <a href='/ads/ad?adId=<c:out value="${ad.id}"/>'>View Ad</a>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>
    </div>
    <div>
    </div>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
