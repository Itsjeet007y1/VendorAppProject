<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Master.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1 style="color:green">Order Register Page!!!</h1><hr>
	<form action="saveOrder" method="post">
		Order ID: <input type="text" name="orderId"><br><br>
		Order Code: <input type="text" name="orderCode"><br><br>
		Order Cost: <input type="text" name="orderCost"><br><br>
		Max Discount: <input type="text" name="maxDiscount"><br><br>
		<input type="submit" value="Register"/> &nbsp; &nbsp; &nbsp; <input type="reset" value="Reset"/>
	</form>
	<br>
	${msg}
</body>
</html>