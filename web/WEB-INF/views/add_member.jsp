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
<spring:url value="/member/add" var="url"/>
<forms:form class="ui form" action="${url}" method="post" style="width: 50%;" modelAttribute="member"
            enctype="multipart/form-data">
    <div class="field" style="margin-top: 40px">
        <label>First Name</label>
        <forms:input path="firstName"/>
        <forms:errors cssStyle="color: orangered" path="firstName"/>
    </div>

    <div class="field" style="margin-top: 40px">
        <label>Last Name</label>
        <forms:input path="lastName"/>
        <forms:errors cssStyle="color: orangered" path="lastName"/>
    </div>

    <div class="field" style="margin-top: 40px">
        <label>Start Date</label>
        <forms:input path="startDate"/>
    </div>

    <div class="field" style="margin-top: 40px">
        <label>Position</label>
        <forms:input path="position"/>
        <forms:errors cssStyle="color: orangered" path="position"/>
    </div>

    <div class="field" style="margin-top: 40px">
        <label>Project</label>
        <forms:select path="projectId" items="${projects}" itemLabel="name" itemValue="id"/>
        <forms:errors path="projectId"/>
    </div>

    <div>
        <label for="file" class="ui icon button"/>
        <i class="file icon"></i>
        <input type="file" id="file" name="file" style="display:none">
    </div>
    <br/>

    <button class="ui button" type="submit">Submit</button>
</forms:form>

</body>
</html>
