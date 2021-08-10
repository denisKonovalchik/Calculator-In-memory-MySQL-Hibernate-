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

    <style type="text/css">

    body{
    background-color: #e6f4f5;
    position: fixed; /* Фиксированное положение */
    left: 50%; /* Расстояние от правого края окна браузера */
    top: 20%; /* Расстояние сверху */
    transform: translate(-50%, -50%);
    }

    .text{
        display:inline;
        color: #9c12c9;
        text-align: center;
        font: 16px Comic Sans MS, Comic Sans, cursive;
        cursor: pointer;
    }

    </style>

</head>
<body>
<h2 style="font: 16px Comic Sans MS, Comic Sans, cursive;">Operation history:</h2>
<form action="/logHistory" method="get">
    <ul>
    <c:forEach items="${requestScope.history}" var="operation">
        <li>Num1: ${operation.num1}; Num2: ${operation.num2}; Operation: ${operation.operation}; Result: ${operation.result}; Name: ${operation.user.getName()}</li>
    </c:forEach>
    </ul>
<a href="/calculation" class="text" >Return to calculator</a>
</form>
</body>
</html>
