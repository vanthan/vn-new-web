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

            <c:if test="${not empty message}">
                <div class="alert alert-danger alert-dismissible fade show">
                    <strong>Error!</strong> ${message}
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            </c:if>

            <%@include file="../layout/menu.jsp" %>
            <%@include file="../layout/addcustomer.jsp" %>
            <div class="row">
                <div class="col col-sm-12 legend">

                    <div class="row">
                        <div class="input-group py-4 col-sm-8">
                            <input class="form-control" type="text" placeholder="Search" aria-label="Search">
                        </div>
                    </div>
                    <div class="row">
                        <div class="py-4 col-sm-8">
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">Add</button>
                        </div>
                    </div>
                    <table class="table table-striped py-4">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">UserName</th>
                            <th scope="col">Email</th>
                            <th scope="col">Age</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${userPage}">
                        <tr>
                            <th scope="row">1</th>
                            <td>${user.userName}</td>
                            <td>${user.email}</td>
                            <td>${user.age}</td>
                            <td>

                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

        </div>
    </div>
    <script src="<c:url value="/resources/js/jquery-3.6.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.bundle.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.esm.js" />"></script>
    <script type="text/javascript">

        var exampleModal = document.getElementById('exampleModal')
        exampleModal.addEventListener('show.bs.modal', function (event) {
        })
    </script>
</body>
</html>
