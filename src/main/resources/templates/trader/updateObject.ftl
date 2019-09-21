<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<#include "navbar.ftl">
<form method="POST" action="/trader/object/update/${objectId}/${id}" modelAttribute="object">
    <div class="container">
        <h1>Update game object</h1>
        <p>Please fill in this form to update object.</p>
        <hr>
        <label><b>Title</b></label>
        <input type="text" placeholder="Enter title" name="title" required>
        <label><b>Text</b></label>
        <input type="text" placeholder="Enter text" name="text" required>
        <label><b>Game ID</b></label>
        <input type="text" placeholder="Enter game id" name="gameId" required>
        <button type="submit">Add</button>
    </div>
</form>
</body>
</html>