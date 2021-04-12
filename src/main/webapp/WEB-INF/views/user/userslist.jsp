<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Harith
  Date: 4/1/2019
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="">
    <sec:authorize access="hasRole('ADMIN') or hasRole('ADMIN')">
        <div>
            <div>
                <!-- Default panel contents -->
                <div><span class="table-responsive-sm">List of Users </span></div>
                <table class="table">
                    <thead>
                    <tr>
                        <th  class="th-lg"></th>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('ADMIN')">
                            <th width="100"></th>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <th width="100"></th>
                        </sec:authorize>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.personId}</td>
                            <sec:authorize access="hasRole('ADMIN') or hasRole('ADMIN')">
                                <td><a href="<c:url value='/edit-user-${user.personId}' />" >edit</a></td>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ADMIN')">
                                <td><a href="<c:url value='/delete-user-${user.personId}' />" >delete</a></td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <sec:authorize access="hasRole('ADMIN')">
                <div class="well">
                    <a  class="submit" href="<c:url value='/newuser' />">Add New User</a>
                </div>
            </sec:authorize>
        </div>
    </sec:authorize>
</div>
</body>
</html>
