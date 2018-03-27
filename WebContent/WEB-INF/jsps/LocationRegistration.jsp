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
	<form action="saveLocation" method="post">
		<pre>
		<h1 style="color: green">Welcome to Location Register Page...</h1>
			Location ID:		<input type="text" name="locId" /><br>
			Location Code:		<input type="text" name="locCode" /><br>
			Location Name:		<input type="text" name="locName" /><br>
			Location Type:		<input type="radio" name="locType" value="Urban" />Urban<br>
						<input type="radio" name="locType" value="Rural" />Rural<br>
			<input type="submit" value="Register" /> &nbsp; &nbsp; <input
				type="reset" value="Reset" />
		</pre>
	</form>
	${msg}
</body>
</html>