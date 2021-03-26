<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <title>
        FCSN
    </title>
</head>
<body>
<div class="pageContainer">
<c:import url="parts/head.jsp"/>
<br/>
<div class="line1">
    <div class="box1">
        <h3><img src="${pageContext.request.contextPath}/images/fcsn.png" width="30"
                 height="30"> Факультет Компьютерных систем и сетей
        </h3>
        <p>Факультет компьютерных систем и сетей является одним из ведущих факультетов в Республике Беларусь по
            подготовке ИТ-специалистов.
        </p>
        <p>
            На сегодняшний день на факультете обучаются около 2000 студентов по четырем специальностям - «Вычислительные
            машины, системы и сети», «Информатика и технологии программирования», «Программное обеспечение
            информационных технологий»,«Электронные вычислительные средства».
        </p>
        <p>
            В составе ФКСиС входят 7 кафедр, из них выпускающие - "Электронных вычислительных машин", "Информатики",
            "Программного обеспечения информационных технологий" и "Электронных вычислительных средств", а также кафедры
            "Высшей математики", "Физики", "Философии".
        </p>
        <p>
            На факультете работают более 200 преподавателей, из них 14 докторов, профессоров, около 90 кандидатов наук,
            доцентов.
        </p>
        <p>
            Факультет тесно сотрудничает с ведущими в отрасли ИТ-компаниями - IBM, Microsoft, SAP, National Instruments,
            CISCO, NVidia, EMC, Texas Instruments, Oracle, Яндекс, 1C.
        </p>
        <p>
            На факультете функционируют 13 совместных учебно-научно-исследовательских лабораторий, созданные совместно с
            компаниями IBA, EPAM, Itransition, EffectiveSoft, ScienceSoft, Системные технологии, Exadel, Численные
            методы, NT Lab, МиСофт.
        </p>
        <p>
            Выпускники факультета успешно работают программистами, бизнес-аналитиками, системными архитекторами,
            руководителями проектов, специалистами по тестированию ПО как в белорусских компаниях-резидентах Парка
            высоких технологий, государственных организациях, так и в хорошо известных зарубежных компаниях (Microsoft,
            Google).
        </p>
        <p>
            По результатам проведенного опроса компаний-резидентов ПВТ ФКСиС занимает первое место в TOP-10 факультетов
            вузов Беларуси, выпускники которых востребованы в Парке высоких технологий.
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
                <td class="column1"><p align="center">Проходной балл на платную форму обучения</p></td>
            </tr>
            <tbody>
            <tr class="row1">
                <td class="column1"><p align="center">Вычислительные машины, системы и сети </p></td>
                <td class="column1">327</td>
                <td class="column1">156</td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Программное обеспечение информационных технологий</p></td>
                <td class="column1">358*</td>
                <td class="column1">310</td>

            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Информатика и технологии программирования</p></td>
                <td class="column1">352*</td>
                <td class="column1">287</td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Электронные вычислительные средства</p></td>
                <td class="column1">318</td>
                <td class="column1">209</td>
            </tr>
            </tbody>
        </table>
        <p>
            * - полупроходной
        </p>
    </div>
</div>
</div>
</body>
</html>
