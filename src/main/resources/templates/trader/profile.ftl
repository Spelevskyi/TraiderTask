<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${firstName} ${lastName}</title>
    <style>
         .button {
         background-color: #1c87c9;
         border: none;
         color: white;
         padding: 7px 34px;
         text-align: center;
         text-decoration: none;
         display: inline-block;
         font-size: 20px;
         margin: 4px 2px;
         cursor: pointer;
         }
      </style>
</head>
<body>
<#include "navbar.ftl">
<div class="container">
    <h3>Adding new game object</h3>
    <a href="/trader/object/${id}" class="button">Add</a>
    <h3>Adding new post</h3>
    <a href="/trader/post/${id}" class="button">Add</a>
</div>
</body>
</html>