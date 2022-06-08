<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 08-Jun-22
  Time: 2:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Create Customer</title>
        <link rel="stylesheet" href="template/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="template/datatable/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="template/style.css">
    </head>
    <body>
        <%--++++++++++header+++++++++--%>
        <div>
            <%@include file="/template/layout/header.jsp" %>
        </div>
        <!--++++++++++++navbar top++++++++++++++++++-->
        <div class="mt-2 sticky-top" style="background: #046056">
            <nav class="navbar navbar-light">
                <div class="container-fluid">
                    <a class="navbar-brand text-light ps-5 click" href="/home">Home</a>
                    <a class="navbar-brand text-light click" href="/employee">Employee</a>
                    <a class="navbar-brand text-light click" href="/customer">Customer</a>
                    <a class="navbar-brand text-light click" href="/service">Service</a>
                    <a class="navbar-brand text-light click" href="/contact">Contract</a>
                    <form class="d-flex m-0">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-light" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>

        <%--+++++++++content++++++++--%>
        <div class="row">
            <%@include file="/template/layout/sidebar.jsp" %>
            <div class="col-md-10 container">
                <center>
                    <h1 class="font-text-footer">Create Customer</h1>
                    <c:if test="${mess !=null}">
                        <h2 class="text-danger">${mess}</h2>
                    </c:if>
                    <br>
                    <div class="container">
                        <form action="/customer?action=create" method="post">
                            <div class="input-group mb-3">
                                <span class="input-group-text">Name</span>
                                <input name="name" type="text" class="form-control me-2" placeholder="name customer">

                                <span class="input-group-text">Gender</span>
                                <select name="gender" class="me-2">
                                    <option value="">Chọn</option>
                                    <option value="1">Nam</option>
                                    <option value="0">Nữ</option>
                                </select>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Birthday</span>
                                <input name="birthday" type="date" class="form-control me-2" placeholder="birthday">
                                <span class="input-group-text">Type</span>
                                <select name="type" class="me-2">
                                    <option value="">Chọn</option>
                                    <c:forEach items="${customerTypeList}" var="customerType">
                                        <option value="${customerType.typeId}">${customerType.typeName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Id Card</span>
                                <input name="idCard" type="text" class="form-control me-2" placeholder="Id Card">

                                <span class="input-group-text">Phone</span>
                                <input name="phone" type="text" class="form-control me-2" placeholder="phone number">
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Email</span>
                                <input name="email" type="text" class="form-control me-2" placeholder="email">

                                <span class="input-group-text">Address</span>
                                <input name="address" type="text" class="form-control me-2" placeholder="address">
                            </div>
                            <br>
                            <button type="submit" class="btn btn-primary">Create</button>
                        </form>
                    </div>
                </center>
            </div>
        </div>

        <%--+++++footer+++++++--%>
        <div>
            <%@include file="/template/layout/footer.jsp" %>
        </div>
    </body>
    <script src="template/bootstrap/jquery-3.6.0.min.js"></script>
    <script src="template/bootstrap/js/bootstrap.js"></script>
    <script src="template/datatable/js/jquery.dataTables.min.js"></script>
    <script src="template/datatable/js/dataTables.bootstrap4.min.js"></script>
    <script src="template/main.js"></script>
    <script>
        $(document).ready(function () {
            $('#tableCustomer').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 6
            });
        });

        function showInfo(id, name) {
            document.getElementById("idCustomer").value = id;
            document.getElementById("nameCustomer").innerText = name;
        }
    </script>
</html>
