<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <title>
        <fmt:message key="header.login"/>
    </title>
</head>
<body>
<c:import url="parts/head.jsp"/>
<div class="pageContainer">
<div class="fp" align="center">
    <form name="loginForm" method="POST" action="${pageContext.request.contextPath}/controller?command=login">
        <input type="hidden" name="ctoken" value="${sessionScope.stoken}">
        <h2 align="center">
            <fmt:message key="header.enterYourAccount"/>
        </h2>
        <p align="center">
            <fmt:message key="input.header.login"/>
            <input type="text" name="login" placeholder="Login" required
                   pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"/>
        </p>
        <p align="center">
            <fmt:message key="input.header.password"/>
            <input type="password" name="password" placeholder="Password" required
                   pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"/>
        </p>
        <p align="center">
            <button class="classicButton" type="submit">
                <fmt:message key="button.login"/>
            </button>
        </p>
        <h2 align="center">
            <fmt:message key="message.${errorMessage}"/>
        </h2>
    </form>
    <h2 align="center">
        <fmt:message key="header.orCreateNew"/>
    </h2>
    <p align="center">
        <a class="classicButton" href="${pageContext.request.contextPath}/controller?command=sign_up_page">
            <fmt:message key="button.registration"/>
        </a>
    </p>
</div>
</div>
</body>
</html>
