<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 25-May-22
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product details</title>
</head>
<body>
<center>
    <h1>Customer details</h1>
    <p>
        <a href="/product">Back to Product list</a>
    </p>

    <table>
        <tr>
            <td>Name Product:</td>
            <td>${requestScope["product"].getName()}</td>
        </tr>
        <tr>
            <td>Cost:</td>
            <td>${requestScope["product"].getCost()}</td>
        </tr>
        <tr>
            <td>Describe:</td>
            <td>${requestScope["product"].getDescribe()}</td>
        </tr>
        <tr>
            <td>Name Producer:</td>
            <td>${requestScope["product"].getNameProducer()}</td>
        </tr>
    </table>
</center>
</body>
</html>
