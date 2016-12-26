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
    <script   src="https://code.jquery.com/jquery-3.1.1.js"   integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="   crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<spring:url value="/resources/css/semantic.css"/>" type="text/css"/>
    <script src="<spring:url value="/resources/js/semantic.js"/>"></script>
    <link rel='stylesheet prefetch'
          href='https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/components/icon.min.css'>
    <title>Project Management - Home</title>
    <div class="ui menu">
        <a href="<spring:url value="/"/>" class="item">Home</a>

      <%--  <div class="ui simple dropdown item">
            Project
            <i class="dropdown icon"></i>
            <div class="menu">
                <a class="item" href="<spring:url value="/project"/>">All Projects</a>
                <a class="item">Find Project</a>
            </div>
        </div>--%>
        <a href="<spring:url value="/project"/>" class="item">Projects</a>
        <a href="<spring:url value="/member"/>" class="item">Members</a>

    </div>
</head>
</html>
