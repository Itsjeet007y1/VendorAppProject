<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Master.jsp"%>
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
	<h1 style="color: green">Customer Data Page !!</h1>
	<hr>
	<a href="custExcel">Excel Export</a> |
	<a href="custPdf">Pdf Export</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>CODE</th>
			<th>NAME</th>
			<th>C.TIME</th>
			<th>PERCENT</th>
			<th>MODE</th>
			<th>EMAIL</th>
			<th>TYPE</th>
			<th>ADDRESS</th>
			<th>DESCRIPTION</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${custs}" var="cust">
			<tr>
				<td>${cust.custId}</td>
				<td>${cust.custCode}</td>
				<td>${cust.custName}</td>
				<td>${cust.contractTime}</td>
				<td>${cust.percent}</td>
				<td>${cust.custMode}</td>
				<td>${cust.custEmail}</td>
				<td>${cust.custType}</td>
				<td>${cust.custAddress}</td>
				<td>${cust.description}</td>
				<c:choose>
					<c:when test="${'Seller' eq cust.custType}">
						<td><a href="getAllItems">View All Items</a></td>
					</c:when>
					<c:otherwise>
						<td><a href="getAllOrders">View All Orders</a></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
</body>
</html>