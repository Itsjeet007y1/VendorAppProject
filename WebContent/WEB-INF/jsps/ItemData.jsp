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
	<h1 style="color: green">Item Data Page !!</h1>
	<hr>
	<a href="itmExcel">Excel Export</a>	|	<a href="itmPdf">Pdf Export</a>
	<table border="1">
		<tr>
			<th>ITEM ID</th>
			<th>CODE</th>
			<th>NAME</th>
			<th>BASE COST</th>
			<th>BAR CODE</th>
			<th>DISCOUNT</th>
			<th>MANUFACTURED</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${itms}" var="itm">
			<tr>
				<td>${itm.itemId}</td>
				<td>${itm.itemCode}</td>
				<td>${itm.itemName}</td>
				<td>${itm.baseCost}</td>
				<td>${itm.barCode}</td>
				<td>${itm.maxDiscount}</td>
				<td>${itm.mfg}</td>

				<td><a href="deleteItem?itemId=${itm.itemId}"><img src="../images/delete.jpg" width="30" height="30"/></a></td>
				<td><a href="editItem?itemId=${itm.itemId}"><img src="../images/edit.png" width="30" height="30"/></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>