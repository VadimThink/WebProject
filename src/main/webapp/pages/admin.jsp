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
<c:import url="parts/head.jsp"/>
<h2 align="center">
    <fmt:message key="header.loginAsAdmin"/>
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
        <a class="classicButton" href="Завершение.html">
            <fmt:message key="button.finishCampaign"/>
        </a>
    </p>
</div>
</body>
</html>
