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
        Ваш профиль:
    </h2>
    <div class="box5">
        <table class="table2">
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Имя:
                    </font>
                    <a href="redaction" title="Редактировать" class="is"> ${userInfo.firstName}
                    </a>
                </td>
                <td class="row2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Фамилия:
                    </font>
                    <a href="redaction" title="Редактировать" class="is"> ${userInfo.lastName}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Отчество:
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.thirdName}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Дата рождения:
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
                        Страна:
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.country}
                    </a>
                </td>
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Населённый пункт:
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.locality}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Адрес:
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.address}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Телефон:
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.phone}
                    </a>
                </td>
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Электронная почта:
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
                        Факультет:
                    </font>
                    <a href="redaction" title="Редактировать" class="is">КСиС
                    </a>
                </td>
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Специальность:
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.specialtyNum}<%--todo заменить номер на строку--%>
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Средний балл аттестата:
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.gpa}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Балл ЦТ по русскому(белорускому) языку:
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.languageScore}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Балл ЦТ по математике:
                    </font>
                    <a href="redaction" title="Редактировать" class="is">${userInfo.mathScore}
                    </a>
                </td>
            </tr>
            <tr class="row2">
                <td class="column2">
                    <font size="4" face="Gabriola" color="#616159" class="forheight">
                        Балл ЦТ по физике (иностранному языку):
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
