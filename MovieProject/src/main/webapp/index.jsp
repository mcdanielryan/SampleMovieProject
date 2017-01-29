<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="net.viralpatel.maven.MovieActionServlet" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="stylesheet" href="stylesheet.css" type="text/css" charset="utf-8" />
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Movie Project</title>
	
	</head>
	<body class="indexBody">
		<form action="${pageContext.request.contextPath}/MovieActionServlet" method="get">
		    <label class="textLabel">Title : <input class="textField" type="text" id="movieName" name="movieName" ></label> <br>
		</form>
	</body>
</html>