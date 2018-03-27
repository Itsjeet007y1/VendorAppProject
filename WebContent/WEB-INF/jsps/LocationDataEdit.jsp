<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Master.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Data Edit Page</title>
</head>
<body>
	<form action="updateLocation" method="post">
		<pre>
		<h1 style="color: green">Welcome to Location Data Edit Page...</h1>
			Location ID:		<input type="text" name="locId" value="${loc.locId}" readonly="readonly"/><br>
			Location Code:		<input type="text" name="locCode" value="${loc.locCode}"/><br>
			Location Name:		<input type="text" name="locName" value="${loc.locName}"/><br>
			Location Type:		
			<c:choose>
				<c:when test="${loc.locType eq 'Urban'}">
					<input type="radio" name="locType" value="Urban" checked="checked"/>Urban<br>
					<input type="radio" name="locType" value="Rural" />Rural<br>
				</c:when>
				<c:otherwise>
					<input type="radio" name="locType" value="Urban"/>Urban<br>
					<input type="radio" name="locType" value="Rural" checked="checked"/>Rural<br>
				</c:otherwise>
			</c:choose>
			<input type="submit" value="update" /> 
		</pre>
	</form>
</body>
</html>