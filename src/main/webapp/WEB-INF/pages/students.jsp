<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <title>
        <fmt:message key="header.students"/>
    </title>
</head>
<body>
<c:import url="parts/head.jsp"/>
<div class="pageContainer">
    <br/>
    <div class="fp">
        <p align="center">
            <fmt:message key="message.${errorMessage}"/>
        </p>
        <form name="students" method="POST"
              action="${pageContext.request.contextPath}/controller?command=enrollee">
            <input type="hidden" name="ctoken" value="${sessionScope.stoken}">
            <p align="center">
                <select name="specialty" size="1" required>
                    <c:forEach items="${specialtyList}" var="specialty" varStatus="counter">
                        <option value="${specialty.specialtyNum}">${specialty.specialtyName}</option>
                    </c:forEach>
                </select>
                <button class="classicButton">
                    <fmt:message key="button.find"/>
                </button>
            </p>
            <table class="buttontable">
                <tr>
                    <td class="username"><fmt:message key="table.username"/></td>
                    <td class="firstName"><fmt:message key="table.firstName"/></td>
                    <td class="lastName"><fmt:message key="table.lastName"/></td>
                    <td class="thirdName"><fmt:message key="table.thirdName"/></td>
                    <td class="enrolled"><fmt:message key="table.isEnrolled"/></td>
                    <td class="block"><fmt:message key="table.blockUser"/> </td>
                    <td class="profile"><fmt:message key="table.profile"/> </td>
                </tr>
                <c:forEach items="${usersList}" var="user" varStatus="counter">
                    <tr>
                        <td class="username">${user.login}</td>
                        <td class="firstName">${user.firstName}</td>
                        <td class="lastName">${user.lastName}</td>
                        <td class="thirdName">${user.thirdName}</td>
                        <td class="enrolled">${user.isEnrolled()}</td>
                        <td class="block">
                            <c:choose>
                                <c:when test="${user.isBlocked()}">
                                    <a class="tableA"
                                       href="${pageContext.request.contextPath}/controller?command=unblock_User&userLogin=${user.login}">
                                        <fmt:message key="button.unblockUser"/>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="tableA"
                                       href="${pageContext.request.contextPath}/controller?command=block_User&userLogin=${user.login}">
                                        <fmt:message key="button.blockUser"/>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td class="profile">
                            <a class="tableA"
                               href="${pageContext.request.contextPath}/controller?command=profile&login=${user.login}">
                                Open profile
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
</div>
</body>
</html>
