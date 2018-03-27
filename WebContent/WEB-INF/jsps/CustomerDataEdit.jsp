<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Master.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Data Edit Page</title>
</head>
<body>
	<form action="updateCustomer" method="post">
		<h1 style="color: green">Welcome to Customer Data Edit Page...</h1><hr>
			Customer ID:		<input type="text" name="custId" value="${cust.custId}"/><br><br>
			Customer Code:		<input type="text" name="custCode" value="${cust.custCode}"/><br><br>
			Customer Name:		<input type="text" name="custName" value="${cust.custName}"/><br><br>
			Contract Time:		<input type="text" name="contractTime" value="${cust.contractTime}"/><br><br>
			Percent:		<input type="text" name="percent" value="${cust.percent}"/><br><br>
			Customer Mode:		
			<c:choose>
				<c:when test="${cust.custMode eq 'Enable'}">
						<input type="radio" name="custMode" value="Enable" checked="checked"/>Enable
						<input type="radio" name="custMode" value="Disable" />Disable<br><br>
				</c:when>
				<c:otherwise>
						<input type="radio" name="custMode" value="Enable" />Enable
						<input type="radio" name="custMode" value="Disable" checked="checked"/>Disable<br><br>
				</c:otherwise>
			</c:choose>
			Email:<input type="text" name="custEmail" value="${cust.custEmail}"/><br><br>
			Customer Type: <select name="custType">
				<option value="-1">--Select--</option>
				<c:choose>
					<c:when test="${cust.custType eq 'Consumer'}">
						<option value="Consumer" selected="selected">Consumer</option>
						<option value="Seller">Seller</option>
					</c:when>
					<c:otherwise>
						<option value="Consumer">Consumer</option>
						<option value="Seller" selected="selected">Seller</option>
					</c:otherwise>
				</c:choose>
			</select><br><br>
			Address: <textarea name="custAddress">${cust.custAddress}</textarea>
			<br><br>
			Description: <textarea name="description">${cust.description}</textarea>
			<br><br>
			<input type="submit" value="Update" /> 
	</form>
</body>
</html>