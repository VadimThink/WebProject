<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 31.12.2020
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/regController" method="post">
    <p> Форма регистрации:</p>
    <input type="text" name="login" placeholder="Логин"  required pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"/>
    <input type="text" name="password" placeholder="Пароль" required pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"/>
    <input type = "submit" name="submit" value="Зарегистрировать"/>
</form>
</body>
</html>
