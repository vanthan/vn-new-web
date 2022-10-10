<%--
  Created by IntelliJ IDEA.
  User: ThuongDang
  Date: 9/28/2022
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Dashboard</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.rtl.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row flex-nowrap">
        <%@include file="../layout/menu.jsp" %>
        <div class="col py-3">
            <h2>
                <b>Danh sách sản phẩm</b>
            </h2>
            <a class="btn btn-warning" href="/saveProduct">Thêm
                sản phẩm</b>
            </a> <input type="text" id="keyword" placeholder="Tìm kiếm"
                        name="keyword" value="${keyword}">
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
            <table>
                <tr>
                    <th>Id</th>
                    <th>SKU</th>
                    <th>NAME</th>
                    <th>QUANTITY</th>
                    <th>ACTIONS</th>
                </tr>
                <tr>
                    <c:forEach var="products" items="${listProducts}">
                <tr>
                    <th scope="row">${products.id}</th>
                    <td>${products.sku}</td>
                    <td>${products.name}</td>
                    <td>${products.quantity}</td>
                    <td><div class="btn-group">
                        <a href="/edit-products/${products.id}" class="btn btn-success">Sửa</a>
                        <a href="/delete-products/${products.id}" class="btn btn-danger">Xóa</a>
                    </div></td>
                </tr>
                </c:forEach>
                </tr>
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
