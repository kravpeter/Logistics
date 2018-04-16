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

    <title>Admin's UI</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jumbotron.css"/>">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

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
    <div class="container">

        <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Manager registration</h2>



        <div class="col-3">
            <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label>Email:</label>
                    <form:input type="text" path="email" id="email"/>
                    <form:errors path="email"/>
                </div>
            </spring:bind>
        </div>

        <div class="form-group row">
            <label for="userPassword" class="col-3 col-form-label">Password:</label>
            <div class="col-3">
                <spring:bind path="userPassword">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="userPassword" class="form-control" placeholder="password"
                                    autofocus="true"></form:input>
                        <form:errors path="userPassword"></form:errors>
                    </div>
                </spring:bind>
            </div>
        </div>

        <div class="form-group row">
            <label for="confirmPassword" class="col-3 col-form-label">Confirm password:</label>
            <div class="col-3">
                <spring:bind path="confirmPassword">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="confirmPassword" class="form-control" placeholder="confirm password"
                                    autofocus="true"></form:input>
                        <form:errors path="confirmPassword"></form:errors>
                    </div>
                </spring:bind>
            </div>
        </div>

        <div class="form-group row">
            <label for="userName" class="col-3 col-form-label">Name:</label>
            <div class="col-3">
                <spring:bind path="userName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="userName" class="form-control" placeholder="name"
                                    autofocus="true"></form:input>
                        <form:errors path="userName"></form:errors>
                    </div>
                </spring:bind>
            </div>
        </div>

        <div class="form-group row">
            <label for="userSurname" class="col-3 col-form-label">Surname:</label>
            <div class="col-3">
                <spring:bind path="userSurname">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="userSurname" class="form-control" placeholder="surname"
                                    autofocus="true"></form:input>
                        <form:errors path="userSurname"></form:errors>
                    </div>
                </spring:bind>
            </div>
        </div>
            <spring:bind path="userRole"><form:input type="hidden" path="userRole" value="2"></form:input></spring:bind>

        <div class="form-group row">
            <label for="userPhoneNumber" class="col-3 col-form-label">Phone number:</label>
            <div class="col-3">
                <spring:bind path="userPhoneNumber">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="userPhoneNumber" class="form-control" placeholder="Phone number"
                                    autofocus="true"></form:input>
                        <form:errors path="userPhoneNumber"></form:errors>
                    </div>
                </spring:bind>
            </div>
        </div>

            <button class="col-3 btn btn-lg btn-primary btn-block" type="submit">Add manager</button>
        </form:form>
    </div>
</main>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>

