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
	<h1 style="color: green">Documents Page</h1>
	<hr>
	<form action="uploadDocument" method="post" enctype="multipart/form-data">
		File ID: <input type="text" name="fileId" /><br> <br>
		File: <input type="file" name="fileOb" /><br> <br> 
		<input  type="submit" value="Upload" />
	</form>
	<br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>LINK</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td>${ob[0]}</td>
				<td>${ob[1]}</td>
				<td><a href="downloadDocument?fileId=${ob[0]}">Download</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>