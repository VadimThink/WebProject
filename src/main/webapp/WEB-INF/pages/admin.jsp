<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="pageContainer">
<c:import url="parts/head.jsp"/>
<h2 align="center">
    <fmt:message key="header.loginAsAdmin"/>
</h2>
<h2 align="center">
    <fmt:message key="message.${errorMessage}"/>
</h2>
<div class="fp">
    <h2 align="center">
        <fmt:message key="header.menu"/>
    </h2>
    <p align="center">
        <a class="classicButton" href="${pageContext.request.contextPath}/controller?command=users_list">
            <fmt:message key="button.users"/>
        </a>
    </p>
    <p align="center">
        <a class="classicButton" href="${pageContext.request.contextPath}/controller?command=enrollee&specialty=0">
            <fmt:message key="button.enrollee"/>
        </a>
    </p>
    <p align="center">
        <a class="classicButton" href="${pageContext.request.contextPath}/controller?command=finish_campaign">
            <fmt:message key="button.finishCampaign"/>
        </a>
    </p>
</div>
</div>
</body>
</html>
