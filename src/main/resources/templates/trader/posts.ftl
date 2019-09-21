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
    <h2>Posts</h2>
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Author</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Ranting score</th>
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
            <td>${user.getFirstName()} ${user.getLastName()} </td>
            <td>${post.createdAt}</td>
            <td>${post.updatedAt}</td>
            <td>${post.ranting}</td>
            <td><a href="/trader/post/get/${post.id}"><span class="glyphicon glyphicon-folder-open"></span></a></td>
            <td><a href="/trader/post/object/${post.id}/${user.getId()}"><span class="glyphicon glyphicon-pencil"></span></a></td>
            <td><a href="/trader/post/remove/${post.id}/${user.getId()}"><span class="glyphicon glyphicon-trash"></span></a></td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>

</body>
</html>