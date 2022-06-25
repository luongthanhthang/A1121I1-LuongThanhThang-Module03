<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 17-Jun-22
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Edit product</title>
        <link rel="stylesheet" href="template/bootstrap/css/bootstrap.css">

    </head>
    <body>
        <%--++++++++++++++hiển thị+++++++++++--%>
        <div>
            <center>
                <h1 class="font-text-footer" style="color: #cbbe73;">Product List</h1>


                <c:if test="${mess !=null}">
                    <h2 class="text-danger">${mess}</h2>
                </c:if>

                <br>
                <br>
                <%--        ++++++++++++++++++form search++++++++++++++--%>
                <div class="container d-flex justify-content-center">
                    <form action="/product" method="get">
                        <div class="input-group mb-3">
                            <span class="input-group-text">Name product</span>
                            <input class="ms-2" name="nameProductSearch" placeholder="Nhập tên product"
                                   value="${nameProductSearch}">
                            <button class="btn btn-success" type="submit" name="action" value="search">Search</button>
                        </div>
                    </form>
                </div>

            </center>
            <br>
            <div class="container">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Product Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Color</th>
                            <th>Category</th>
                            <th colspan="2"><a href="/product?action=create">
                                <button class="btn btn-secondary w-100">Create</button>
                            </a></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${productList}">
                            <tr>
                                <td><c:out value="${product.id}"/></td>
                                <td><c:out value="${product.name}"/></td>
                                <td><c:out value="${product.price}"/></td>
                                <td><c:out value="${product.quantity}"/></td>
                                <td><c:out value="${product.color}"/></td>

                                <c:forEach items="${categoryList}" var="category">
                                    <c:if test="${product.categoryId == category.id}">
                                        <td><c:out value="${category.name}"/></td>
                                    </c:if>
                                </c:forEach>

                                <td>
                                    <button type="submit" class="btn btn-primary">Edit</button>
                                </td>
                                <td>
                                    <!-- Button trigger modal -->
                                    <button type="button" onclick="showInfo('${product.id}','${product.name}')"
                                            class="btn btn-danger"
                                            data-bs-toggle="modal"
                                            data-bs-target="#deleteModal">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <%-----------thêm thẻ form---------%>
                <form action="/product" method="get">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-danger" id="exampleModalLabel">Xác nhận xoá !</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="text" hidden id="idProduct" name="idDelete">
                            <span>Bạn có muốn xóa Product </span>
                            <span class="text-danger" id="idValueProduct"></span><span> không?</span>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" name="action" value="delete">Delele</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
    <script src="template/bootstrap/jquery-3.6.0.min.js"></script>
    <script src="template/bootstrap/js/bootstrap.js"></script>
</html>

<%--<form action="/product?action=edit" method="post">--%>
<%--    <td><input name="id" disabled type="text" value="${product.id}"></td>--%>
<%--    <td><input name="name" type="text" value="${product.name}"></td>--%>
<%--    <td><input name="price" type="number" value="${product.price}"></td>--%>
<%--    <td><input name="quantity" type="number" value="${product.quantity}"></td>--%>
<%--    <td><input name="color" type="text" value="${product.color}"></td>--%>

<%--    <td>--%>
<%--        <select name="typeId" class="me-2">--%>
<%--            <c:forEach items="${categoryList}" var="category">--%>
<%--                <c:if test="${product.categoryId == category.id}">--%>
<%--                    <option value="${category.id}" selected>${category.name}</option>--%>
<%--                </c:if>--%>
<%--            </c:forEach>--%>

<%--            <c:forEach items="${categoryList}" var="category">--%>
<%--                <c:if test="${product.categoryId != category.id}">--%>
<%--                    <option value="${category.id}" selected>${category.name}</option>--%>
<%--                </c:if>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
<%--    </td>--%>

<%--    <td>--%>
<%--        <a href="/product?action=edit&id=${product.id}">--%>
<%--            <button type="submit" class="btn btn-primary">Edit</button>--%>
<%--        </a>--%>
<%--    </td>--%>
<%--    <td>--%>
<%--        <!-- Button trigger modal -->--%>
<%--        <button type="button" onclick="showInfo('${product.id}','${product.name}')"--%>
<%--                class="btn btn-danger"--%>
<%--                data-bs-toggle="modal"--%>
<%--                data-bs-target="#deleteModal">--%>
<%--            Delete--%>
<%--        </button>--%>
<%--    </td>--%>
<%--</form>--%>