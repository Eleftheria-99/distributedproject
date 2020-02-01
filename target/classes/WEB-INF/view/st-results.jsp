<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
body {
	min-height: 100vh;
	position: relative;
}

</style>
<title>Points and Rank</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<div class="ui segment">
		<pre>
	                     	                                                                                                                  <a href="/DistributedSystems/just-logged-out">Logout</a>
	</pre>
			User:
			<sec:authentication property="principal.username" />
			, Role:
			<sec:authentication property="principal.authorities" />
		</div>
	</sec:authorize>
	<h3>Here you can see your points and rank if your form has been
		processed and accepted!</h3>
	<br/> <br/> <br/>
	<center><font color="#000080"><h3> ${notfound} </h3></font></center>
	<table>
		<tbody>
			<tr>
				<td>${Points} ${points} ${size}</td>

			</tr>
			<tr>
				<td>${Rank} ${rank}</td>
			</tr>
		</tbody>
	</table>