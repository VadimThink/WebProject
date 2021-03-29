<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>
<html>
<head>
    <title>ERROR</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="pageContainer">
    <c:import url="/WEB-INF/pages/parts/head.jsp"/>
    <h2 align="center">Request from ${pageContext.errorData.requestURI} is failed</h2>
    <h2 align="center">Servlet name: ${pageContext.errorData.servletName}</h2>
    <h2 align="center">Status code: ${pageContext.errorData.statusCode}</h2>
    <h2 align="center">Exception message: ${pageContext.exception.message}</h2>
</div>
</body>
</html>
