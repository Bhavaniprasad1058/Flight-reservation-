<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Registration</title>
</head>
<body>
<h2>Create New Account</h2>
<form action="saveReg" method="post">
<pre>
     Firstname<input type="text" name="firstName">
     Lastname<input type="text" name="lastName">
     Email<input type="text" name="email">
     Password<input type="text" name="password">
     <input type="submit" value="save">
</pre>
</form>
</body>
</html>