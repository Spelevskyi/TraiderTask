<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/anonymous/${name}">Home</a></li>
            <li class="active"><a href="/anonymous/posts/${name}">Posts</a></li>
            <li class="active"><a href="/anonymous/users/${name}">Traiders ranting</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/register/${name}"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="/login/${name}"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>
</body>
</html>
