<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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



<main role="main">
    <a href="login"><h6>Log in</h6></a> for employees
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="" alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="" alt="Third slide">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</main>


<footer class="container">
    <p>&copy; Company 2017-2018</p>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="/resources/js/jquery-slim.min.js"><\/script>')</script>
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>