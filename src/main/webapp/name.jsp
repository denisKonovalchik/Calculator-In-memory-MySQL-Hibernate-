<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 21.08.2021
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="_header.jsp"/>
<html>
<head>
    <title>Title</title>

</head>
<body>

<div class="container">
    <div class="row justify-content-center" >
        <div class="col-sm-3" style="padding: 30px 20px 20px; border-radius:8px; background: #e3f2fd; margin-top: 40px" >
            <legend style="text-align: center; padding-bottom: 20px">Change name</legend>
            <form action="/name" method="post">
                <div class="mb-3">
                    <input type="text" name="newName" class="form-control" value="${sessionScope.user.name}"  aria-describedby="emailHelp" required placeholder="New name">
                </div>
                <div style="text-align: center; padding-bottom: 10px">
                    <button type="submit" class="btn btn-success">Change name</button>
                </div>
                <div style="text-align: center">
                <a href="/profile">Return to profile</a>
            </div>
            </form>
            <c:if test="${requestScope.messageName!= null}">
                <div class="alert alert-success" role="alert">
                    <p>${requestScope.messageName}</p>
                </div>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
