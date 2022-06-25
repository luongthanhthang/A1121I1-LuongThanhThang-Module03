<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 17-Jun-22
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Create</title>
        <link rel="stylesheet" href="template/bootstrap/css/bootstrap.css">
    </head>
    <body>

        <%--+++++++++content++++++++--%>
        <div>
            <center>
                <h1 class="font-text-footer" style="color: #cbbe73;">Create Product</h1>
                <c:if test="${mess !=null}">
                    <h2 class="text-danger">${mess}</h2>
                </c:if>
                <br>
                <div class="container">
                    <form action="/product?action=create" method="post">
                        <div class="input-group mb-3">
                            <span class="input-group-text">Name</span>
                            <input required name="name" value="${product.name}" type="text" class="form-control me-2"
                                   placeholder="Name">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">Price</span>
                            <input required name="price" value="${product.price}" type="text" class="form-control me-2"
                                   placeholder="Price">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">Quantity</span>
                            <input required name="quantity" value="${product.quantity}" type="number"
                                   class="form-control me-2"
                                   placeholder="Quantity">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">Color</span>
                            <input required name="color" value="${product.color}" type="text" class="form-control me-2"
                                   placeholder="Color">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">Describe</span>
                            <input required name="describe" value="${product.describe}" type="text"
                                   class="form-control me-2"
                                   placeholder="Describe">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">Type(*)</span>
                            <select name="categoryId" class="me-2">
                                <option value="">Chọn</option>
                                <c:forEach items="${categoryList}" var="category">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <div class="input-group mb-5 d-flex align-content-center justify-content-center">
                            <button type="submit" class="btn btn-primary">Create</button>
                            <button type="button" class="btn btn-primary ms-3"><a style="text-decoration: none"
                                                                                  class="text-light"
                                                                                  href="/product">Back</a></button>
                        </div>
                    </form>
                </div>
            </center>
        </div>

    </body>
    <script src="template/bootstrap/jquery-3.6.0.min.js"></script>
    <script src="template/bootstrap/js/bootstrap.js"></script>
</html>
