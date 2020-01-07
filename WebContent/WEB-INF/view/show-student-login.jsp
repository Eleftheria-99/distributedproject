<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Log In</title>
</head>
<body>
	<h3>
		<b>Hello student!</b>
	</h3>
	<p>
	${log_out_message} 
	</p>
	<br />
	<br /> You need to log in first!
	
	<br />${error }${users}
	<br />
	<!-- to action antistoixei sto mapping tou servlet  method="post" -->
	<form method="POST" action="/DistributedSystems/student-login/options">
		<table>
			<tbody>
				<tr>
					<td>Username:</td>
					<td><input name="username" type="text" required /></td>
				<tr>
					<td>Password:</td>
					<td><input name="password" type="text" required /></td>
				</tr>
			</tbody>
		</table>
		<br /> <input type="submit" value="Login" />
	</form>
