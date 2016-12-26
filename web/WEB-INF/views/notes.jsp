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
    <script language='javascript'>
        $(document).ready(function () {
            $('.ui.accordion').accordion();
        });
    </script>
</head>
<body>

<%--
<c:forEach items="${notes}" var="note">
    <img src="data:image/jpeg;base64,${note.image}" alt="..." width="200" height="200">
</c:forEach>
--%>

<div>

    <a style="float: left" href="<spring:url value="/project/${projectId}"/>">
        <button class="ui green button">
            Back To Project
        </button>
    </a>
</div>
<br/>
<br/>
<br/>

<div>
    <c:forEach items="${notes}" var="note">
        <div class="ui styled fluid accordion" style="width: 80%;">
            <div class="title">
                <i class="dropdown icon"></i>
                    ${note.date}
                <c:choose>
                    <c:when test="${note.note.length() > 10}"> ${note.note.substring(0,10)}</c:when>
                </c:choose>
                <a style="float: right;"
                   href="<spring:url value="/note/remove?noteId=${note.id}&projectId=${note.projectId}"/>"> <i
                        class="minus orange square icon"></i></a>
            </div>
            <div class="content">
                <div class="ui items">
                    <div class="item">
                        <div class="ui small image">
                            <img src="data:image/jpeg;base64,${note.image}" width="200" height="200">
                        </div>
                        <div class="middle aligned content">
                            <div class="header">
                                <p style="word-break: break-all"> ${note.note}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>

</div>
</body>
</html>
