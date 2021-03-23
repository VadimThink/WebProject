<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 03.01.2021
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<p>Request from ${pageContext.errorData.requestURI} is failed</p>
<p>Servlet name: ${pageContext.errorData.servletName}</p>
<p>Status code: ${pageContext.errorData.statusCode}</p>
<p>Exception message: ${pageContext.exception.message}</p>
</body>
</html>
