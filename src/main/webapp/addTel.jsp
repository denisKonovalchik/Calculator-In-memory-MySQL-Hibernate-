<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 16.09.2021
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="_header.jsp"/>
<html>
<head>
    <title>Add telephone number</title>
</head>
<body>
<div class="container" >
    <div class="row justify-content-center" >
        <div class="col-sm-3" style="padding: 30px 20px 20px; border-radius:8px; background: #e3f2fd; margin-top: 40px" >
            <legend style="text-align: center; padding-bottom: 20px">Add telephone number</legend>
            <form action="/addTel" method="post">
                <div class="mb-3">
                    <input type="number" name="phoneNumber" class="form-control"  required placeholder="Phone number">
                </div>
                <div style="text-align: center; padding-bottom: 10px">
                    <button type="submit" class="btn btn-success" style="">Submit</button>
                </div>
                <div style="text-align: center">
                    <a href="/telephone">Return</a>
                </div>
            </form>
            <c:if test="${requestScope.messageTelephoneAdd1 != null}">
                <div class="alert alert-success" role="alert">
                    <p>${requestScope.messageTelephoneAdd1}</p>
                </div>
            </c:if>
            <c:if test="${requestScope.messageTelephoneAdd2 != null}">
                <div class="alert alert-danger" role="alert">
                    <p>${requestScope.messageTelephoneAdd2}</p>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
