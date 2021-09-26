<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 21.08.2021
  Time: 11:54
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
        <div class="col-sm-3" style="padding: 20px 20px 20px; border-radius:8px; background: #e3f2fd; margin-top: 10px" >
            <form action="/profile" method="get">
                <div class="card" style="width: 18rem;">
                    <div class="card-header" style="text-align: center">
                        User profile
                    </div>
                    <img src="images/ava.jpg" class="card-img-top">
<%--                    <div class="card-body">--%>
<%--                        <h6 class="card-title"></h6>--%>
<%--                        <p class="card-text"> </p>--%>
<%--                    </div>--%>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><b>name:</b> ${sessionScope.user.name}<a style="float:right " href="/name" class="card-link"><img style="height: 20px; width: 20px" src="/images/edit.jpg"></a></li>
                        <li class="list-group-item"><b>email:</b> ${sessionScope.user.email}</li>
                        <li class="list-group-item"><b>addresses:</b><a style="float:right " href="/address" class="card-link"><img style="height: 20px; width: 20px" src="/images/edit.jpg"></a></li>
                        <c:forEach items="${sessionScope.addresses}" var="address">
                        <li class="list-group-item"> ${address.city}, ${address.street}, ${address.homeNumber}-${address.apartNumber}</li>
                        </c:forEach>
                        <li class="list-group-item"><b>telephones:</b><a style="float:right " href="/telephone" class="card-link"><img style="height: 20px; width: 20px" src="/images/edit.jpg"></a></li>
                        <c:forEach items="${sessionScope.telephones}" var="telephone">
                            <li class="list-group-item"> +${telephone.number}</li>
                        </c:forEach>
                        <li class="list-group-item"><b>password:</b> ********<a style="float:right " href="/pass" class="card-link"><img style="height: 20px; width: 20px" src="/images/edit.jpg"></a></li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
