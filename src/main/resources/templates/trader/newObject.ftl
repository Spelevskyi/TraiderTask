<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Adding object</title>
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}
        form {border: 3px solid #f1f1f1;}

        input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
        }

        button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 20%;
        }

        button:hover {
        opacity: 0.8;
        }
    </style>
</head>
<#include "navbar.ftl">
<form method="POST" action="/trader/object/add/${id}" modelAttribute="object">
    <div class="container">
        <h1>New game object</h1>
        <p>Please fill in this form to create new game object.</p>
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