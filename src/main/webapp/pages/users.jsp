<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <title>
        <fmt:message key="header.login"/>
    </title>
</head>
<body id="pagesBody">
<c:import url="parts/head.jsp"/>
<div align="center">
    <c:forEach items="${usersList}" var="user" varStatus="counter">
        <p>
            ${user.login} ${user.status} ${user.role}
        </p>
    </c:forEach>
</div>
</body>
</html>
