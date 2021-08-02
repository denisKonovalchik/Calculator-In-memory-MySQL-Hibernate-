<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 30.07.2021
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculation" method="post">
    <input type="number" step="any" name="num1"  placeholder="Number 1">
    <input type="number" step="any" name="num2" placeholder="Number 2">
    <input type="text" name="operation" placeholder="Operation">
    <button>Calculation</button>
</form>
<p> Result: ${requestScope.result}</p>

<form action="/logsHistory" method="get">
    <button>History</button>
</form>
<form action="/logout" method="get">
    <button>Logout</button>
</form>
</body>
</html>
