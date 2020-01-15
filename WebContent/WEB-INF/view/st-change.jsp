<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Personal Data</title>
</head>
<body>
	<pre>
	                                                                                                                  <a
			href="/DistributedSystems/just-logged-out">Logout</a>
			
	</pre>
	<sec:authorize access="isAuthenticated()">
		<div class="ui segment">
			User:
			<sec:authentication property="principal.username" />
			, Role:
			<sec:authentication property="principal.authorities" />
		</div>
	</sec:authorize>
	<h3>Here you can change some of your personal data, so we can be
		able to communicate with you!</h3>
	<br />
	<form action="/DistributedSystems/login/main-menu-for-all/student-menu/change-data/newForm" method="get">
		<h3>Department :<i> ${department}</i></h3>
		<table>
			<tbody>
				
				<tr>
					<td><br /></td>
				</tr>
				<tr>
					<td>E-mail :</td>
					<td><input name="email" type="text" size="30" value="" /></td>
				</tr>
				<tr>
					<td>Phone number :</td>
					<td><input name="phonenumber" type="number" size="30" value=""
						required required /></td>
				</tr>
				<tr>
					<td>Place of residence :</td>
					<td><input name="placeofliving" type="text" size="30" value=""></td>
				</tr>
			</tbody>
		</table>
		<br /> <input type="submit" value="Submit Form" /> <br />
	</form>
	<form id="backbutton" name="back" action="/DistributedSystems/login/main-menu-for-all/student-menu"
		method="post" onsubmit="Options()">
		<!-- <input type="submit" value="Back" /> -->
	</form>