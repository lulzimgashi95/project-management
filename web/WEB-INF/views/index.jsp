<%--
  Created by IntelliJ IDEA.
  User: LulzimG
  Date: 17/12/16
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Project Management - Home</title>
    <jsp:include page="header.jsp"/>
</head>
<body>

<div class="ui statistics">
    <div class="statistic">
        <div class="value">
            ${statistic.projects}
        </div>
        <div class="label">
            Projects
        </div>
    </div>
    <div class="statistic">
        <div class="value">
            ${statistic.members}
        </div>
        <div class="label">
            Members
        </div>
    </div>
    <div class="statistic">
        <div class="value">
            ${statistic.sponsors}
        </div>
        <div class="label">
            Sponsors
        </div>
    </div>
    <div class="statistic">
        <div class="value">
            ${statistic.notes}
        </div>
        <div class="label">
            Notes
        </div>
    </div>
</div>


<br>
<br>

<div class="label" style="font-size: large;color: orangered">
    ${message}
</div>
</body>
</html>
