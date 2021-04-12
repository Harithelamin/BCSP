<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Harith
  Date: 4/1/2019
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guide</title>
    <link href="<c:url value='/static/css/bcsp.css' />" rel="stylesheet"></link>
</head>
<body>
<%@include file="../fragments/header.jsp"%>
<%@include file="../fragments/sidebar.jsp"%>
<div class="content">
 <object
            data="${pageContext.request.contextPath}/static/images/guide.pdf"
            type="application/pdf"
            width="100%"
            height="400px">
        <iframe
                src="${pageContext.request.contextPath}/static/images/guide.pdf"
                width="100%"
                height="400px"
                style="border: none;">
            <p>Your browser does not support PDFs.
                <a href="https://example.com/test.pdf">Download the PDF</a>.</p>
        </iframe>
    </object>
</div>
</body>
</html>
