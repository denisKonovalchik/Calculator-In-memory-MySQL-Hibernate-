<%@ page import="by.konovalchik.entity.Operation" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 01.08.2021
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h3>Operations history:</h3>
<form action="/logsHistory" method="get"></form>
<table border="1">
    <tr>
        <th>Num1</th>
        <th>Num2</th>
        <th>Operation</th>
        <th>Result</th>
        <th>Login</th>
        <th>Password</th>

    </tr>
    <c:forEach items="${history}" var="operation">
    <tr>
        <td>${operation.num1}</td>
        <td>${operation.num2}</td>
        <td>${operation.operation}</td>
        <td>${operation.result}</td>
        <td>${operation.user.getLogin()}</td>
        <td>${operation.user.getPassword()}</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
