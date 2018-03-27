<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Master.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Data Page</title>
<style type="text/css">
	tr th {
		color:white;
		background-color: green;
	}
</style>
</head>
<body>
<h1 style="color:green">Vendor Data Page</h1><hr>
<a href="venExcel">Excel Export</a> | <a href="venPdf">Pdf Export</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>CODE</th>
			<th>NAME</th>
			<th>TYPE</th>
			<th>EMAIL</th>
			<th>CONTACT</th>
			<th>ADDRESS</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${vens}" var="ven">		
		<tr>
			<td>${ven.venId}</td>
			<td>${ven.venCode}</td>
			<td>${ven.venName}</td>
			<td>${ven.venType}</td>
			<td>${ven.venEmail}</td>
			<td>${ven.venContact}</td>
			<td>${ven.venAddress}</td>
			<td><a href="deleteVendor?venId=${ven.venId}"><img src="../images/delete.jpg" width="30" height="30"/></a></td>
			<td><a href="editVendor?venId=${ven.venId}"><img src="../images/edit.png" width="30" height="30"/></a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>