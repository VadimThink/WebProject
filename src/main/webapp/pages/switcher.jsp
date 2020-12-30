<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 30.12.2020
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать!</title>
</head>
<body>
<form action="logicController" method="post">
    <p> Выключатель света лампочки:</p>
    <p> Чтобы свет был, введите "Включен", чтобы света не было, введите "Выключен"</p>
    <input type="text" name="lightCondition" placeholder="Вместо этого текста введите" required pattern="^[А-Яа-я]+$"/>
    <input type="submit" name="submit" value="Тык сюда"/>
</form>
</body>
</html>
