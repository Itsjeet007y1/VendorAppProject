<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="loginCheck" method="post">
			<h1 style="color: lightgreen">Vendor Management</h1>
			<hr>
			UserName: <input type="text" name="un" /> <br><br>
			Password: <input type="password" name="pwd" /> <br><br>
			<input type="submit" value="Login">
		</form>
		${msg} <br> No Account? <a href="regUser"> Click Here </a>for
		SignUp
	</center>
</body>
</html>