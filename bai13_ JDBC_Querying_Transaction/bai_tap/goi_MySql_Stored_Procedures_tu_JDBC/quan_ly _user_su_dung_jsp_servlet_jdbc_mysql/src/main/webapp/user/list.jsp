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

    <link rel="stylesheet" href="/template/bootstrap/css/bootstrap.css">
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

    <c:if test="${mess !=null}">
        <p class="text-danger">${mess}</p>
    </c:if>

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
                </td>
                <td>
                    <!-- Button trigger modal -->
                    <button type="button" onclick="showInfo('${user.id}','${user.name}')" class="btn btn-danger"
                            data-bs-toggle="modal"
                            data-bs-target="#deleteModal">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <%--            ---------thêm thẻ form---------%>
        <form action="/users?action=delete" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-danger" id="exampleModalLabel">Xác nhận xoá !</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden id="idUser" name="idDelete">
                    <span>Bạn có muốn xóa User </span>
                    <span class="text-danger" id="nameUser"></span><span>không?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" name="action" value="delete">Delele</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function showInfo(id, name) {
        document.getElementById("idUser").value = id;
        document.getElementById("nameUser").innerText = name;
    }
</script>
</body>
<script src="/template/bootstrap/jquery-3.6.0.min.js"></script>
<script src="/template/bootstrap/js/bootstrap.js"></script>
</html>
