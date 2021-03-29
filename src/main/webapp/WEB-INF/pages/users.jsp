<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <title>
        <fmt:message key="header.users"/>
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
        <c:if test="${firstId > 0}">
            <c:choose>
                <c:when test="${((firstId - 6) > 0) && (firstId < usersNumber)}">
                    <a class="back"
                       href="${pageContext.request.contextPath}/controller?command=users_pagination&lastId=${firstId-6}">
                        back
                    </a>
                </c:when>
                <c:otherwise>
                    <a class="back"
                       href="${pageContext.request.contextPath}/controller?command=users_list">
                        back
                    </a>
                </c:otherwise>
            </c:choose>
        </c:if>
        <table class="buttontable">
            <tr style="background: white">
                <td class="username"><fmt:message key="table.username"/></td>
                <td class="status"><fmt:message key="table.status"/></td>
                <td class="role"><fmt:message key="table.role"/></td>
                <td class="block"><fmt:message key="table.blockUser"/></td>
                <td class="activate"><fmt:message key="table.activate"/></td>
                <td class="makeadmin"><fmt:message key="table.makeadmin"/></td>
                <td class="profile"><fmt:message key="table.profile"/></td>
            </tr>
            <c:forEach items="${usersList}" var="user" varStatus="counter">
                <tr>
                    <td class="username">${user.login}</td>
                    <td class="status">${user.status}</td>
                    <td class="role">${user.role}</td>
                    <td class="block">
                        <c:choose>
                            <c:when test="${user.isBlocked()}">
                                <a class="tableA"
                                   href="${pageContext.request.contextPath}/controller?command=unblock_User&userLogin=${user.login}">
                                    <fmt:message key="button.unblockUser"/>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${user.isUserRole()}">
                                    <a class="tableA"
                                       href="${pageContext.request.contextPath}/controller?command=block_User&userLogin=${user.login}">
                                        <fmt:message key="button.blockUser"/>
                                    </a>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td class="activate">
                        <c:if test="${user.isInactive()}">
                            <a class="tableA"
                               href="${pageContext.request.contextPath}/controller?command=activate_User&userLogin=${user.login}">
                                <fmt:message key="button.activateUser"/>
                            </a>
                        </c:if>
                    </td>
                    <td class="makeadmin">
                        <c:if test="${user.isUserRole()}">
                            <a class="tableA"
                               href="${pageContext.request.contextPath}/controller?command=make_user_admin&userLogin=${user.login}">
                                <fmt:message key="button.makeUserAdmin"/>
                            </a>
                        </c:if>
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
        <br/>
        <c:if test="${lastId < usersNumber}">
            <a class="next"
               href="${pageContext.request.contextPath}/controller?command=users_pagination&lastId=${lastId}">
                forward
            </a>
        </c:if>
    </div>
</div>
</body>
</html>
