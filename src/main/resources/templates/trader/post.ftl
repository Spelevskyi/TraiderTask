<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#include "navbar.ftl">
<div class="container">
    <h1>Game objects</h1>
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Created</th>
            <th>Updated</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <#list objects as object>
            <tr>
                <td>${object.id}</td>
                <td>${object.title}</td>
                <td>${object.createdAt}</td>
                <td>${object.updatedAt}</td>
            </tr>
            </#list>
        </tr>
        </tbody>
    </table>
    <h1>Comments</h1>
    <table class="table table-condensed">
        <thead>
        <tr>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list comments as comment>
        <tr>
            <td>${comment.id}</td>
            <td>${comment.message}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>