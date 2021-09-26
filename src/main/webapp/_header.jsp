<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 16.08.2021
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nosifer&display=swap" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light mb-5"  style="background-color: #e3f2fd">
    <div class="container-fluid ">
        <a class="navbar-brand" href="/calculation" style="font-family: 'Nosifer', cursive;" >
            <img src="/images/calc_top3.png" alt="" width="36" height="30" class="d-inline-block align-text-top">
            Calculator
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="padding-left: 800px">
                <li class="nav-item">
                    <a class="nav-link active" href="/authorization">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active"  href="/registration">Sign-up</a>
                </li>
                <c:if test="${sessionScope.user != null}">
                <li class="nav-item">
                    <a class="nav-link active" href="/history" >History</a>
                </li>
                </c:if>
                <li style="padding-left: 150px">
                    <div class="pull-right navbar-text">
                        <c:if test="${sessionScope.user == null}">
                            <a class="pull-right navbar-text" href="#" style="padding-right: 5px">Guest</a>
                            <img src="/images/avatar_1.png" width="30" height="30" style="border-radius: 100px">
                        </c:if>

                        <c:if test="${sessionScope.user != null}">
                            <a class="pull-right navbar-text" href="#" style="padding-right: 5px"> ${sessionScope.user.name} </a>
                            <img src="/images/avatar_1.png" width="30" height="30" style="border-radius: 100px">

                            <li class="nav-item dropdown" style="padding-top: 13px; padding-left: 0">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"></a>
                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="/profile">Profile</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="/logout">Sign-out</a></li>
                                </ul>
                            </li>
                        </c:if>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<script src=" https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>


