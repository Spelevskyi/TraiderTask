<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Profile</title>
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
            <a class="navbar-brand" href="#">${firstName} ${lastName}</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/trader/${id}">Home</a></li>
            <li class="active"><a href="/trader/objects/${id}">Game objects</a></li>
            <li class="active"><a href="/trader/posts/${id}">Posts</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/"><span class="glyphicon glyphicon-user"></span>Sign Out</a></li>
        </ul>
    </div>
</nav>
</body>
</html>
