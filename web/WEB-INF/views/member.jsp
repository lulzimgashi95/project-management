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
<table class="ui selectable green table">
    <thead>
    <tr>
        <th class="one wide"></th>
        <th class="center aligned">First Name</th>
        <th class="center aligned">Last Name</th>
        <th class="center aligned">Start Date</th>
        <th class="center aligned">Position</th>
        <th class="center aligned">Project</th>
        <th class="center aligned"></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><img src="data:image/jpeg;base64,${member.image}" alt="..." width="75" height="75"></td>
        <td class="center aligned">${member.firstName}</td>
        <td class="center aligned">${member.lastName}</td>
        <td class="center aligned">${member.startDate}</td>
        <td class="center aligned">${member.position}</td>
        <td class="selectable center aligned"><a
                href="<spring:url value="/project/${member.projectId}"/>">${member.projectName}</a></td>
        <td class="selectable positive center aligned">
            <a class="item" href="<spring:url value="/member/add"/>">Edit Member</a></td>
    </tr>
    </tbody>
</table>

</body>
</html>
