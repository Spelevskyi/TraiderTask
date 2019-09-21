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
    <h2>Items</h2>
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Id</th>
            <th>FirstName</th>
            <th>LstName</th>
            <th>email</th>
            <th>Password</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
            <td><a href="/post/get/${user.id}"><span class="glyphicon glyphicon-folder-open"></span></a></td>
            <td><a href="/user/${user.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
            <td><a href="/admin/user/remove/${user.id}/${id}"><span class="glyphicon glyphicon-trash"></span></a></td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>

</body>
</html>
