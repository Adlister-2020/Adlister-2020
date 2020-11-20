<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${profileOwner.username}>" />
    </jsp:include>
    <link href="../resources/css/profileStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <h1 class="text-align-center">Hello, <c:out value="${profileOwner.username}"/>!</h1>

    <main class="container">
        <article class="row">
            <aside class="col-3">
                <div class="col-md-4">
                    <img src="<c:out value="${profileOwner.avatar}"/>" class="rounded-circle" width="200px;" height="200px">
                    <p> Member since: <c:out value="${profileOwner.creation}"/></p>
                    <c:if test = "${profileOwner.id == sessionScope.user.id}">
                        <a href="/profile/update">Edit Profile</a>
                        <a href="/profile/settings">Settings</a>
                    </c:if>
                </div>
            </aside>

            <div class="col-8">
                <h1>Ads</h1>
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
                            <div class="list-group-item card-descriptions">
                                <p class="card-text">
                                    <c:out value="${fn:length(ad.description) <=136  ? ad.description : fn:substring(ad.description,0, 136)}"/>
                                </p>
                            </div>
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
        </article>
    </main>
<jsp:include page="partials/footer.jsp"/>
</body>
</html>