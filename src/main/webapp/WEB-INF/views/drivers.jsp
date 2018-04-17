<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <style type="text/css">
        acronym {
            border-bottom: none; /* Подчеркивание текста */
        }
    </style>
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
        </ul>

    </div>
</nav>

<main role="main">
    <div class="mx-3 mb-3">
        <h1>Drivers</h1>

        <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#ModalAddDriver">Add</button>
        <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#exampleModalCenter">Edit</button>
        <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#exampleModalCenter">Delete</button>
    </div>
    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">name</th>
                <th scope="col"><acronym type="" title="off-work/standby/driving">status</acronym></th>
                <th scope="col">hours</th>
                <th scope="col">current vehicle</th>
                <th scope="col">phone number</th>
                <th scope="col">e-mail</th>
                <th scope="col">partners</th>
                <th scope="col">current location</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${driversList}" var="driver">
                    <tr>
                        <td>${driver.driverUser.userName}<br>${driver.driverUser.userSurname}</td>
                        <td>${driver.driverStatus}</td>
                        <td>${driver.driverHours}</td>
                        <td></td>
                        <td>${driver.driverUser.userPhoneNumber}</td>
                        <td>${driver.driverUser.email}</td>
                        <td></td>
                        <td>${driver.driverCity.cityName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="ModalAddDriver" tabindex="-1" role="dialog" aria-labelledby="ModalAddDriverTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="ModalAddDriverTitle">Add a new Driver</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>


                <form:form action="drivers" method="POST" modelAttribute="newDriver">
                <div class="modal-body">
                    <div class="form-group row">
                        <spring:bind path="driverUser.email">
                            <label class="col-5 col-form-label">Email:</label>
                            <div class="col-5 form-group row ${status.error ? 'has-error' : ''}">
                                <input type="text" name="driverUser.email" class="form-control"/>
                                <form:errors path="driverUser.email"/>
                            </div>
                        </spring:bind>
                    </div>

                    <div class="form-group row">
                        <spring:bind path="driverUser.userPassword">
                            <label for="driverUser.userPassword" class="col-5 col-form-label">Password:</label>
                            <div class="col-5 form-group row ${status.error ? 'has-error' : ''}">
                                <form:input type="password" path="driverUser.userPassword" class="form-control"/>
                                <form:errors path="driverUser.userPassword"/>
                            </div>
                        </spring:bind>
                    </div>

                    <div class="form-group row">
                        <spring:bind path="driverUser.confirmPassword">
                            <label for="driverUser.confirmPassword" class="col-5 col-form-label">Confirm password:</label>
                            <div class="col-5 form-group row ${status.error ? 'has-error' : ''}">
                                <form:input type="password" path="driverUser.confirmPassword" class="form-control"/>
                                <form:errors path="driverUser.confirmPassword"/>
                            </div>
                        </spring:bind>
                    </div>

                    <div class="form-group row">
                        <spring:bind path="driverUser.userName">
                            <label for="driverUser.userName" class="col-5 col-form-label">Name:</label>
                            <div class="col-5 form-group row ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="driverUser.userName" class="form-control"/>
                                <form:errors path="driverUser.userName"/>
                            </div>
                        </spring:bind>
                    </div>

                    <div class="form-group row">
                        <spring:bind path="driverUser.userSurname">
                            <label for="driverUser.userSurname" class="col-5 col-form-label">Surname:</label>
                            <div class="col-5 form-group row ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="driverUser.userSurname" class="form-control"/>
                                <form:errors path="driverUser.userSurname"/>
                            </div>
                        </spring:bind>
                    </div>

                    <spring:bind path="driverUser.userRole"><form:input type="hidden" path="driverUser.userRole" value="3"/></spring:bind>

                    <div class="form-group row">
                        <spring:bind path="driverUser.userPhoneNumber">
                            <label for="driverUser.userPhoneNumber" class="col-5 col-form-label">Phone number:</label>
                            <div class="col-5 form-group row ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="driverUser.userPhoneNumber" class="form-control"/>
                                <form:errors path="driverUser.userPhoneNumber"/>
                            </div>
                        </spring:bind>
                    </div>
                    <spring:bind path="driverHours"><form:input type="hidden" path="driverHours" value="0"/></spring:bind>
                    <spring:bind path="driverStatus"><form:input type="hidden" path="driverStatus" value="0"/></spring:bind>
                    <div class="form-group row">
                        <spring:bind path="driverCity">
                            <label for="citySelect" class="col-5 col-form-label">Current location:</label>
                            <div class="col-5 form-group row">
                                <form:select id = "citySelect" path="driverCity.cityId" itemValue="">
                                    <c:forEach items="${citiesList}" var="city">
                                        <option value="${city.cityId}">${city.cityName}</option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="driverCity"/>
                            </div>
                        </spring:bind>
                    </div>
                    <button class="col-5 btn btn-lg btn-primary btn-block" type="submit">Add driver</button>
                </form:form>
                </div>
            </div>
        </div>
    </div>
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

