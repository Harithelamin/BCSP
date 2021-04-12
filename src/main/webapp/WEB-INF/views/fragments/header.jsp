<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Harith
  Date: 4/1/2019
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <a href="index" class="logo"><img class="img" src="${pageContext.servletContext.contextPath}/static/images/bcsp_logo.png" alt=""></a>
    <div class="header-right">
        <a class="active" href="guide">Behavior tools Platform</a>
        <a href="contact">Contact</a>
        <a href="about">About</a>
        <a href="guide">Guide</a>
        <sec:authorize access="hasRole('ADMIN') or hasRole('SYSTEM ADMIN')">
            <a href="userslist">User List</a>
            <a href="newuser">New User</a>
            <a href="dimensionslist">Tools List</a>
            <a href="newdimension">New Tool</a>
        </sec:authorize>
    </div>
</div>

