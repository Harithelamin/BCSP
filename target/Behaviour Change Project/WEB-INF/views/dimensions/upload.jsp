<%--
  Created by IntelliJ IDEA.
  User: Harith
  Date: 4/8/2019
  Time: 5:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Spring MVC - Hibernate File Upload to Database Demo</h1>
    <form method="post" action="doUpload" enctype="multipart/form-data">
        <table border="0">
            <tr>
                <td>Pick file #1:</td>
                <td><input type="file" name="fileUpload" size="50" /></td>
            </tr>
            <tr>
                <td>Pick file #2:</td>
                <td><input type="file" name="fileUpload" size="50" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>
