<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
<header>
    <p id="Site" align="left">
        <a href="${pageContext.request.contextPath}/controller?command=home_page">Абитуриент</a><%-- TODO ПОМЕНЯТЬ НА КАРТИНКУ --%>
    </p>
    <a id="notification">
        <img src="${pageContext.request.contextPath}/pages/parts/pic/bell.png" width="50" height="50"/>
    </a>
    <a id="russianLanguage" href="${pageContext.request.contextPath}/controller?command=change_language&language=ru">
        <img src="${pageContext.request.contextPath}/pages/parts/pic/rus.png" width="50" height="25"/>
    </a>
    <a id="englishLanguage" href="${pageContext.request.contextPath}/controller?command=change_language&language=en">
        <img src="${pageContext.request.contextPath}/pages/parts/pic/eng.png" width="50" height="25"/>
    </a>
    <c:choose>
        <c:when test="${!empty sessionScope.user}">
            <ul id="navbar">
                <li>${user} <img id="down" src="${pageContext.request.contextPath}/pages/parts/pic/down.png" width="20"
                                 height="20">
                    <ul>
                        <a class="selectButton" href="${pageContext.request.contextPath}/controller?command=logout">
                            <fmt:message key="button.exit"/>
                        </a>
                    </ul>
                </li>
            </ul>
        </c:when>
        <c:otherwise>
            <ul id="navbar">
                <li>
                    <a class="classicButton" href="${pageContext.request.contextPath}/controller?command=login_page">
                        <fmt:message key="button.login"/>
                    </a>
                </li>
            </ul>
        </c:otherwise>
    </c:choose>
</header>
</body>
</html>
