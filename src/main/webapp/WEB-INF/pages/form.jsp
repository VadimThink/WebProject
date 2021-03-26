<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body >
<div class="pageContainer">
<c:import url="parts/head.jsp"/>
<h1 align="center">
    <font size="8" color="#0033CC" face="Gabriola">
        <fmt:message key="header.fillTheForm"/>
    </font>
</h1>
<form name="dataForm" method="POST" action="${pageContext.request.contextPath}/controller?command=send_form&login=${userLogin}">
    <input type="hidden" name="ctoken" value="${sessionScope.stoken}">
<h2 align="center"><font size="8" color="#FF0000" face="Gabriola">
    <fmt:message key="message.${errorMessage}"/></font>
</h2>
<br>
<p align="center">
    <fmt:message key="form.firstName"/>
    <input type="text" name="firstName" value="${userInfo.firstName}"  required>
</p>
<p align="center">
    <fmt:message key="form.lastName"/>
    <input type="text" name="secondName" value="${userInfo.lastName}" required>
</p>
<p align="center">
    <fmt:message key="form.thirdName"/>
    <input type="text" name="thirdName" value="${userInfo.thirdName}">
</p>
<p align="center">
    <fmt:message key="form.birthDate"/>
    <input type="date" name="birthday" required value="${userInfo.birthday}" max="${currentDate}">
</p>
<p align="center">
    <fmt:message key="form.country"/>
    <input type="text" name="country" required value="${userInfo.country}">
</p>
<p align="center">
    <fmt:message key="form.locality"/>
    <input type="text" name="locality" required value="${userInfo.locality}">
</p>
<p align="center">
    <fmt:message key="form.address"/>
    <input type="text" name="address" value="${userInfo.address}" placeholder="Улица, дом, корпус, квартира" required>
</p>
<p align="center">
    <fmt:message key="form.phone"/>
    <input type="tel" name="phone" value="${userInfo.phone}" placeholder="+375331111111" required>
</p>
<p align="center">
    <fmt:message key="form.email"/>
    <input type="email" name="email" value="${userInfo.email}" required>
</p>
<p align="center">
    <fmt:message key="form.specialty"/>
</p>
<p align="center">
    <select name="specialty" size="1" required>
        <c:forEach items="${specialtyList}" var="specialty" varStatus="counter">
            <option value="${specialty.specialtyNum}">${specialty.specialtyName}</option>
        </c:forEach>
    </select>
</p>
<p align="center">
    <fmt:message key="form.GPA"/>
    <input type="number" name="GPA" max="100" min="0" value="${userInfo.gpa}" required>
</p>
<p align="center">
    <fmt:message key="form.languageScore"/>
    <input type="number" name="languageScore" max="100" min="0" value="${userInfo.languageScore}" required>
</p>
<p align="center">
    <fmt:message key="form.mathScore"/>
    <input type="number" name="mathScore" max="100" min="0" value="${userInfo.mathScore}" required>
</p>
<p align="center">
    <fmt:message key="form.thirdScore"/>
    <input type="number" name="thirdScore" max="100" min="0" value="${userInfo.thirdScore}" required>
</p>
<p align="center">
    <button class="classicButton">
        <fmt:message key="button.send"/>
    </button>
</p>
</form>
</div>
</body>
</html>
