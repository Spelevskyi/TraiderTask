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
    <h2>Comments</h2>
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Id</th>
            <th>Text</th>
            <th>Created at</th>
            <th>Approved</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list comments as comment>
        <tr>
            <td>${comment.id}</td>
            <td>${comment.message}</td>
            <td>${comment.createdAt}</td>
            <td><a href="/admin/comment/approve/${comment.id}/${id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>

</body>
</html>
