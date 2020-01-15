<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Points and Rank</title>
</head>
<body>
	<pre>
	                                                                                                                  <a
			href="/DistributedSystems/st-just-logged-out">Logout</a>
	</pre>
	<h2>Here you can see your points and rank if your form has been
		processed and accepted!</h2>
	<br/>
	${declined}
	<table>
		<tbody>
			<tr>
				<td>Points : ${notyet}${points}</td>
				<td>Rank : ${notyet}${rank}</td>
			</tr>
		</tbody>
	</table>