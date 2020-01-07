<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supervisor Log In</title>
</head>
<body>

	<br />
	<br /> Please log in !
	<br />
	<br />
	<!-- to action antistoixei sto mapping tou servlet  method="post"         /DistributedSystems/supervisor-login/supervisor-menu   -->
	<c:if test="${param.error != null}">
		<i>Sorry! Invalid username/password!</i>
	</c:if>
	<div id=" supervisor-login in order to see the menu">
		<form method="GET"
			action="/DistributedSystems/supervisor-login/supervisor-menu"
			method="GET">
			Username : <input name="username" type="text" required /> <br />
			Password: <input name="password" type="password" required /> <br /> <input
				type="submit" value="Login" />
		</form>
	</div>