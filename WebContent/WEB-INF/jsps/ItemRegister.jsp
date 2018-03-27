<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Master.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:green">Item Register Page!!!</h1><hr>
	<form action="saveItem" method="post">
		Item ID: <input type="text" name="itemId"><br><br>
		Item Code: <input type="text" name="itemCode"><br><br>
		Item Name: <input type="text" name="itemName"><br><br>
		Base Cost: <input type="text" name="baseCost"><br><br>
		Bar Code: <input type="text" name="barCode"><br><br>
		Max Discount: <input type="text" name="maxDiscount"><br><br>
		Manufactured: <input type="text" name="mfg"><br><br>
		<input type="submit" value="Register"/> &nbsp; &nbsp; &nbsp; <input type="reset" value="Reset"/>
	</form>
	<br>
	${msg}
</body>
</html>