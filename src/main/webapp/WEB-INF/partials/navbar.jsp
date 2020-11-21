<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav id="mainNav" class="navbar navbar-expand-lg shadow-md mb-3 w-100">
    <div class="container-fluid d-flex align-items-center justify-content-around">
        <a class="navbar-brand" href="/ads">Adlister</a>
        <div id="mobile-search"></div>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ml-auto">
                <li id="expanded-search" class="nav-item"></li>
            </ul>
            <ul class="navbar-nav text-uppercase ml-auto">
                <li class="nav-item"><a class="nav-link" href="/about">About</a></li>
                <c:if test="${sessionScope.user.username == null}">
                    <li class="nav-item"><a class="nav-link" href="/login">Log in</a></li>
                    <li class="nav-item"><a class="nav-link" href="/register">Register</a></li>
                </c:if>

                <c:if test="${sessionScope.user.username != null}">
                    <li class="nav-item"><a class="nav-link" href="/ads/create">Create an Ad</a></li>
                    <li class="nav-item dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">
                        <span class="nav-label">
                            <c:choose>
                                <c:when test="${sessionScope.user.avatar!=null}">
                            <img src="<c:out value="${sessionScope.user.avatar}"/>"
                                 class="rounded-circle nav-img" style="width:30px;height:30px" alt="">
                                </c:when>
                                <c:otherwise>
                                    ${sessionScope.user.username}
                                </c:otherwise>
                            </c:choose>
                        </span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="nav-link" href="/profile">Profile</a></li>
                            <li><a class="nav-link" href="/logout">Log out</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
        <button class="navbar-toggler navbar-toggler-right mr-2" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-chevron-down"></i>
        </button>
    </div>
</nav>


