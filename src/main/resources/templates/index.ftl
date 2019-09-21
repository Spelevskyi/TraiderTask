<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
<head>
<link rel="stylesheet" type="text/css" href="style/anonymous.css">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text]{
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
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }

</style>
</head>
<body>
<h2>Anonymous SignIn</h2>
<form method="POST" action="/anonymous" modelAttribute="user">
    <div class="container">
        <label><b>Anonymous name</b></label>
        <input type="text" placeholder="Enter your site name" name="firstName" required>
        <button type="submit">SignIn</button>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>
    </div>
</form>
</body>
