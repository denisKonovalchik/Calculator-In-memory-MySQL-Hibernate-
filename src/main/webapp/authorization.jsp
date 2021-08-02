<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 31.07.2021
  Time: 00:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/authorization" method="post">
    <input type="text" name="login" placeholder="Login">
    <input type="text" name="password" placeholder="Password">
    <button>Authorization</button>
</form>
<p> ${requestScope.message} </p>
<form action="/registration" method="get">
    <button>Registration</button>
</form>
</body>
</html>
