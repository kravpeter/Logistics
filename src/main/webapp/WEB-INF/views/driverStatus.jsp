<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="icon" href="<c:url value="/resources/img/truck-front.png"/>">

    <title>Driver's's UI</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jumbotron.css"/>">
</head>

<body>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="post" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <div class="d-inline">
        <span class="text-right"> Manager: ${pageContext.request.userPrincipal.name}  |  <a class="nav-link" href="#" onclick="document.forms['logoutForm'].submit()">Logout</a></span>
    </div>
</c:if>

<div class="container">
    <h6>Have you passed checkpoint ${currentCheckpoint.checkpointArrCity.cityName}?</h6>
    <form:form action="driverStatus" method="post">


        <button type="submit" class="btn btn-outline-secondary">Yes</button>
        <a href="driver" class="btn btn-outline-secondary">No</a>

    </form:form>

</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="/resources/js/jquery-slim.min.js"><\/script>')</script>
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
