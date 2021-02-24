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
<body>
<c:import url="parts/head.jsp"/>
<div class="users" align="center">
    <p align="center">
        <fmt:message key="message.${errorMessage}"/>
    </p>
    <c:if test="${firstId > 0}">
        <c:choose>
            <c:when test="${((firstId - 6) > 0) && (firstId < usersNumber)}">
                <a class="buttonB" href="${pageContext.request.contextPath}/controller?command=users_pagination&lastId=${firstId-6}">
                    back
                </a>
            </c:when>
            <c:otherwise>
                <a class="buttonB" href="${pageContext.request.contextPath}/controller?command=users_list">
                    back
                </a>
            </c:otherwise>
        </c:choose>
    </c:if>
    <c:forEach items="${usersList}" var="user" varStatus="counter">
        <p>${user.login} ${user.status} ${user.role}
            <c:choose>
                <c:when test="${user.isBlocked()}">
                    <a class="buttonB" href="${pageContext.request.contextPath}/controller?command=unblock_User&userLogin=${user.login}">
                        <fmt:message key="button.unblockUser"/>
                    </a>
                </c:when>
                <c:otherwise>
                    <a class="buttonB" href="${pageContext.request.contextPath}/controller?command=block_User&userLogin=${user.login}">
                        <fmt:message key="button.blockUser"/>
                    </a>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${user.isUnactive()}">
                    <a class="buttonB" href="${pageContext.request.contextPath}/controller?command=activate_User&userLogin=${user.login}">
                        <fmt:message key="button.activateUser"/>
                    </a>
                </c:when>
                <c:otherwise></c:otherwise>
            </c:choose>
        </p>
    </c:forEach>
    <c:if test="${lastId < usersNumber}">
        <a class="buttonB" href="${pageContext.request.contextPath}/controller?command=users_pagination&lastId=${lastId}">
            forward
        </a>
    </c:if>
</div>
</body>
</html>
