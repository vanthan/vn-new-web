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
        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
        }
        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }

        .pagination li a:hover {
            color: #666;
        }

        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            color: #ccc;
        }

        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }
        .clearfix{
            padding-top: 9px;
        }
        .pagination{
            padding-top: 4px;
            float: right;
        }
    </style>
</head>
<body>
<%
    int numberOfElements=0;
    int count = 1;
    String tag = String.valueOf(request.getAttribute("tag"));
    String totalNum = String.valueOf(request.getAttribute("totalNum"));
%>
<div class="container-fluid">
    <div class="row flex-nowrap">
        <%@include file="../layout/menu.jsp" %>
        <div class="col py-3">
            <h2>
                <b>Danh sách sản phẩm</b>
            </h2>
            <form action="/products" method="get">
                <input style="height: 37px; padding-bottom: 9px" type="text" id="keyword" placeholder="Tìm kiếm"
                            name="keyword" value="${keyword}">
                <button type="submit" class="btn btn-primary">Tìm kiếm</button>
                <a style="float: right;" class="btn btn-warning" href="/saveProduct">Thêm
                    sản phẩm</a>
            </form>
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
                    <%
                         //Đếm số phần tử được hiển thị
                         numberOfElements += 1;
                    %>
                    <tr>
                        <td><%= Integer.parseInt(tag)*Integer.parseInt(totalNum)+count++ %></td>
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
            <div class="clearfix">
                <div class="hint-text">
                    Showing <b><%=numberOfElements%></b> out of <b>${totalElements}</b> entries
                </div>
                <ul class="pagination">
                    <c:if test="${tag+1 > 1}">
                        <li class="page-item disabled" class="page-link"><a href="/products?pageNum=${tag-1}">Previous</a></li>
                    </c:if>
                        <c:forEach begin="1" end="${endP}" var = "i">
                            <li class="page-item ${tag+1 == i?"active":""}"><a href="/products?pageNum=${i-1}" class="page-link">${i}</a></li>
                        </c:forEach>
                    <c:if test="${tag+1 < endP}">
                        <li class="page-item"><a href="/products?pageNum=${tag + 1}" class="page-link">Next</a></li>
                    </c:if>
                    <%--<li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>--%>

                </ul>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/resources/js/jquery-3.6.1.min.js" />">

    var u = $(e.currentTarget).closest('td').parent()[0].sectionRowIndex ;
</script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.bundle.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.esm.js" />"></script>
</body>
</html>
