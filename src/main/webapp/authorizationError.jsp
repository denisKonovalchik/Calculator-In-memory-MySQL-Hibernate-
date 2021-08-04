<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 01.08.2021
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation</title>
</head>
<body>
<p> ${requestScope.messageError} </p>
<form action="/authorization" method="get">
    <button>Authorization</button>
</form>
</body>
</html>
