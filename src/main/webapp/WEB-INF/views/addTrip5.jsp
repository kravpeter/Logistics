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


<main role="main">
        <table>
            <c:forEach var="city" items="${checkpointCities}" varStatus="status">
                    <tr>
                        <td>${city.cityName}</td>
                        <td></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>${distances[status.index]}</td>
                    </tr>
            </c:forEach>
        </table>
    <form:form action="/addTrip4" method="post" class="form">

        <label class="mr-sm-2" for="CitySelect2"><br>You can either add one more waypoint in the trip or go to cargoes filling:<br></label>
        <select class="form-control mb-2 mr-sm-2 mb-sm-0" id="CitySelect2" name="checkpointCity">
            <option selected>Choose...</option>
            <c:forEach items="${cities}" var="c">
                <option value="${c.cityId}">${c.cityName}</option>
            </c:forEach>
        </select>
        <input type="submit" class="btn btn-outline-secondary" onclick="form.action='/addTrip4'; "value="Add checkpoint">
        <input type="submit" class="btn btn-outline-secondary" onclick="form.action='/addTrip42';" value="Go to cargoes">


    </form:form>


</main>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="/resources/js/jquery-slim.min.js"><\/script>')</script>
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
