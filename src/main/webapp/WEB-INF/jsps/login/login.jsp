<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<h2>Login Here</h2>
<form action="verifyLogin" method="post">
   email id<input type="text" name="emailId">
   password<input type="text" name="password">
   <input type="submit" value="save">
</form>
${error}
</body>
</html>