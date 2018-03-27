<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="Master.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration</title>
</head>
<body>
	<h1 style="color: green">Welcome to Customer Registration Page...</h1>
	<form action="saveCustomer" method="post">
		<pre>
			Customer ID:		<input type="text" name="custId" /><br>
			Customer Code:		<input type="text" name="custCode" /><br>
			Customer Name:		<input type="text" name="custName" /><br>
			Contract Time:		<input type="text" name="contractTime" /><br>
			Percent:		<input type="text" name="percent"/><br>
			Customer Mode:		<input type="radio" name="custMode" value="Enable" />Enable<br>
						<input type="radio" name="custMode" value="Disable" />Disable<br>
			Email:<input type="text" name="custEmail" /><br>
			Customer Type: <select name="custType">
				<option value="-1">--Select--</option>
				<option value="Consumer">Consumer</option>
				<option value="Seller">Seller</option>
			</select><br>
			Address: <textarea name="custAddress"></textarea><br>
			Description: <textarea name="description"></textarea><br>
			<input type="submit" value="Register" /> &nbsp; &nbsp; <input
				type="reset" value="Reset" />
		</pre>
	</form>
	${msg}
</body>
</html>