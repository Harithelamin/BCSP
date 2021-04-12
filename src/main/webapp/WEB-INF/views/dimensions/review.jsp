<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        .responsive {
            width: 40%;
            height: 40%;
            display:block;
        }
    </style>
</head>
<body>
<div class="content">
    <div class="row">
        <div>
            <!-- Default panel contents -->
            <div><span>List of Dimensions </span></div>
            <div style="overflow-x:auto;">
                <table class="table">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${dimensions}" var="dimensions">
                        <tr>
                            <td>
                                <h2>${dimensions.dimensionId}</h2>
                                <p>${dimensions.dimensiondescription}</p>
                                <img src="${pageContext.request.contextPath}/dimImage?code=${dimensions.dimensionId}"  class="responsive" width="600px" height="600px"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
