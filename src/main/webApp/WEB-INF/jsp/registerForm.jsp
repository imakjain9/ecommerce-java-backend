<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
<head>
<title>home</title>
</head>
<body>
<form action="http://localhost:8080/ecommerce/registerSubmit" method="post">
  <label for="email">Email :</label><br>
  <input type="text" id="email" name="email" value="John"><br>
  <label for="fname">First name:</label><br>
  <input type="text" id="fname" name="firstName" value="John"><br>
  <label for="lname">Last name:</label><br>
  <input type="text" id="lname" name="lastName" value="Doe"><br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>