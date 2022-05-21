<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 22-May-22
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculate" method="post" style="width: 60%">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td><label for="number1">First operand:</label></td>
                <td><input type="number" name="first-number" id="number1"></td>
            </tr>
            <tr>
                <td><label for="operator">Operator:</label></td>
                <td><select name="operator-input" id="operator">
                    <option value="+">addition</option>
                    <option value="-">subtraction</option>
                    <option value="*">multiplication</option>
                    <option value="/">division</option>
                </select></td>
            </tr>
            <tr>
                <td><label for="number2">Second operand:</label></td>
                <td><input type="number" name="second-number" id="number2"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"></td>
            </tr>
        </table>
    </fieldset>
</form>
<h2>Result: ${result}</h2>
</body>
</html>
