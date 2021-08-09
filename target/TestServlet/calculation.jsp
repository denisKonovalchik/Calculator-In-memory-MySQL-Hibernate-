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
    <style type="text/css">
        body{
            background-color: #8ef5f1;
        }
        .place{
            position: fixed; /* Фиксированное положение */
            left: 50%; /* Расстояние от правого края окна браузера */
            top: 20%; /* Расстояние сверху */
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

        .href{
            display:inline;
            color: #9c12c9;
            text-align: center;
            font: 16px Comic Sans MS, Comic Sans, cursive;
            cursor: pointer;
        }

    </style>

</head>
<body>
<form class="place" action="/calculation" method="post">
    <input type="number" step="0.001" name="num1" required placeholder="Number 1">
    <input type="number" step="0.001" name="num2" required placeholder="Number 2">
    <select name="operation">
         <option value="addition">Addition</option>
         <option value="division">Division</option>
         <option value="multiplication">Multiplication</option>
         <option value="subtraction">Subtraction</option>
    </select>
    <button class="btn">Calculation</button>
    <p style="font: 16px Comic Sans MS, Comic Sans, cursive;"> Result: ${requestScope.result}</p>
<div class="href" >
    <p><a href="/logHistory">History</a></p>
    <p><a href="/logout">Logout</a></p>
</div>
</form>

</body>
</html>
