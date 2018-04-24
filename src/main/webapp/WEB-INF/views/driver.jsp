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

<main role="main">
    <h2>Driver's UI</h2>
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext"
                       id="name" value="${driver.driverUser.userName} ${driver.driverUser.userSurname}">
            </div>
        </div>
        <div class="form-group row">
            <label for="id" class="col-sm-2 col-form-label">Driver's ID</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext"
                       id="id" value="${driver.driverId}">
            </div>
        </div>
        <form:form action="changeDriverStatus" method="post">

            <label class="mr-sm-2" for="ChangeDriverStatus">Driver status: ${driver.driverStatus}</label>
            <select class="form-control mb-2 mr-sm-2 mb-sm-0" id="ChangeDriverStatus" name="changeDriverStatus">
                <option value="driving">"driving"</option>
                <option value="second driver">"second driver"</option>
                <option value="loading">"loading"</option>
                <option value="rest" >"rest"</option>
            </select>
            <input type="submit" class="btn btn-outline-secondary" value="Change driver status">

        </form:form>
        <div class="form-group row">
            <label for="hours" class="col-sm-2 col-form-label">Hours</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext"
                       id="hours" value="${driver.driverHours}">
            </div>
        </div>
        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext"
                       id="email" value="${driver.driverUser.email}">
            </div>
        </div>
        <div class="form-group row">
            <label for="truck" class="col-sm-2 col-form-label">Truck:</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext"
                       id="truck" value="${driver.driverTruck.truckRegNumber}">
            </div>
        </div>
        <div class="form-group row">
            <label for="partners" class="col-sm-2 col-form-label">Partners:</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext"
                       id="partners" value="">
            </div>
        </div>
        <div class="form-group row">
            <label for="tripNumb" class="col-sm-2 col-form-label">Trip number:</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext"
                       id="tripNumb" value="${driver.driverTrip.tripId}">
            </div>
        </div>
        <table>
            <c:forEach items="${checkpoints}" var="checkpoint" varStatus="status">
                <tr>
                    <td>
                        <label for="checkpoint" class="col-sm-2 col-form-label">Checkpoint:</label>
                    </td>
                    <td>
                        <input type="text" readonly class="form-control-plaintext"
                               id="checkpoint" value="${checkpoint.checkpointArrCity.cityName}">
                    </td>
                    <td>
                        <input type="text" readonly class="form-control-plaintext"
                               id="status" value="${checkpoint.checkpointStatus}">
                    </td>
                    <td>
                        <c:forEach items="${checkpoint.checkpointCargoes}" var="cargo">
                        ${cargo.cargoType} ${cargo.cargoWeight} ${cargo.cargoStatus} <br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="driverStatus" class="btn btn-outline-secondary">Change status</a>
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
