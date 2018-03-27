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
	<h1 style="color:green">Welcome to Vendor Registration Page !!!</h1><hr>
	<form action="saveVendor" method="post" enctype="multipart/form-data">
		ID: <input type="text" name="venId"/><br><br>
		Code: <input type="text" name="venCode"/><br><br>
		Name: <input type="text" name="venName"/><br><br>
		Type: <select name="venType">
			<option value="-1">--Select--</option>
			<option value="Regular">Regular</option>
			<option value="Contract">Contract</option>
		</select><br><br>
		Email: <input type="text" name="venEmail"/><br><br>
		Contact:<input type="text" name="venContact"/><br><br>
		Address:<textarea name="venAddress"></textarea><br><br>
		File to send as Email: <input type="file" name="fobj"/><br><br>
		<input type="submit" value="Save Data"> &nbsp; &nbsp; &nbsp;
		 <input type="reset" value="Clear Data"><br>
	</form>
	<br>
	${msg}
</body>
</html>