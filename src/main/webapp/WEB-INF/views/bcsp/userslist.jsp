<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Harith
  Date: 4/1/2019
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
    <link href="<c:url value='/static/css/bcsp.css' />" rel="stylesheet"></link>
</head>
<body>
<%@include file="../fragments/header.jsp"%>
<%@include file="../user/userslist.jsp"%>



</body>
</html>
