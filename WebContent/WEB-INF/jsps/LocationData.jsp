<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	<pre>
		<h1 style="color: purple">All Location Data!!!</h1>
		<hr>
	<a href="locExcel">Excel Export</a> | <a href="locPdf">Pdf Export</a>
		<table border="1">
		<tr>
				<th>LocID</th>
				<th>LocCode</th>
				<th>LocName</th>
				<th>LocType</th>
				<th colspan="2">Operations</th>
		</tr>
		<c:forEach items="${locs}" var="loc">
			<tr>
					<td>${loc.locId}</td>
					<td>${loc.locCode}</td>
					<td>${loc.locName}</td>
					<td>${loc.locType}</td>
					<td><a href="deleteLocation?locId=${loc.locId}"><img src="../images/delete.jpg" width="30" height="30"/></a></td>
					<td><a href="editLocation?locId=${loc.locId}"><img src="../images/edit.png" width="30" height="30"/></a></td>
			</tr>
		</c:forEach>
		</table>
	</pre>
</body>
</html>