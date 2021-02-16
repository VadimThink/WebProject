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
    <fmt:message key="header.welcome"/>
</h2>
<div>
    <h2 align="center">
        <fmt:message key="header.menu"/>
    </h2>
    <p align="center">
        <a class="buttonB" href="${pageContext.request.contextPath}/controller?command=form_page">
            <fmt:message key="button.fillForm"/>
        </a>
    </p>
    <p align="center">
        <a class="buttonB" href="Баллы.html">
            <fmt:message key="button.passingPoints"/>
        </a>
    </p>
</div>
</body>
</html>
