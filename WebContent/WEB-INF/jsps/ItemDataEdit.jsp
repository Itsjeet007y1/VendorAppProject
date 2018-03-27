<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Master.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:green">Item Data Edit Page!!!</h1><hr>
	<form action="updateItem" method="post">
		Item ID: <input type="text" name="itemId" value="${itm.itemId}"><br><br>
		Item Code: <input type="text" name="itemCode" value="${itm.itemCode}"><br><br>
		Item Name: <input type="text" name="itemName" value="${itm.itemName}"><br><br>
		Base Cost: <input type="text" name="baseCost" value="${itm.baseCost}"><br><br>
		Bar Code: <input type="text" name="barCode" value="${itm.barCode}"><br><br>
		Max Discount: <input type="text" name="maxDiscount" value="${itm.maxDiscount}"><br><br>
		Manufactured: <input type="text" name="mfg" value="${itm.mfg}"><br><br>
		<input type="submit" value="Update"/> 
	</form>
</body>
</html>