<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 01.08.2021
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="_header.jsp"/>
<html>
<head>
    <title>Registration</title>

</head>
<body>
<div class="container" >
    <div class="row justify-content-center" >
        <div class="col-sm-3" style="padding: 30px 20px 20px; border-radius:8px; background: #e3f2fd; margin-top: 20px" >
            <legend style="text-align: center; padding-bottom: 20px">Please Sign up</legend>
            <form action="/registration" method="post">
                <div class="mb-3" >
                    <input type="text" name="name" class="form-control"  aria-describedby="emailHelp" required placeholder="Name">
                </div>
                <div class="mb-3">
                    <input type="email" name="email" class="form-control" id="exampleInputEmail12" aria-describedby="emailHelp" required placeholder="Email" >
                </div>
                <div class="mb-3">
                    <input type="password" name="password" class="form-control" aria-describedby="passwordHelp" required placeholder="Password">
                    <div id="passwordHelp" class="form-text" style="text-align: center">Do not share your password with anyone else</div>
                </div>
                <div class="mb-3" >
                    <input type="number" name="telephoneNumber" class="form-control"  aria-describedby="emailHelp" required placeholder="Telephone number">
                </div>
                <div class="mb-3" >
                    <input type="text" name="city" class="form-control"  aria-describedby="emailHelp" required placeholder="City">
                    <input type="text" name="street" class="form-control"  aria-describedby="emailHelp" required placeholder="Street">
                    <input type="text" name="homeNumber" class="form-control"  aria-describedby="emailHelp" required placeholder="Home number">
                    <input type="text" name="apartNumber" class="form-control"  aria-describedby="emailHelp" required placeholder="Apart number">
                </div>
                <div style="text-align:center">
                <button type="submit" class="btn btn-success" style="">Sign-up</button>
                </div>
            </form>
            <c:if test="${requestScope.message1 != null}">
                <div class="alert alert-success" role="alert">
                    <p>${requestScope.message1}</p>
                </div>
            </c:if>

            <c:if test="${requestScope.message2 != null}">
                <div class="alert alert-danger" role="alert">
                    <p>${requestScope.message2}</p>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
