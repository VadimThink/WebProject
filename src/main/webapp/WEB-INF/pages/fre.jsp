<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <title>
        FRE
    </title>
</head>
<body>
<div class="pageContainer">
<c:import url="parts/head.jsp"/>
<br/>
<div class="line1">
    <div class="box1">
        <h3> <img src="${pageContext.request.contextPath}/images/fre.png" width="30"
                  height="30" > Факультет радиоэлектроники
        </h3>
        <p> Факультет образован как радиотехнический в 1964 году (в год основания МРТИ) и его путь развития неотрывно связан с 50-летней историей МРТИ - БГУИР.
        </p>
        <p>
            Нынешнее название факультет радиотехники и электроники получил в 1980 году.
        </p>
        <p>
            XXI век назван веком радиоинформационных технологий. Современная радиоинформационная система в понимании специалиста предназначена для извлечения, формирования, приема, передачи и обработки информации. Для решения названных задач необходимы специалисты, всесторонне подготовленные для работы с современными микро - и наноэлектронными устройствами, способные применить свои знания и талант для создания принципиально новых поколений информационных систем.
        </p>
        <p>
            Специалистов, готовых после окончания ВУЗа решать указанные задачи, готовит факультет радиотехники и электроники. В настоящий момент он представляет собой мощный учебно-научно-инженерный центр, объединяющий в своем составе 1123 студента, обучение которых осуществляют 13 докторов наук, профессоров, 45 кандидатов наук, доцентов.
        </p>
        <p>
            Отличительной особенностью выпускника факультета радиотехники и электроники является овладение им не только методами создания радиоинформационных систем (проектирование на базе современных технологий), но также и умение управлять, эксплуатировать и налаживать системы такого класса.

        </p>
        <br>
        <br>
        <table class="table1">
            <thead>
            <tr class="row1">
                <th colspan="3" class="head1"><p align="center">Проходные баллы в 2020 году</p></th>
            </tr>
            </thead>
            <tr class="row1">
                <td class="column1"><p align="center">Специальность</p></td>
                <td class="column1"><p align="center">Проходные баллы на бюджетную форму обучения</p></td>
                <td class="column1"><p align="center">Проходной балл на платную форму обучения</p> </td>
            </tr>
            <tbody>
            <tr class="row1">
                <td class="column1"><p align="center">Микро- и наноэлектронные технологии и системы </p></td>
                <td class="column1">281</td>
                <td class="column1">187*</td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Нанотехнологии и наноматериалы в электронике</p></td>
                <td class="column1">260</td>
                <td class="column1">176</td>

            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Радиотехника (программируемые радиоэлектронные средства)</p></td>
                <td class="column1">271</td>
                <td class="column1">210 </td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Радиоэлектронная защита информации</p></td>
                <td class="column1">282</td>
                <td class="column1">217</td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Электронные и информационно-управляющие системы физических установок</p></td>
                <td class="column1">235</td>
                <td class="column1">**</td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Радиоинформатика</p></td>
                <td class="column1">248</td>
                <td class="column1">204</td>
            </tr>
            </tbody>
        </table>
        <p >
            * - полупроходной;
            ** - приём на платную форму обучения не осуществляется
        </p>
    </div>
</div>
</div>
</body>
</html>
