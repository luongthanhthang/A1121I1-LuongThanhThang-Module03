<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 27-May-22
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/template/bootstrap/css/bootstrap.css">
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>

    <c:if test="${mess !=null}">
        <p class="text-danger">${mess}</p>
    </c:if>

</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
                <h2>Add New User</h2>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                    <%--                kiểm tra validate--%>
                    <c:if test="${errors!=null}">
                        <p class="text-danger"> ${errors.get("email")}</p>
                    </c:if>
                </td>


            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" id="country" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
<script rel="stylesheet" src="/template/bootstrap/js/bootstrap.js"></script>
</html>
