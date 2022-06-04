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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>

    <%--    --------chon sort-------%>
    <div>
        <span>Sắp xếp theo</span>
        <form action="/users" method="get">
            <select name="sortAttribute">
                <option value="name">name</option>
                <option value="email">email</option>
                <option value="country">country</option>
            </select>
            <button name="action" value="sort" type="submit">Sort</button>
        </form>
        <%--        <a href="/users?action=sort&sortType=name">name</a>--%>
        <%--        <a href="/users?action=sort&sortType=email">email</a>--%>
        <%--        <a href="/users?action=sort&sortType=country">country</a>--%>
    </div>
    <br>

    <%--        form tim kiem--%>
    <form action="/users" method="get">
        <input type="text" placeholder="input country users search" name="inputSearch">
        <button type="submit" name="action" value="search">search</button>
    </form>

    <table border="1px">
        <c:forEach var="user1" items="${userList1}">
            <tr>
                <td><c:out value="ID: ${user1.id}"/></td>
                <td><c:out value="NAME: ${user1.name}"/></td>
                <td><c:out value="EMAIL: ${user1.email}"/></td>
                <td><c:out value="COUNTRY: ${user1.country}"/></td>
            </tr>
        </c:forEach>
    </table>

    <h2 style="color: red">${mess}</h2>
</center>
<div align="center" id="display">
    <table border="1" cellpadding="5">
        <h2>List of Users</h2>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
