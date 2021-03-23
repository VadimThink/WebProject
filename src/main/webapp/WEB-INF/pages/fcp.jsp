<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.pagecontent"/>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <title>
        FCP
    </title>
</head>
<body>
<c:import url="parts/head.jsp"/>
<br/>
<div class="line1">
    <div class="box1">
        <h3><img src="${pageContext.request.contextPath}/images/fcp.png" width="30"
                 height="30" > Факультет компьютерного проектирования
        </h3>
        <p>
            Факультет компьютерного проектирования (бывший конструкторско-технологический факультет) с 1973 года является одним из самых инновационных и динамически развивающихся факультетов БГУИР.
        <p>
            В настоящее время в состав факультета входит 5 кафедр, из них 3 выпускающие. Обучается более 2000 студентов, из них 140 - иностранные студенты из Ливии, Ирака, Туркменистана, Узбекистана, Вьетнама, Российской Федерации, Иордании, Республики Казахстан, Йеменской Республики, Ливана, Кубы, Украины.
        </p>
        <p>
            Обучение студентов производится с использованием самого современного оборудования и программного обеспечения на базе созданных на факультете международных, учебных и научно-производственных центров и лабораторий, таких как:
            - Международный учебно-научный центр «Android Software Center», организованный совместно с компанией FORTE Knowledge Иллинойской технологической ассоциации (ITA) с привлечением IT - специалистов из США;
            - учебно-научно-исследовательский центр «INTES», созданный при поддержке зарубежных компаний Schneider Electric (Франция) и CISCO (США), инновационной компанией «INTES»;
            - совместной учебно-научной лаборатории «Встраиваемые мобильные системы», организованной инновационной компанией AXONIM Devices, партнером компаний Analog Devices, Texas Instruments и ST Microelectronics;
            - учебно-научный центр БГУИР, организованный при поддержке компании «Технологии качества» (A1QA),
            - на базе филиалов кафедр факультета на стратегически важных предприятиях Республики Беларусь: ОАО "ИНТЕГРАЛ" - управляющая компания холдинга ИНТЕГРАЛ; РУП "КБТЭМ - ОМО".
        </p>
        <p>
            Все студенты факультета имеют возможность получения сертификатов ведущих зарубежных IT - компаний. Студенты факультета имеют возможность за время обучения пройти военную подготовку.
        </p>
        <p>
            Факультет, опираясь на обширные связи с отечественными и зарубежными предприятиями и фирмами, высококлассными специалистами и современными научными и учебными лабораториями, постоянно совершенствует образовательный процесс, гарантируя выпускникам востребованность на рынке труда и успешную карьеру в жизни. Выпускники всех специальностей факультета являются одними из самых востребованных и высокооплачиваемых, а лучшие из них занимают руководящие должности как в органах государственного управления, так и в сфере IT - бизнеса, промышленности и банковской системе.
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
                <td class="column1"><p align="center">Проектирование и производство программно-управляемых электронных средств </p></td>
                <td class="column1">312</td>
                <td class="column1">259*</td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Моделирование и компьютерное проектирование радиоэлектронных средств </p></td>
                <td class="column1">308</td>
                <td class="column1">187</td>

            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Программируемые мобильные системы</p></td>
                <td class="column1">331*</td>
                <td class="column1">233 </td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Программно-управляемые электронно-оптические системы</p></td>
                <td class="column1">307</td>
                <td class="column1">180</td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Медицинская электроника</p></td>
                <td class="column1">309</td>
                <td class="column1">222</td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Инженерно-психологическое обеспечение информационных технологий</p></td>
                <td class="column1">336*</td>
                <td class="column1">265*</td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Электронные системы безопасности</p></td>
                <td class="column1">314</td>
                <td class="column1">229</td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Информационные системы и технологии(в обеспечении промышленной безопасности)</p></td>
                <td class="column1">329</td>
                <td class="column1">258</td>
            </tr>
            <tr class="row1">
                <td class="column1"><p align="center">Информационные системы и технологии(в бизнес-менеджменте)</p></td>
                <td class="column1">351*</td>
                <td class="column1">287</td>
            </tr>
            </tbody>
        </table>
        <p >
            * - полупроходной
        </p>
    </div>
</div>
<ctg:footerTag/>
</body>
</html>
