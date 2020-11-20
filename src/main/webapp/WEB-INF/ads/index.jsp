<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<section>
<div class="w-100 my-5">
    <div class="row d-flex justify-content-center">
        <c:if test="${fn:length(ads) == 0}">
            <h3 class="font-weight-bold"> Try a new search </h3>
            <p class="text-muted">Change your search filters, check your spelling, or try a less specific search</p>
        </c:if>
        <c:forEach var="ad" items="${ads}">
            <div id="${ad.id}" class="card menu-view shadow-lg grow m-3">
                <a href='${pageContext.request.contextPath}/ads/ad?adId=<c:out value="${ad.id}"/>'>
                    <c:choose>
                        <c:when test="${fn:length(ad.getImages()) > 0}">
                            <img src="${ad.getImages()[0].url}" class="card-img-top" alt="..." >
                        </c:when>
                        <c:otherwise>
                            <img src="https://via.placeholder.com/800x600.png?text=Create+Your+Own+Ad" class="card-img-top" alt="..." style="height:24rem">
                        </c:otherwise>
                    </c:choose>
                </a>
                <div class="list-group list-group-flush">
                    <div class="list-group-item card-adtitle">
                        <a href='${pageContext.request.contextPath}/ads/ad?adId=<c:out value="${ad.id}"/>'>
                            <h5 class="card-title"><c:out value="${ad.title}"/></h5>
                        </a>
                    </div>
<%--                    <div class="list-group-item card-descriptions">--%>
<%--                        <h6>Description</h6>--%>
<%--                        <p class="card-text">--%>
<%--                            <c:out value="${fn:length(ad.description) <=136  ? ad.description : fn:substring(ad.description,0, 136)}"/>--%>
<%--                        </p>--%>
<%--                    </div>--%>
                    <div class="list-group-item card-price">
                        <p class="card-text font-weight-bold float-left">
                            $<c:out value="${ad.price}"/>

                        </p>
                        <p class="card-text text-muted float-right">
                            <i class="fas fa-map-marker-alt"></i> <c:out value="${ad.location}"/>
                        </p>
                    </div>
                    <div class="list-group-item card-categories">
                        <c:if test="${categoriesDao.getCategoriesOfAd(ad) != null}">
                            <div>
                                <ul class="list-inline">
                                    <c:forEach var="cat" items="${categoriesDao.getCategoriesOfAd(ad)}">
                                    <li class="list-inline-item">
                                        <span class="badge border border-info badge-pill ">
                                            <a href="<c:url value='/ads?category=${cat.getTitle()}'/>">
                                                <c:out value="${cat.getCaplizedFirstLetterTitle()}" />
                                            </a>
                                        </span>
                                    </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</section>
<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>
