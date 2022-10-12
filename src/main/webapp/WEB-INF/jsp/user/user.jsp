<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Manage User</title>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.rtl.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }

        #avatar {

            background-image: url('http://i.stack.imgur.com/Dj7eP.jpg');

            border-radius:50%;
            -moz-border-radius:50%;
            -webkit-border-radius:50%;

        }

        .table-responsive {
            margin: 30px 0;
            width: 1000px;
        }

        .table-wrapper {
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            min-width: 1000px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 15px;
            background: #435d7d;
            color: #fff;
            padding: 16px 30px;
            min-width: 100%;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }

        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }

        .table-title .btn-group {
            float: right;
        }

        .table-title .btn {
            color: #fff;
            float: right;
            font-size: 13px;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }

        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }

        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }

        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }

        table.table tr th:first-child {
            width: 60px;
        }

        table.table tr th:last-child {
            width: 100px;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }

        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }

        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
            outline: none !important;
        }

        table.table td a:hover {
            color: #2196F3;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #F44336;
        }

        table.table td i {
            font-size: 19px;
        }

        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }

        .pagination {
            float: right;
            margin: 0 0 5px;
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

        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
        }
        /* Custom checkbox */
        .custom-checkbox {
            position: relative;
        }

        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            position: absolute;
            margin: 5px 0 0 3px;
            z-index: 9;
        }

        .custom-checkbox label:before {
            width: 18px;
            height: 18px;
        }

        .custom-checkbox label:before {
            content: '';
            margin-right: 10px;
            display: inline-block;
            vertical-align: text-top;
            background: white;
            border: 1px solid #bbb;
            border-radius: 2px;
            box-sizing: border-box;
            z-index: 2;
        }

        .custom-checkbox input[type="checkbox"]:checked+label:after {
            content: '';
            position: absolute;
            left: 6px;
            top: 3px;
            width: 6px;
            height: 11px;
            border: solid #000;
            border-width: 0 3px 3px 0;
            transform: inherit;
            z-index: 3;
            transform: rotateZ(45deg);
        }

        .custom-checkbox input[type="checkbox"]:checked+label:before {
            border-color: #03A9F4;
            background: #03A9F4;
        }

        .custom-checkbox input[type="checkbox"]:checked+label:after {
            border-color: #fff;
        }

        .custom-checkbox input[type="checkbox"]:disabled+label:before {
            color: #b8b8b8;
            cursor: auto;
            box-shadow: none;
            background: #ddd;
        }
        /* Modal styles */
        .modal .modal-dialog {
            max-width: 400px;
        }

        .modal .modal-header, .modal .modal-body, .modal .modal-footer {
            padding: 20px 30px;
        }

        .modal .modal-content {
            border-radius: 3px;
            font-size: 14px;
        }

        .modal .modal-footer {
            background: #ecf0f1;
            border-radius: 0 0 3px 3px;
        }

        .modal .modal-title {
            display: inline-block;
        }

        .modal .form-control {
            border-radius: 2px;
            box-shadow: none;
            border-color: #dddddd;
        }

        .modal textarea.form-control {
            resize: vertical;
        }

        .modal .btn {
            border-radius: 2px;
            min-width: 100px;
        }

        .modal form label {
            font-weight: normal;
        }
        body {
            background: #212129;
        }

        ::selection {
            background: #212129;
        }

        .search-wrapper {
            position: absolute;
            transform: translate(-50%, -50%);
            top:50%;
            left:50%;
        }
        .search-wrapper.active {}

        .search-wrapper .input-holder {
            height: 70px;
            width:70px;
            overflow: hidden;
            background: rgba(255,255,255,0);
            border-radius:6px;
            position: relative;
            transition: all 0.3s ease-in-out;
        }
        .search-wrapper.active .input-holder {
            width:250px;
            border-radius: 50px;
            background: rgba(0,0,0,0.5);
            transition: all .5s cubic-bezier(0.000, 0.105, 0.035, 1.570);
        }
        .search-wrapper .input-holder .search-input {
            width:100%;
            height: 50px;
            padding:0px 70px 0 20px;
            opacity: 0;
            position: absolute;
            top:0px;
            left:0px;
            background: transparent;
            box-sizing: border-box;
            border:none;
            outline:none;
            font-family:"Open Sans", Arial, Verdana;
            font-size: 16px;
            font-weight: 400;
            line-height: 20px;
            color:#FFF;
            transform: translate(0, 60px);
            transition: all .3s cubic-bezier(0.000, 0.105, 0.035, 1.570);
            transition-delay: 0.3s;
        }
        .search-wrapper.active .input-holder .search-input {
            opacity: 1;
            transform: translate(0, 10px);
        }
        .search-wrapper .input-holder .search-icon {
            width:50px;
            height:50px;
            border:none;
            border-radius:59px;
            background: #FFF;
            padding:0px;
            outline:none;
            position: relative;
            z-index: 2;
            float:right;
            cursor: pointer;
            transition: all 0.3s ease-in-out;
            margin-top: 10px;
        }
        .search-wrapper.active .input-holder .search-icon {
            width: 50px;
            height:50px;
            margin: 10px;
            border-radius: 30px;
        }
        .search-wrapper .input-holder .search-icon span {
            width:22px;
            height:22px;
            display: inline-block;
            vertical-align: middle;
            position:relative;
            transform: rotate(45deg);
            transition: all .4s cubic-bezier(0.650, -0.600, 0.240, 1.650);
        }
        .search-wrapper.active .input-holder .search-icon span {
            transform: rotate(-45deg);
        }
        .search-wrapper .input-holder .search-icon span::before, .search-wrapper .input-holder .search-icon span::after {
            position: absolute;
            content:'';
        }
        .search-wrapper .input-holder .search-icon span::before {
            width: 4px;
            height: 11px;
            left: 9px;
            top: 18px;
            border-radius: 2px;
            background: #FE5F55;
        }
        .search-wrapper .input-holder .search-icon span::after {
            width: 20px;
            height: 20px;
            left: 0px;
            top: 0px;
            border-radius: 16px;
            border: 4px solid #FE5F55;
        }
        .search-wrapper .close {
            position: absolute;
            z-index: 1;
            top:24px;
            right:20px;
            width:25px;
            height:25px;
            cursor: pointer;
            transform: rotate(-180deg);
            transition: all .3s cubic-bezier(0.285, -0.450, 0.935, 0.110);
            transition-delay: 0.2s;
        }
        .search-wrapper.active .close {
            right:-30px;
            transform: rotate(45deg);
            transition: all .6s cubic-bezier(0.000, 0.105, 0.035, 1.570);
            transition-delay: 0.5s;
        }
        .search-wrapper .close::before, .search-wrapper .close::after {
            position:absolute;
            content:'';
            background: #FE5F55;
            border-radius: 2px;
        }
        .search-wrapper .close::before {
            width: 5px;
            height: 25px;
            left: 10px;
            top: 0px;
        }
        .search-wrapper .close::after {
            width: 25px;
            height: 5px;
            left: 0px;
            top: 10px;
        }

    </style>
    <script>
        $(document).ready(function() {
            // Activate tooltip
            $('[data-toggle="tooltip"]').tooltip();

            // Select/Deselect checkboxes
            var checkbox = $('table tbody input[type="checkbox"]');
            $("#selectAll").click(function() {
                if (this.checked) {
                    checkbox.each(function() {
                        this.checked = true;
                    });
                } else {
                    checkbox.each(function() {
                        this.checked = false;
                    });
                }
            });
            checkbox.click(function() {
                if (!this.checked) {
                    $("#selectAll").prop("checked", false);
                }
            });
        });
        function searchToggle(obj, evt){
            var container = $(obj).closest('.search-wrapper');
            if(!container.hasClass('active')){
                container.addClass('active');
                evt.preventDefault();
            }
            else if(container.hasClass('active') && $(obj).closest('.input-holder').length == 0){
                container.removeClass('active');
                // clear input
                container.find('.search-input').val('');
            }
        }
    </script>
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
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-4">
                                <h2>
                                    Manage <b>User</b>
                                </h2>
                            </div>
                            <div class="col-sm-4">
                                <div class="search-wrapper">
                                    <form action="/user" method="get">
                                        <div class="input-holder">
                                            <input name="keyword" value="${keyword}" type="text" class="search-input" placeholder="Type to search" />
                                            <button type="submit" class="search-icon" onclick="searchToggle(this, event);"><span></span></button>
                                        </div>
                                    </form>
                                    <span class="close" onclick="searchToggle(this, event);"></span>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <a href="#addEmployeeModal" class="btn btn-success"
                                   data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add
                                            New Employee</span></a>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <td>Id</td>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Age</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="userPage" items="${userPage}">
                            <%
                                //Đếm số phần tử được hiển thị
                                numberOfElements += 1;
                            %>
                            <tr>
                                <td><%= Integer.parseInt(tag)*Integer.parseInt(totalNum)+count++ %></td>
                                <td>${userPage.userName}</td>
                                <td>${userPage.email}</td>
                                <td>${userPage.age}</td>
                                <td><a class="edit"
                                       data-target="#editEmployeeModal${userPage.id}"
                                       data-toggle="modal"><i class="material-icons"
                                                              data-toggle="tooltip" title="Edit">&#xE254;</i></a> <a
                                        data-target="#deleteEmployeeModal${userPage.id}" class="delete" data-toggle="modal"><i
                                        class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>

                            <!-- Edit Modal HTML -->
                            <div id="editEmployeeModal${userPage.id}" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action="/edit-user" method="post">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Edit Employee</h4>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">

                                                <div class="form-group">

                                                    <input type="hidden" value="${userPage.id}" name="id" class="form-control">
                                                </div>

                                                <div class="form-group">
                                                    <label>Username</label>
                                                    <input type="text" value="${userPage.userName}" name="userName" class="form-control">
                                                </div>

                                                <div class="form-group">
                                                    <label>Email</label> <input type="text" value="${userPage.email}" name="email" class="form-control"
                                                                                required>
                                                </div>

                                                <div class="form-group">
                                                    <label>Age</label> <input type="text" value="${userPage.age}" name="age" class="form-control"
                                                                                required>
                                                </div>

                                            </div>
                                            <div class="modal-footer">
                                                <input type="button" class="btn btn-default"
                                                       data-dismiss="modal" value="Cancel"> <button
                                                    type="submit" class="btn btn-info" >Save</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <!-- Delete Modal HTML -->
                            <div id="deleteEmployeeModal${userPage.id}" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action ="/user/delete" method="post">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Delete Employee</h4>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                <p>Are you sure you want to delete these Records?</p>
                                                <p class="text-warning">
                                                    <small>This action cannot be undone.</small>
                                                </p>
                                            </div>
                                            <input type="hidden" value = "${userPage.id}" name ="idUser">
                                            <div class="modal-footer">
                                                <input type="button" class="btn btn-default"
                                                       data-dismiss="modal" value="Cancel"> <button
                                                    type="submit" class="btn btn-danger">Save</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text">
                            Showing <b><%=numberOfElements%></b> out of <b>${totalElements}</b> entries
                        </div>
                        <ul class="pagination">
                            <c:if test="${tag+1 > 1}">
                                <li class="page-item disabled" class="page-link"><a href="/user?pageNum=${tag-1}">Previous</a></li>
                            </c:if>
                            <c:forEach begin="1" end="${endP}" var = "i">
                                <li class="page-item ${tag+1 == i?"active":""}"><a href="/user?pageNum=${i-1}" class="page-link">${i}</a></li>
                            </c:forEach>
                            <c:if test="${tag+1 < endP}">
                                <li class="page-item"><a href="/user?pageNum=${tag + 1}" class="page-link">Next</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Add Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="/user" method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Add User</h4>
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">

                            <div class="form-group">
                                <label>Name</label> <input type="text" class="form-control"
                                                           name="userName" required>
                            </div>

                            <div class="form-group">
                                <label>Email</label> <input type="email" class="form-control"
                                                            name="email" required>
                            </div>
                            <div class="form-group">
                                <label>Age</label>
                                <input class="form-control" name="age" required></input>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal"
                                   value="Cancel"> <input type="submit"
                                                          class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/resources/js/jquery-3.6.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.bundle.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.esm.js" />"></script>
</html>