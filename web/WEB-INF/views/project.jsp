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
        <th>Name</th>
        <th>Description</th>
        <th>Start Date</th>
        <th>Dead Line</th>
        <th>Budget</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${project.name}</td>
        <td>${project.description}</td>
        <td>${project.startDate}</td>
        <td>${project.deadLine}</td>
        <td>${project.budget}</td>
        <td class="selectable positive center aligned">
            <a class="item" href="<spring:url value="/project/add"/>">Edit Project</a></td>
    </tr>
    </tbody>
</table>

<br/>

<div>
    <spring:url value="/note/add" var="noteUrl"/>
    <forms:form class="ui form" style="width: 45%" action="${noteUrl}" method="post" enctype="multipart/form-data">
        <div class="fields">
            <a style="float: right" href="<spring:url value="/note?projectId=${project.id}"/>">
                <button type="button" class="ui green button">Notes</button>
            </a>
            <textarea name="note" placeholder="Write you note here" rows="1"></textarea>
            <forms:errors path="note"/>
            &nbsp;

            <div>
                <label for="file" class="ui icon button"/>
                <i class="file icon"></i>
                <input type="file" id="file" name="file" style="display:none">
            </div>

            <a>
                <button type="submit" class="ui green button">
                    Add
                </button>
            </a>

            <input name="projectId" hidden value="${project.id}">
        </div>
    </forms:form>
</div>

<br/>


<div style="float: left;text-align: center; width: 45%">
    <div class="ui pointing below label " style="width: 100%">
        Members
    </div>
    <table class="ui selectable orange table">
        <thead>
        <tr>
            <th class="one wide"></th>
            <th class="center aligned">First Name</th>
            <th class="center aligned">Last Name</th>
            <th class="center aligned">Start Date</th>
            <th class="center aligned">Position</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${project.members}" var="memberi">
            <tr>
                <td><img class="ui avatar image" src="data:image/jpeg;base64,${memberi.image}" alt="..." width="75"
                         height="75"></td>
                <td class="selectable center aligned"><a
                        href="<spring:url value="/member/${memberi.id}"/>">${memberi.firstName}</a>
                </td>
                <td class="center aligned">${memberi.lastName}</td>
                <td class="center aligned">${memberi.startDate}</td>
                <td class="center aligned">${memberi.position}</td>
                <td>
                    <a href="<spring:url value="/member/remove?id=${memberi.id}&projectId=${project.id}"/>">
                        <i class="minus orange square icon"></i></a>
                </td>
            </tr>
        </c:forEach>
        <tr class="positive">
            <td class="selectable positive center aligned">
                <a class="item" href="<spring:url value="/member/add?projectId=${project.id}"/>"><i
                        class="add square icon"></i></a></td>
            <td/>
            <td/>
            <td/>
            <td/>
            <td/>
        </tr>
        </tbody>
    </table>
</div>

<%--<div class="ui vertical divider" style="height: 25%">
    and
</div>--%>

<div style="float: right;text-align: center; width: 45%">
    <div class="ui pointing below label" style="width: 100%">
        Sponsors
    </div>
    <table class="ui selectable orange table">
        <thead>
        <tr>
            <th class="center aligned">Name</th>
            <th class="center aligned">Amount</th>
            <th class="center aligned"/>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${project.sponsors}" var="sponsor">
            <tr>
                <td class="center aligned">${sponsor.name}</td>
                <td class="center aligned">${sponsor.amount}</td>
                <td>
                    <a href="<spring:url value="/sponsor/remove?id=${sponsor.id}&projectId=${project.id}"/>">
                        <i class="minus orange square icon"></i></a>
                </td>
            </tr>
        </c:forEach>
        <tr class="positive">
            <td class="selectable positive center aligned">
                <a class="item" href="<spring:url value="/sponsor/add?projectId=${project.id}"/>"> <i
                        class="add square icon"></i></a></td>
            <td/>
            <td/>
        </tr>
        </tbody>
    </table>
</div>


</body>
</html>
