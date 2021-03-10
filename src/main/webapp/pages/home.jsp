<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <title>
        Home
    </title>
</head>
<body>
<c:import url="parts/head.jsp"/>
<br/>
<div class="line1">
    <div class="box">
        <h3><img src="${pageContext.request.contextPath}/WEB-INF/pages/images/fic.png" width="30"
                 height="30"> Факультет Инфокоммуникаций
        </h3>
        <p> К настоящему времени сформировалась целая отрасль инфокоммуникаций, связанная с передачей информации,
            которая объединяет информационные и телекоммуникационные технологии и ориентирована на расширение сетей связи
            <a href="${pageContext.request.contextPath}/controller?command=fic_page">...Подробнее
            </a>
        </p>
    </div>
    <div class="box">
        <h3><img src="${pageContext.request.contextPath}/WEB-INF/pages/images/fcp.png" width="30"
                 height="30" > Факультет компьютерного проектирования
        </h3>
        <p> Факультет, опираясь на обширные связи с отечественными и зарубежными предприятиями и фирмами, высококлассными
            специалистами и современными научными и учебными лабораториями, постоянно совершенствует образовательный процесс
            <a href="${pageContext.request.contextPath}/controller?command=fcp_page">...Подробнее
            </a>
        </p>
    </div>
</div>
<br>
<div class="line2">
    <div class="box">
        <h3> <img src="${pageContext.request.contextPath}/WEB-INF/pages/images/fre.png" width="30"
                  height="30" > Факультет радиоэлектроники
        </h3>
        <p> Обучение на факультете сочетает фундаментальную подготовку по математике, физике, химии, программированию с углубленным изучением основ современной радиотехники
            и электроники, микро- и наноэлектроники, компьютерных методов обработки информации
            <a href="${pageContext.request.contextPath}/controller?command=fre_page">...Подробнее
            </a>
        </p>
    </div>
    <div class="box">
        <h3> <img src="${pageContext.request.contextPath}/WEB-INF/pages/images/fee.png" width="30"
                  height="30" > Инженерно-экономический факультет
        </h3>
        <p> Инженерно-экономический факультет готовит специалистов, обладающих интегрированными знаниями в области экономики и современных информационных технологий,
            что выгодно отличает подготовленных на нашем факультете специалистов от выпускников
            <a href="${pageContext.request.contextPath}/controller?command=fee_page">...Подробнее
            </a>

        </p>
    </div>
</div>
<br>
<div class="line3">
    <div class="box">
        <h3> <img src="${pageContext.request.contextPath}/WEB-INF/pages/images/fcsn.png" width="30"
                  height="30" > Факультет компьютерных систем и сетей
        </h3>
        <p> На сегодняшний день на факультете обучаются около 2000 студентов по четырем специальностям - «Вычислительные машины,
            системы и сети», «Информатика и технологии программирования», «Программное обеспечение информационных технологий»,«Электронные вычислительные средства».
            <a href="${pageContext.request.contextPath}/controller?command=fcsn_page">...Подробнее
            </a>
        </p>
    </div>
    <div class="box">
        <h3><img src="${pageContext.request.contextPath}/WEB-INF/pages/images/fitc.png" width="60"
                 height="30" > Факультет информационных технологий и управления
        </h3>
        <p> Сегодня ФИТиУ - это крупный учебный и научный центр, где обучается более 1900 студентов I и II ступени
            высшего образования, представляющих 20 стран мира, а обучение ведется в том числе и на английском языке.
            <a href="${pageContext.request.contextPath}/controller?command=fitc_page">...Подробнее
            </a>
        </p>
    </div>
</div>
</body>
</html>
