<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="parts/head.jsp"/>
<form name=mainForm action="controller" method="post">
    <p>${lol}</p>
    <input type="hidden" name="command" value="logout"/>
</form>
</body>
</html>
