<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 15.09.2021
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="_header.jsp"/>
<html>
<head>
    <title>Edit Address</title>
</head>
<body>

<div class="container" >
    <div class="row justify-content-center" >
        <div class="col-sm-3" style="padding: 30px 20px 20px; border-radius:8px; background: #e3f2fd; margin-top: 40px" >
            <legend style="text-align: center; padding-bottom: 20px">Edit address</legend>
            <form action="/editAddr" method="post">
                <div class="mb-3" >
                    <input type="text" name="newCity" class="form-control"  aria-describedby="emailHelp" required placeholder="New city">
                </div>
                <div class="mb-3">
                    <input type="text" name="newStreet" class="form-control"  aria-describedby="emailHelp" required placeholder="New street" >
                </div>
                <div class="mb-3">
                    <input type="number" name="newHomeNumber" class="form-control"  required placeholder="New home number">
                </div>
                <div class="mb-3">
                    <input type="number" name="newApartNumber" class="form-control"  required placeholder="New apartment number">
                </div>
                <div style="text-align: center; padding-bottom: 10px">
                    <button type="submit" class="btn btn-success" style="">Submit</button>
                </div>
                <div style="text-align: center">
                    <a href="/profile">Return to profile</a>
                </div>
            </form>
            <c:if test="${requestScope.messageAddressEdit1 != null}">
                <div class="alert alert-success" role="alert">
                    <p>${requestScope.messageAddressEdit1}</p>
                </div>
            </c:if>
            <c:if test="${requestScope.messageAddressEdit2 != null}">
                <div class="alert alert-danger" role="alert">
                    <p>${requestScope.messageAddressEdit2}</p>
                </div>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
