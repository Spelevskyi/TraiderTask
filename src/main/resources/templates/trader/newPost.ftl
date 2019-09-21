<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>New post</title>
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
<form method="POST" action="/trader/post/add/${id}" modelAttribute="post">
    <div class="container">
        <h1>New post</h1>
        <p>Please fill in this form to create new post.</p>
        <hr>
        <label><b>Name</b></label>
        <input type="text" placeholder="Enter name" name="name" required>
        <button type="submit">Create new post</button>
    </div>
</form>
</body>
</html>