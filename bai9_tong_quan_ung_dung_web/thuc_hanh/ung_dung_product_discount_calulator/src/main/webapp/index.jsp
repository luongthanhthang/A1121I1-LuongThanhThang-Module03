<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 20-May-22
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        div {
            width: 300px;
            height: 250px;
            border: 1px solid
        }

        input {
            margin: 3px;
        }
    </style>
</head>
<body>
<form action="/display-discount" method="post">
    <div>
        <h2>Ứng dụng Product Discount Calculator</h2>
        <input type="text" name="productDescription" placeholder="Mô tả sản phẩm" size="30px">
        <input type="text" name="listPrice" placeholder="Giá niêm yết của sản phẩm" size="30px">
        <input type="text" name="discountPercent" placeholder="Tỷ lệ chiết khấu (phần trăm)" size="30px">
        <input type="submit" value="Calculate Discount (Tính chiết khấu)">
    </div>
</form>
</body>
</html>
