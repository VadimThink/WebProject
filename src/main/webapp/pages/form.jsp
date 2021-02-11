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
<body id=pagesBody>
<c:import url="parts/head.jsp"/>
<h1 align="center">
    <font size="8" color="#0033CC" face="Gabriola">
        <fmt:message key="header.fillTheForm"/>
    </font>
</h1>
<form name="dataForm" method="POST" action="${pageContext.request.contextPath}/controller?command=send_form">
<h2 align="center"><font size="8" color="#FF0000" face="Gabriola">
    <fmt:message key="message.${errorMessage}"/></font>
</h2>
<br>
<p align="center">
    <fmt:message key="input.header.firstName"/>
    <input type="text" name="firstName" required>
</p>
<p align="center">
    <fmt:message key="input.header.secondName"/>
    <input type="text" name="secondName" required>
</p>
<p align="center">
    <fmt:message key="input.header.thirdName"/>
    <input type="text" name="thirdName" value="" required>
</p>
<p align="center">
    <fmt:message key="input.header.birthDate"/>
    <input type="date" name="birthday" required>
</p>
<p align="center">
    <fmt:message key="input.header.country"/>
    <input type="text" name="country" required>
</p>
<p align="center">
    <fmt:message key="input.header.locality"/>
    <input type="text" name="locality" required>
</p>
<p align="center">
    <fmt:message key="input.header.address"/>
    <input type="text" name="address" placeholder="Улица, дом, корпус, квартира" required>
</p>
<p align="center">
    <fmt:message key="input.header.phone"/>
    <input type="tel" name="phone" placeholder="+375331111111" required>
</p>
<p align="center">
    <fmt:message key="input.header.email"/>
    <input type="email" name="email" required>
</p>
<p align="center">
    <fmt:message key="input.header.faculty"/>
</p>
<p align="center">
    <select name="faculty" size="1" required>
        <option value="1">ФКСИС
        </option>
        <option value="2">ФИТУ
        </option>
        <option value="3">ФИК
        </option>
        <option value="4">ФРЭ
        </option>
        <option value="5">ИЭФ
        </option>
        <option value="6">ФКП
        </option>
    </select>
</p>
<p align="center">
    <fmt:message key="input.header.specialty"/>
</p>
<p align="center">
    <select name="specialty" size="1" required>
        <option value="0">
            Не выбрано
        </option>
    </select>
</p>
<p align="center">
    <fmt:message key="input.header.GPA"/>
    <input type="number" name="GPA" max="100" min="0" placeholder="98" required>
</p>
<p align="center">
    <fmt:message key="input.header.languageScore"/>
    <input type="number" name="languageScore" max="100" min="0" required>
</p>
<p align="center">
    <fmt:message key="input.header.mathScore"/>
    <input type="number" name="mathScore" max="100" min="0" required>
</p>
<p align="center">
    <fmt:message key="input.header.thirdScore"/>
    <input type="number" name="thirdScore" max="100" min="0" required>
</p>
<p align="center">
    <button id=pagesButton>
        <fmt:message key="button.send"/>
    </button>>
</p>
</form>
</body>
</html>
