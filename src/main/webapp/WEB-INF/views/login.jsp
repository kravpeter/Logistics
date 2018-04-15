<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value="/resources/img/truck-front.png"/>" />
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" />
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="<c:url value="/resources/css/signin.css"/>" />
    <title>Sign in Logistics</title>
</head>

<body class="text-center">
<form action="/login" method="POST" class="form-signin" autocomplete="off">
    <a href="/index"><img class="mb-4" src="<c:url value="/resources/img/truck.svg"/>" alt="" width="72" height="72"></a>
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="username" class="sr-only">Email address</label>
    <input type="email" id="username" name="username" class="form-control" placeholder="Email address" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <!--<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>-->
</form>
</body>
</html>
