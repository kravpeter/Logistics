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

    <title>Manager's UI</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jumbotron.css"/>">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top bg-light">
    <a class="navbar-brand" href="#">
        <img src="<c:url value="/resources/img/truck.svg"/>" width="30" height="30" class="d-inline-block align-top" alt="Click to description">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="manager-navbar">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="trips">TRIPS <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="trucks">VEHICLES<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="drivers">DRIVERS<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="cities">CITIES<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="post" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            <span class="navbar-text"> Manager: ${pageContext.request.userPrincipal.name}  |  </span> <span><a class="nav-link" href="#" onclick="document.forms['logoutForm'].submit()">Logout</a></span>
        </c:if>
    </div>
</nav>


<div class="container">
    <h1>Add cargoes</h1>
<h4>${waypoints}</h4>
<h4>Truck capacity: ${truck.truckCapacity} ton</h4>
    <table>
        <c:forEach items="${cargoes}" var="cargo">
            <tr>
                <td>${cargo.city.cityName}</td>
                <td>${cargo.cargoType}</td>
                <td>${cargo.cargoWeight}</td>
                <td>${cargo.cargoStatus}</td>
            </tr>
        </c:forEach>
    </table>
    <form:form action="/addTrip6" method="post" class="form-inline">
        <label class="mr-sm-2" for="CitySelect1"> City of loading:</label>
        <select class="form-control mb-2 mr-sm-2 mb-sm-0" id="CitySelect1" name="checkpointIn">
            <option selected>Choose...</option>
            <c:forEach items="${checkpoints}" var="c">
                <option value="${c.cityId}">${c.cityName}</option>
            </c:forEach>
        </select>
        <label class="mr-sm-2" for="CitySelect2">Loading out:</label>
        <select class="form-control mb-2 mr-sm-2 mb-sm-0" id="CitySelect2" name="checkpointOut">
            <option selected>Choose...</option>
            <c:forEach items="${checkpoints}" var="c">
                <option value="${c.cityId}">${c.cityName}</option>
            </c:forEach>
        </select>
        <label for="cargoType" class="mr-sm-2">Type of cargo:</label>
        <input class="form-control mb-2 mr-sm-2 mb-sm-0" type="text" value="20" id="cargoType" name="cargoType">
        <label for="weightInput" class="mr-sm-2">Weight:</label>
        <input class="form-control mb-2 mr-sm-2 mb-sm-0" type="number" value="20" id="weightInput" name="weight">

        <div><input type="submit" class="btn btn-outline-secondary" value="Add cargo"></div>

    </form:form>
    <a href="/addTrip7" class="btn btn-outline-secondary">Confirm trip</a>
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
