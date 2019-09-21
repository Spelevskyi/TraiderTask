<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<#include "navbar.ftl">
<form method="POST" action="/anonymous/comment/${id}/${name}" modelAttribute="comment">
    <div class="container">
        <h1>Comment</h1>
        <p>Please fill in this form to comment post.</p>
        <hr>
        <label><b>Message</b></label>
        <input type="text" placeholder="Enter message" name="message" required>
        <button type="submit">Comment</button>
    </div>
</form>
</body>
</html>