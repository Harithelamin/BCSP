<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Harith
  Date: 4/1/2019
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="">
        <div class="h4 mb-4" >User Registration Form</div>
        <form:form method="POST" class="form-horizontal"  modelAttribute="user">
            <form:input type="hidden" path="id" id="id"/>

            <div class="form-group">
                <div>
                    <label for="fullName" class="col-sm-2 control-label">Full Name</label>
                    <div>
                        <form:input type="text" path="fullName" id="fullName"/>
                        <div class="has-error">
                            <form:errors path="fullName"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div>
                    <label for="mobileNumber" class="col-sm-2 control-label">Mobile Number</label>
                    <div>
                        <form:input type="text" path="mobileNumber" id="mobileNumber"/>
                        <div class="has-error">
                            <form:errors path="mobileNumber"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group" >
                <div>
                    <label for="personId" class="col-sm-2 control-label">Person ID</label>
                    <div>
                        <c:choose>
                            <c:when test="${edit}">
                                <form:input type="text" path="personId" id="personId" disabled="true"/>
                            </c:when>
                            <c:otherwise>
                                <form:input type="text" path="personId" id="personId" />
                                <div class="has-error">
                                    <form:errors path="personId"/>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div>
                    <label for="password" class="col-sm-2 control-label">Password</label>
                    <div>
                        <form:input type="password" path="password" id="password" />
                        <div class="has-error">
                            <form:errors path="password"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div>
                    <label for="email" class="col-sm-2 control-label" >Email</label>
                    <div>
                        <form:input type="text" path="email" id="email" />
                        <div class="has-error">
                            <form:errors path="email" />
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div>
                    <label for="userProfiles" class="col-sm-2 control-label">Roles</label>
                    <div>
                        <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type"  />
                        <div class="has-error">
                            <form:errors path="userProfiles"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div>
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" /> or <a href="<c:url value='/userslist' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register" /> or <a href="<c:url value='/userslist' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>
