<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="en_US" scope="session" />
<fmt:setBundle basename="resources.pagecontent"/>

<html><head><title>Login</title></head>
<body>
<form name="loginForm" method="POST" action="controller">
    <fmt:message key ="header.login"/><br/>
    <input type="text" name="login" placeholder= "Логин"  required pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"/>
    <br/>Password:<br/>
    <input type="text" name="password" placeholder="Пароль" required pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"/>
    <br/>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
    <input type = "submit" name="command" value="login"/>
</form>
<form action="${pageContext.request.contextPath}/pages/registration.jsp" target="_blank">
    <button>Регистрация</button>
</form><hr/></body></html>
