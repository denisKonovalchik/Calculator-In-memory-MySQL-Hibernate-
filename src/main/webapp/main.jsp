<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gudwin
  Date: 04.08.2021
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="_header.jsp"/>
<html>
<head>
    <title>Calculation</title>
    <style type="text/css">
    </style>

</head>
<body>

<script src="js/anime.js"></script>
<ul>
    <c:forEach items="${requestScope.addresses}" var="address">
        <li>${address}/></li>
    </c:forEach>
</ul>

<script>

</script>

</body>
</html>
