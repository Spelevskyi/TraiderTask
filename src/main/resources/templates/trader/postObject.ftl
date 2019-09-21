<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add object to post</title>
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}
        form {border: 3px solid #f1f1f1;}

        select[type=text]{
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
<form method="POST" action="/trader/post/addObject/${id}" modelAttribute="object">
    <div class="container">
        <h1>Adding selected object to post</h1>
        <p>Please choose object.</p>
        <hr>
        <label><b>Choose object to add into post</b></label>
        <select name="title">
            <#list objects as it>
            <option>${it.title}</option>
        </#list>
        </select>
        <li><button type="submit">Add</button></li>
    </div>
</form>
</body>
</html>