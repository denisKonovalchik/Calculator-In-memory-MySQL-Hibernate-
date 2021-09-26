<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 14.09.2021
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="_header.jsp"/>
<html>
<head>
    <title>Address</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-center" >
        <div class="col-sm-4" style="border-radius:8px; background: #e3f2fd; margin-top: 20px" >
            <div class="card" style=" margin: 20px 20px 20px ">
                <div class="card-header" style="text-align: center">
                    Addresses
                </div>
                <ol class="list-group list-group-numbered">
                    <c:forEach items="${sessionScope.addresses}" var="address">
                        <li class="list-group-item" ><b>${address.city},${address.street},${address.homeNumber}-${address.apartNumber}</b>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end" >
                                <div type="btn-group">
                                    <form  action="/address" method="post">
                                        <button class="btn btn-outline-danger btn-sm" type="submit" name="idAddrDelete" value="${address.id}">Delete</button>
                                    </form>
                                </div>
                                <div type="btn-group">
                                    <form action="/editAddr" method="get">
                                        <button class="btn btn btn-outline-warning btn-sm"  type="submit" name="idAddrUpdate" value="${address.id}">Edit</button>
                                    </form>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ol>

                <div class="card-body">
                    <a href="/addAddr" style="padding-left: 10px">Add address</a>
                    <a href="/profile" style="padding-left:  90px">Return to profile</a>
                </div>
                <c:if test="${requestScope.messageAddress1 != null}">
                    <div class="alert alert-success" role="alert">
                        <p>${requestScope.messageAddress1}</p>
                    </div>
                </c:if>
                <c:if test="${requestScope.messageAddress2 != null}">
                    <div class="alert alert-danger" role="alert">
                        <p>${requestScope.messageAddress2}</p>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>



</body>
</html>
