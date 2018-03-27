<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Master.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
 tr th {
	color: white;
	background-color: green;
}
</style>
</head>
<body>
	<h1 style="color: green">Order Data Page !!</h1>
	<hr>
	<a href="orderExcel">Excel Export</a>	|	<a href="orderPdf">Pdf Export</a>
	<table border="1">
		<tr>
			<th>ORDER ID</th>
			<th>ORDER CODE</th>
			<th>ORDER COST</th>
			<th>MAX DISCOUNT</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.orderId}</td>
				<td>${order.orderCode}</td>
				<td>${order.orderCost}</td>
				<td>${order.maxDiscount}</td>
				<td><a href="deleteOrder?orderId=${order.orderId}"><img src="../images/delete.jpg" width="30" height="30"/></a></td>
				<td><a href="editOrder?orderId=${order.orderId}"><img src="../images/edit.png" width="30" height="30"/></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>