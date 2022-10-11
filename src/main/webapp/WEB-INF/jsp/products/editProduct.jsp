<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ADD Product</title>
</head>
<!-- Latest compiled and minified CSS -->
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.rtl.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<title>Add Product</title>
<body>
<div class="container-fluid">
    <div class="row flex-nowrap">
        <%@include file="../layout/menu.jsp" %>
        <div class="col py-3">
            <h2>
                <b>Edit Product</b>
            </h2>
            <form action="/edit-products" method="post">
                <input type="hidden" id="iname" name="id" value="${product.id}">
                <label for="sname"><b>SKU</b></label><br>
                <input type="text" id="sname" name="sku" value="${product.sku}"><br>
                <label for="lname"><b>NAME</b></label><br>
                <input type="text" id="lname" name="name" value="${product.name}"><br>
                <label for="qname"><b>QUANTITY</b></label><br>
                <input type="text" id="qname" name="quantity" value="${product.quantity}"><br><br>
                <input type="submit" value="Submit">
                </input>
        </div>
    </div>
</div>
<script src="<c:url value="/resources/js/jquery-3.6.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.bundle.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.esm.js" />"></script>
</body>
</html>

