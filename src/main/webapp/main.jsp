<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 04.08.2021
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation</title>

    <style type="text/css">

    body{
        background-color: #e6f4f5;
    }

    .place{
        position: fixed; /* Фиксированное положение */
        left: 50%; /* Расстояние от правого края окна браузера */
        top: 40%; /* Расстояние сверху */
        transform: translate(-50%, -50%);
    }

    .btn{
         text-decoration: none;
         background: #f79411;
         border: 1px solid  #f79411;
         border-radius: 6px;
         color: white;
         text-align: center;
         font: 16px Comic Sans MS, Comic Sans, cursive;
         padding: 18px 32px;
         -webkit-transition-duration: 0.4s; /* Safari */
         transition-duration: 0.4s;
         margin-bottom: 15px;
         cursor: pointer;
    }
    .btn:hover {
        background-color: white;
        color: #f79411;
    }
    </style>

</head>
<body>

<div class="place">
<a href="/registration" class="btn">Registration</a>
<a href="/authorization" class="btn">Authorization</a>

</div>
</body>
</html>
