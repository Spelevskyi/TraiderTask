<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<#include "navbar.ftl">
<div class="container">
    <h2>Posts ranting</h2>
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Ranting</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list posts as post>
        <tr>
            <td>${post.id}</td>
            <td>${post.name}</td>
            <td>${post.ranting}</td>
            <td><a href="/anonymous/post/${post.id}/${name}"><span class="glyphicon glyphicon-folder-open"></span></a></td>
            <td><a href="/anonymous/comment/${post.id}/${name}"><span class="glyphicon glyphicon-comment"></span></a></td>
            <td><a href="/anonymous/ranting/${post.id}/${name}"><span class="glyphicon glyphicon-signal"></span></a></td>
         </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>