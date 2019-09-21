<!DOCTYPE html>
<html lang="en">
<head>
    <title>New game</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<#include "navbar.ftl">
<form method="POST" action="/admin/game/${id}" modelAttribute="game">
    <div class="container">
        <h1>New game object</h1>
        <p>Please fill in this form to create new game.</p>
        <hr>
        <label><b>Name</b></label>
        <input type="text" placeholder="Enter name" name="name" required>
        <button type="submit">Add</button>
    </div>
</form>
</body>
</html>