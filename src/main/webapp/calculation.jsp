<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 30.07.2021
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="_header.jsp"/>
<html>
<head>
    <title>Calculator</title>
<%--    <style type="text/css">--%>

<%--        *{--%>
<%--            font: 16px Comic Sans MS, Comic Sans, cursive;--%>
<%--        }--%>

<%--        body{--%>
<%--            background-color: #e6f4f5;--%>
<%--        }--%>

<%--        .place{--%>
<%--            position: absolute;--%>
<%--            top: 150px;--%>
<%--            left: 350px;--%>
<%--        }--%>

<%--        .btn {--%>
<%--            text-decoration: none;--%>
<%--            background: #f79411;--%>
<%--            border: 1px solid  #f79411;--%>
<%--            border-radius: 6px;--%>
<%--            color: white;--%>
<%--            font: 20px Comic Sans MS, Comic Sans, cursive;--%>
<%--            -webkit-transition-duration: 0.4s; /* Safari */--%>
<%--            transition-duration: 0.4s;--%>
<%--            cursor: pointer;--%>
<%--        }--%>
<%--        .btn:hover {--%>
<%--            background-color: white;--%>
<%--            color: #f79411;--%>
<%--        }--%>

<%--        .href{--%>
<%--            color: #9c12c9;--%>
<%--            text-align: center;--%>
<%--            font: 16px Comic Sans MS, Comic Sans, cursive;--%>
<%--            cursor: pointer;--%>
<%--        }--%>

<%--    </style>--%>

</head>
<body>
<div class="container">
    <div class="row justify-content-center" >
        <div class="col-sm-8" style="padding: 60px 20px 20px ; border-radius:8px; background: #f5f8fa; margin-top: 40px" >
            <form class="row gx-3 gy-2 " action="/calculation" method="post">
                <div class="col-sm-3"  >
                    <input type="number" name="num1" step="0.001" required class="form-control"  placeholder="Num1">
                </div>
                <div class="col-sm-3">
                    <input type="number" name="num2" step="0.001" required class="form-control" placeholder="Num2">
                </div>
                <div class="col-sm-3">
                    <select class="form-select" name="operation">
                        <option selected disabled>Select operation</option>
                                 <option value="addition">Addition</option>
                                 <option value="division">Division</option>
                                 <option value="multiplication">Multiplication</option>
                                 <option value="subtraction">Subtraction</option>
                    </select>
                </div>
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-outline-dark">Calculation</button>
                </div>
                <p class="font-style" style="padding-top: 30px; text-align: left; font-size: 20px"> Result: ${requestScope.result}</p>
            </form>
        </div>
    </div>
</div>
</body>
</html>
