<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 13.09.2021
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="_header.jsp"/>
<html>
<head>
    <title>Edit Telephone</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-center" >
        <div class="col-sm-3" style="padding: 30px 20px 20px; border-radius:8px; background: #e3f2fd; margin-top: 40px" >
            <legend style="text-align: center; padding-bottom: 20px">Edit telephone</legend>
            <form action="/editTel" method="post">
                <div class="mb-3">
                    <input type="number" name="newNumber" class="form-control" value="${sessionScope.telephone.number}"  aria-describedby="emailHelp" required placeholder="New phone number">
                </div>
                <div style="text-align: center; padding-bottom: 10px">
                    <button type="submit" class="btn btn-success">Submit</button>
                </div>
                <div style="text-align: center">
                    <a href="/profile">Return to profile</a>
                </div>
            </form>
            <c:if test="${requestScope.messageTelephoneEdit1 != null}">
                <div class="alert alert-success" role="alert">
                    <p>${requestScope.messageTelephoneEdit1}</p>
                </div>
            </c:if>
            <c:if test="${requestScope.messageTelephoneEdit2 != null}">
                <div class="alert alert-danger" role="alert">
                    <p>${requestScope.messageTelephoneEdit2}</p>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
