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

<a style="float: left" href="<spring:url value="/project/add"/>">
    <button class="ui green button">
        Add Project
    </button>
</a>


<br/>
<br/>

<table class="ui selectable green table">
    <thead>
    <tr>
        <th class="center aligned">Name</th>
        <th class="center aligned">Description</th>
        <th class="center aligned">Start Date</th>
        <th class="center aligned">Dead Line</th>
        <th class="center aligned"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${projects}" var="project">
        <tr>
            <td class="selectable center aligned"><a
                    href="<spring:url value="/project/${project.id}"/>">${project.name}</a></td>
            <td class="center aligned">${project.description}</td>
            <td class="center aligned">${project.startDate}</td>
            <td class="center aligned">${project.deadLine}</td>
            <td class="center aligned">
                <a href="<spring:url value="/project/remove/${project.id}"/>"> <i class="minus orange square icon"></i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
