<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Harith
  Date: 4/1/2019
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="content">
<div class="login-menu">
    <div>
        <div id="content_wrapper">
            <h3>
                Log-in
            </h3>
        <div>
            <div>
                <c:url var="loginUrl" value="/login" />
                <form action="${loginUrl}" method="post">
                    <c:if test="${param.error != null}">
                        <div>
                            <p>Invalid username and password.</p>
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div>
                            <p>You have been logged out successfully.</p>
                        </div>
                    </c:if>
                    <div>
                        <label for="username"><i class="fa fa-user"></i></label>
                        <input type="text" id="username" name="personId" placeholder="Enter Username" required>
                    </div>
                    <div>
                        <label for="password"><i class="fa fa-lock"></i></label>
                        <input type="password" id="password" name="password" placeholder="Enter Password" required>
                    </div>
                    <div>
                        <div>
                            <label><input type="checkbox" name="remember-me"> Remember Me</label>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

                    <div class="button">
                        <input type="submit" class="submit" value="Log in">
                        <a href="index">I'm a visitor</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</body>
</html>
