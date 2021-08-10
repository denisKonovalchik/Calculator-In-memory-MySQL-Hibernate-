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
    <style type="text/css">
        body{
            background-color: #e6f4f5;
            position: fixed; /* Фиксированное положение */
            left: 50%; /* Расстояние от правого края окна браузера */
            top: 40%; /* Расстояние сверху */
            transform: translate(-50%, -50%);
        }

        .btn {
            text-decoration: none;
            background: #f79411;
            border: 1px solid  #f79411;
            border-radius: 6px;
            color: white;
            text-align: center;
            font: 16px Comic Sans MS, Comic Sans, cursive;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            cursor: pointer;
        }
        .btn:hover {
            background-color: white;
            color: #f79411;
        }

    </style>

</head>
<body>
<form action="/authorization" method="post">
    <label for="login">Login</label>
    <input type="text" name="login" required id="login">
    <label for="password">Password</label>
    <input type="text" name="password" required id="password">
    <button class="btn">Authorization</button><br>
</form>
</body>
</html>
