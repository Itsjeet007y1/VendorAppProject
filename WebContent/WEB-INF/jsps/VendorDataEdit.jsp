<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Master.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h1 style="color:green">Vendor Data Edit Page !!!</h1><hr>
<body>
	<form action="updateVendor" method="post">
		ID: <input type="text" name="venId" value="${ven.venId}" readonly="readonly"/><br><br>
		Code: <input type="text" name="venCode" value="${ven.venCode}"/><br><br>
		Name: <input type="text" name="venName" value="${ven.venName}"/><br><br>
		Type: <select name="venType">
			<option value="-1">--Select--</option>
			<c:choose>
				<c:when test="${ven.venType eq 'Regular'}">
					<option value="Regular" selected="selected">Regular</option>
					<option value="Contract">Contract</option>
				</c:when>
				<c:otherwise>
					<option value="Regular">Regular</option>
					<option value="Contract" selected="selected">Contract</option>
				</c:otherwise>
			</c:choose>
		</select><br><br>
		Email: <input type="text" name="venEmail" value="${ven.venEmail}"/><br><br>
		Contact:<input type="text" name="venContact" value="${ven.venContact}"/><br><br>
		Address:<textarea name="venAddress">${ven.venAddress}</textarea><br><br>
		<input type="submit" value="Update Vendor"> 
	</form>
</body>
</html>