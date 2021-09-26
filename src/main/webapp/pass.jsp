<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 20.08.2021
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="_header.jsp"/>
<html>
<head>
    <title>Profile</title>
</head>
<body>

<div class="container">
    <div class="row justify-content-center" >
        <div class="col-sm-3" style="padding: 30px 20px 20px; border-radius:8px; background: #e3f2fd; margin-top: 40px" >
            <legend style="text-align: center; padding-bottom: 20px">Change password</legend>
            <form action="/pass" method="post">
               <div class="mb-3">
                   <input type="password" name="old password" class="form-control"  required placeholder="Old password">
               </div>
               <div class="mb-3">
                   <input type="password" name="new password" class="form-control"  required placeholder="New password">
               </div>
               <div class="mb-3">
                    <input type="password" name="confirm password" class="form-control"  required placeholder="Confirm password">
               </div>
               <div style="text-align: center; padding-bottom: 10px">
                    <button type="submit" class="btn btn-success">Change Password</button>
               </div>
                <div style="text-align: center">
                <a href="/profile">Return to profile</a>
                </div>
            </form>
            <c:if test="${requestScope.messagePassword2 != null}">
                <div class="alert alert-danger" role="alert">
                    <p>${requestScope.messagePassword2}</p>
                </div>
            </c:if>
            <c:if test="${requestScope.messagePassword1!= null}">
                <div class="alert alert-success" role="alert">
                    <p>${requestScope.messagePassword1}</p>
                </div>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>


