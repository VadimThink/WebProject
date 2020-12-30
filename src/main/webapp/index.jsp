<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="authController" method="post">
    <p> Вход:</p>
    <input type="text" name="login" placeholder="Логин"  required pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"/>
    <input type="text" name="password" placeholder="Пароль" required pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"/>
    <input type = "submit" name="submit" value="Вход"/>
</form>
<form action="${pageContext.request.contextPath}/pages/registration.jsp" target="_blank">
    <button>Регистрация</button>
</form>
</body>
</html>
