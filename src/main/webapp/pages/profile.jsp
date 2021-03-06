<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <title>
        ${userLogin}
    </title>
</head>
<body>
<c:import url="parts/head.jsp"/>
<br/>
<div class="line5">
    <h2 class="another">
        ${userLogin}
    </h2>
    <div class="box5">
        <table class="table2">
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.firstName"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is"> ${userInfo.firstName}
                    </a>
                </td>
                <td class="row2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.secondName"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is"> ${userInfo.lastName}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.thirdName"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.thirdName}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.birthDate"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.birthday}
                    </a>
                </td>
            </tr>
        </table>
    </div>
    <div class="box5">
        <table class="2">
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.country"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.country}
                    </a>
                </td>
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.locality"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.locality}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.address"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.address}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.phone"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.phone}
                    </a>
                </td>
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.email"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.email}
                    </a>
                </td>
            </tr>
        </table>
    </div>
    <div class="box5">
        <table class="table2">
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.faculty"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.specialty.facultyNum}<%--todo изменить на название--%>
                    </a>
                </td>
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.specialty"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.specialty.specialtyName}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.GPA"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.gpa}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.languageScore"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.languageScore}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.mathScore"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.mathScore}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        <fmt:message key="form.thirdScore"/>
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.thirdScore}
                    </a>
                </td>
            </tr>
        </table>
    </div>
</div>
</div>
</body>
</html>
