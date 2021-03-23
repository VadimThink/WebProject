<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/head.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome-4.7.0/css/font-awesome.css">
</head>
<body>
<div class="header">
    <div class="Site">
        <p>
            <a class="abiturientButton" href="${pageContext.request.contextPath}/controller?command=home_page">
                Абитуриент
            </a>
        </p>
    </div>
    <div class="messages">
        <a class="bellButton" href="">
            <i class="fa fa-bell fa-2x"></i>
        </a>
    </div>
    <div class="flag">
        <a href="${pageContext.request.contextPath}/controller?command=change_language&language=ru">
            <img src="${pageContext.request.contextPath}/images/rus.png" width="50" height="25">
        </a>
    </div>
    <div clas="flag">
        <a href="${pageContext.request.contextPath}/controller?command=change_language&language=en">
            <img src="${pageContext.request.contextPath}/images/eng.png" width="50" height="25">
        </a>
    </div>
    <div class="navbar">
        <c:choose>
            <c:when test="${!empty sessionScope.user}">
                <nav>
                    <ul class="topmenu">
                        <li>
                            <p>
                                    ${user}
                                <i class="fa fa-angle-down"></i>
                            </p>
                            <ul class="submenu">
                                <li>
                                    <p>
                                        <a href="${pageContext.request.contextPath}/controller?command=menu">
                                            <fmt:message key="button.menu"/>
                                        </a>
                                    </p>
                                </li>
                                <li>
                                    <p>
                                        <a href="${pageContext.request.contextPath}/controller?command=profile">
                                            <fmt:message key="button.profile"/>
                                        </a>
                                    </p>
                                </li>
                                <li>
                                    <p>
                                        <a href="${pageContext.request.contextPath}/controller?command=logout">
                                            <fmt:message key="button.exit"/>
                                        </a>
                                    <p>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </c:when>
            <c:otherwise>
                <a class="classicButton" href="${pageContext.request.contextPath}/controller?command=login_page">
                    <fmt:message key="button.login"/>
                </a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
