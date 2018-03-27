<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Master.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Data Edit Page</title>
</head>
<body>
	<h1 style="color:green">Order Data Edit Page!!!</h1><hr>
	<form action="updateOrder" method="post">
		Order ID: <input type="text" name="orderId" value="${order.orderId}"><br><br>
		Order Code: <input type="text" name="orderCode" value="${order.orderCode}"><br><br>
		Order Cost: <input type="text" name="orderCost" value="${order.orderCost}"><br><br>
		Max Discount: <input type="text" name="maxDiscount" value="${order.maxDiscount}"><br><br>
		<input type="submit" value="Update"/> 
	</form>
</body>
</html>