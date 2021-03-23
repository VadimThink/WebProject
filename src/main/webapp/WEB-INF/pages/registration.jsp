<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <title>Регистрация</title>
</head>
<body>
<c:import url="parts/head.jsp"/>
<div class="fp" align="center">
    <form name="signUpForm" action="${pageContext.request.contextPath}/controller?command=register" method="post">
        <h1 align="center">
            <font size="8" color="#0033CC" face="Gabriola">
                <fmt:message key="header.registration"/>
            </font>
        </h1>
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
            <fmt:message key="input.header.repeatPassword"/>
            <input type="password" name="repeatPassword" placeholder="Repeat password" required
                   pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"/>
        </p>
        <p>
            <button class="classicButton">
                <fmt:message key="button.registration"/>
            </button>
        </p>
        <p>
            <fmt:message key="message.${errorMessage}"/>
        </p>
    </form>
</div>
</body>
</html>
