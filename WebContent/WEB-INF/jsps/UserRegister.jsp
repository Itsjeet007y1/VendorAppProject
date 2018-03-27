<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Page</title>
</head>
<body>
	<center>
		<h1 style="color:lightgreen">User Registration Page</h1>
		<hr>
		<form action="saveUser" method="post">
			User Name: <input type="text" name="userName" /><br> <br>
			User Email: <input type="text" name="userEmail" /><br> <br>
			User Contact: <input type="text" name="userContact" /><br> <br>
			User Password: <input type="text" name="userPwd" /><br> <br>
			User Address: <input type="text" name="userAddrs" /><br> <br>
			<input type="submit" value="Register" /><br> <br>
		</form>
		${msg}<br> <a href="login">LogIn</a>
	</center>
</body>
</html>