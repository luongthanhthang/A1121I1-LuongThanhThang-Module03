<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 20-May-22
  Time: 12:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="/translate" method="post">
    <input type="text" name="english" placeholder="Enter your word: "/>
    <input type="submit" id="submit" value="Search"/>
</form>
</body>
<h1>Result English to VietNam: ${resultVietnam}</h1>
</html>
