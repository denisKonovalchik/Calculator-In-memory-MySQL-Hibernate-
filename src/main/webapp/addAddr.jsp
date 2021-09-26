<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 16.09.2021
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="_header.jsp"/>
<html>
<head>
    <title>Add address</title>
</head>
<body>
<div class="container" >
    <div class="row justify-content-center" >
        <div class="col-sm-3" style="padding: 30px 20px 20px; border-radius:8px; background: #e3f2fd; margin-top: 40px" >
            <legend style="text-align: center; padding-bottom: 20px">Add address</legend>
            <form action="/addAddr" method="post">
                <div class="mb-3" >
                    <input type="text" name="city" class="form-control"  aria-describedby="emailHelp" required placeholder="City">
                </div>
                <div class="mb-3">
                    <input type="text" name="street" class="form-control"  aria-describedby="emailHelp" required placeholder="Street" >
                </div>
                <div class="mb-3">
                    <input type="number" name="homeNumber" class="form-control"  required placeholder="Home number">
                </div>
                <div class="mb-3">
                    <input type="number" name="apartNumber" class="form-control"  required placeholder="Apartment number">
                </div>
                <div style="text-align: center; padding-bottom: 10px">
                    <button type="submit" class="btn btn-success" style="">Submit</button>
                </div>
                <div style="text-align: center">
                    <a href="/address">Return</a>
                </div>
            </form>
            <c:if test="${requestScope.messageAddressAdd1 != null}">
                <div class="alert alert-success" role="alert">
                    <p>${requestScope.messageAddressAdd1}</p>
                </div>
            </c:if>
            <c:if test="${requestScope.messageAddressAdd2 != null}">
                <div class="alert alert-danger" role="alert">
                    <p>${requestScope.messageAddressAdd2}</p>
                </div>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
