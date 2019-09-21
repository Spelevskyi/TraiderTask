<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#include "navbar.ftl">
<div class="container">
    <h2>Game object</h2>
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Game</th>
            <th>Title</th>
            <th>Created</th>
            <th>Updated</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${game.name}</td>
            <td>${object.title}</td>
            <td>${object.createdAt}</td>
            <td>${object.updatedAt}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>