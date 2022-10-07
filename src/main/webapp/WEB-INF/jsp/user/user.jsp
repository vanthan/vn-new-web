<%--
  Created by IntelliJ IDEA.
  User: vvthan
  Date: 10/7/2022
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>User</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.rtl.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
    <div class="container-fluid">
        <div class="row flex-nowrap">
            <%@include file="../layout/menu.jsp" %>
            <div class="col py-3">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">UserName</th>
                        <th scope="col">Email</th>
                        <th scope="col">Age</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${userPage}">
                        <tr>
                            <td>${user.userName}</td>
                            <td>${user.email}</td>
                            <td>${user.age}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/jquery-3.6.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.bundle.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.esm.js" />"></script>
</body>
</html>
