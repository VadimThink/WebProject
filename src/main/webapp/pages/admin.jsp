<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body id="pagesBody">
<c:import url="parts/head.jsp"/>
<h1 align="center">
    <font size="8" color="#0033CC" face="Gabriola">
        <fmt:message key="header.loginAsAdmin"/>
    </font>
</h1>
<div>
    <h2 align="center">
        <fmt:message key="header.menu"/>
    </h2>
    <p align="center">
        <a id="pagesA" href="Пользователи.html">
            <fmt:message key="button.users"/>
        </a>
    </p>
    <p align="center">
        <a id="pagesButton" href="Завершение.html">
            <fmt:message key="button.finishCampaign"/>
        </a>
    </p>
</div>
</body>
</html>
