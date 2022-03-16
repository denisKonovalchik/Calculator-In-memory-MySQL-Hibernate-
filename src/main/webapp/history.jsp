<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 01.08.2021
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_header.jsp"/>
<html>
<head>
    <title>History</title>
</head>
<body>

<div class="container">
    <div class="row justify-content-center" >
        <div class="col-sm-6">
            <form action="/history" method="post">
                <table class="table table-hover table-light table-bordered caption-top">
                    <caption>Operations history</caption>
                    <thead>
                    <tr>
                        <th scope="col">Num1</th>
                        <th scope="col">Num2</th>
                        <th scope="col">Operation</th>
                        <th scope="col">Result</th>
                        <th scope="col">Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.history}" var="operation">
                    <tr>
                        <td>${operation.num1}</td>
                        <td>${operation.num2}</td>
                        <td>${operation.operation}</td>
                        <td>${operation.result}</td>
                        <td>${operation.user.name}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
            <form action="/history" method="post">
                <div class="btn-group" role="group" aria-label="Basic example">
                    <button type="submit"  name="page" value="1">1</button>
                    <button type="submit" name="page" value="2">2</button>
                    <button type="submit" name="page" value="3">3</button>
                </div>
                <p><a href="/calculation" class="my-font">Return to calculator</a></p>
            </form>
        </div>
    </div>
</div>
</body>
</html>
