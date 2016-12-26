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
<spring:url value="/project/add" var="url"/>
<forms:form class="ui form" action="${url}" method="post" style="width: 50%;" modelAttribute="project">
    <div class="field">
        <label>Name</label>
        <forms:input path="name"/>
        <forms:errors cssStyle="color: orangered" path="name"/>
    </div>

    <div class="field" style="margin-top: 40px">
        <label>Description</label>
        <forms:input path="description"/>
        <forms:errors cssStyle="color: orangered" path="description"/>
    </div>

    <div class="field" style="margin-top: 40px">
        <label>Start Date</label>
        <forms:input path="startDate"/>
    </div>

    <div class="field" style="margin-top: 40px">
        <label>Dead Line</label>
        <forms:input path="deadLine"/>
    </div>

    <button class="ui button" type="submit">Submit</button>
</forms:form>

</body>
</html>
