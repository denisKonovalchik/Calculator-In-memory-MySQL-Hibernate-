<%@ page import="by.konovalchik.entity.Operation" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 01.08.2021
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h3><p>Operations history:</p></h3>
<form action="/logsHistory" method="post"></form>
<table>
    <tr>
        <th>Num1</th>
        <th>Num2</th>
        <th>Operation</th>
        <th>Result</th>
        <th>Login</th>
        <th>Password</th>
    </tr>

    <c:forEach items="${requestScope.history}" var="operationList">
        <tr>
            <td>${operationList.num1}</td>
            <td>${operationList.num2}</td>
            <td>${operationList.result}</td>
            <td>${operationList.user.getlogin()}</td>
            <td>${operationList.user.getpassword()}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
