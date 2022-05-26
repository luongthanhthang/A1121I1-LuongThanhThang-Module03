<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 25-May-22
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>view customer</title>
</head>
<body>
<center>
    <h1>Customer details</h1>
    <p>
        <a href="/customer">Back to customer list</a>
    </p>
    <table>
        <tr>
            <td>Name:</td>
            <td>${requestScope["customer"].getName()}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${requestScope["customer"].getEmail()}</td>
        </tr>
        <tr>
            <td>Address:</td>
            <td>${requestScope["customer"].getAddress()}</td>
        </tr>
    </table>
</center>
</body>
</html>
