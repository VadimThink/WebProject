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
<div class="pageContainer">
    <c:import url="parts/head.jsp"/>
    <br/>
    <div class="line5">
        <h2 class="another">
            ${userLogin}
        </h2>
        <c:if test="${userInfo.isEnrolled()}">
            <p align="center" class="profileMessage">
                    ${userInfo.firstName} ${userInfo.lastName} <fmt:message
                    key="message.enrolled"/> ${userInfo.specialty.specialtyName}
            </p>
        </c:if>
        <div class="box5">
            <table class="table2">
                <tr class="row2">
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.firstName"/>
                        </font>
                        ${userInfo.firstName}
                    </td>
                    <td class="row2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.lastName"/>
                        </font>
                        ${userInfo.lastName}
                    </td>
                </tr>
                <tr class="row2">
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.thirdName"/>
                        </font>
                        ${userInfo.thirdName}
                    </td>
                </tr>
                <tr class="row2">
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.birthDate"/>
                        </font>
                        ${userInfo.birthday}
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
                        ${userInfo.country}
                    </td>
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.locality"/>
                        </font>
                        ${userInfo.locality}
                    </td>
                </tr>
                <tr class="row2">
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.address"/>
                        </font>
                        ${userInfo.address}
                    </td>
                </tr>
                <tr class="row2">
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.phone"/>
                        </font>
                        ${userInfo.phone}
                    </td>
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.email"/>
                        </font>
                        ${userInfo.email}
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
                        ${userInfo.specialty.faculty}
                    </td>
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.specialty"/>
                        </font>
                        ${userInfo.specialty.specialtyName}
                    </td>
                </tr>
                <tr class="row2">
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.GPA"/>
                        </font>
                        ${userInfo.gpa}
                    </td>
                </tr>
                <tr class="row2">
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.languageScore"/>
                        </font>
                        ${userInfo.languageScore}
                    </td>
                </tr>
                <tr class="row2">
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.mathScore"/>
                        </font>
                        ${userInfo.mathScore}
                    </td>
                </tr>
                <tr class="row2">
                    <td class="column2">
                        <font size="4" face="Gabriola" color="#616159" class="forheight">
                            <fmt:message key="form.thirdScore"/>
                        </font>
                        ${userInfo.thirdScore}
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <c:if test="${!userInfo.isEnrolled()}">
        <p align="center">
            <a class="classicButton"
               href="${pageContext.request.contextPath}/controller?command=edit_profile&login=${userLogin}">
                <fmt:message key="button.edit"/>
            </a>
        </p>
    </c:if>
</div>
</body>
</html>
