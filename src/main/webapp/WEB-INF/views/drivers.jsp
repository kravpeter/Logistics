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
        <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#ModalEditDriver">Edit</button>
        <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#ModalDriverDelete">Delete</button>
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
    <!-- Modal Add-->
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
                    <spring:bind path="driverStatus"><form:input type="hidden" path="driverStatus" value="off-work"/></spring:bind>
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
    <!-- Modal Edit-->
    <div class="modal fade" id="ModalEditDriver" tabindex="-1" role="dialog" aria-labelledby="ModalEditDriverTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="ModalEditDriverTitle">Edit a Driver</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>


                <form:form action="drivers/edit" method="POST">
                <div class="modal-body">
                    <div class="form-group row">
                            <label for="driverEmailSelect" class="col-5 col-form-label">Driver:</label>
                            <div class="col-5 form-group row">
                                <select id = "driverEmailSelect" name="driverId">
                                    <c:forEach items="${driversList}" var="driver" varStatus="status">
                                        <option value="${driver.driverId}">${driver.driverUser.email}</option>
                                    </c:forEach>
                                </select>
                            </div>
                    </div>

                    <div class="form-group row">
                            <label for="driverName" class="col-5 col-form-label">Name:</label>
                            <div class="col-5 form-group row">
                                <input type="text" id="driverName" name="driverName" class="form-control" />
                            </div>
                    </div>

                    <div class="form-group row">
                        <label for="driverSurname" class="col-5 col-form-label">Surname:</label>
                        <div class="col-5 form-group row">
                            <input type="text" id="driverSurname" name="driverSurname" class="form-control"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="driverPhoneNumber" class="col-5 col-form-label">Phone number:</label>
                        <div class="col-5 form-group row">
                            <input type="text" id="driverPhoneNumber" name="driverPhoneNumber" class="form-control"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="driverHours" class="col-5 col-form-label">Hours:</label>
                        <div class="col-5 form-group row">
                            <input type="number" id="driverHours" name="driverHours" class="form-control"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="driverStatus" class="col-5 col-form-label">Status:</label>
                        <div class="col-5 form-group row">
                            <select id = "driverStatus" name="driverStatus">
                                <option value="off-work">off-work</option>
                                <option value="standby">standby</option>
                                <option value="driving">driving</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                            <label for="driverCity" class="col-5 col-form-label">Current location:</label>
                            <div class="col-5 form-group row">
                                <select id = "driverCity" name="driverCity">
                                    <c:forEach items="${citiesList}" var="city">
                                        <option value="${city.cityId}">${city.cityName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                    </div>
                    <button class="col-5 btn btn-lg btn-primary btn-block" type="submit">Edit driver</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal Delete -->
    <div class="modal fade" id="ModalDriverDelete" tabindex="-1" role="dialog" aria-labelledby="ModalDriverDeleteTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="ModalDriverDeleteTitle">Delete a Driver</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form:form action="drivers/delete" method="post">
                    <div class="modal-body">
                        <div class="form-group row">
                            <label for="driverSelect" class="col-5 col-form-label">Driver's email/id:</label>
                            <div class="col-5">
                                <select id="driverSelect" class="custom-select" id="reg-number-select" name="driverDelete">
                                    <c:forEach items="${driversList}" var="driver">
                                        <option value="${driver.driverId}">${driver.driverUser.email}/${driver.driverId}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" value="delete">Delete driver</button>
                    </div>
                </form:form>
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

