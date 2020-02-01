<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style type="text/css">
body {
	min-height: 100vh;
	position: relative;
}

</style>
<title>Your form</title>
</head>
<body>
	Hello ${username}


	<h3>
		<sec:authorize access="isAuthenticated()">
			<div class="ui segment">
				<pre>
	                     	                                                                                                                  <a
						href="/DistributedSystems/just-logged-out">Logout</a>
	</pre>
				User:
				<sec:authentication property="principal.username" />
				, Role:
				<sec:authentication property="principal.authorities" />
			</div>
		</sec:authorize>
	</h3>
	<br /> ${error} <br/>
	This is your form, if you want to change some of your
	data you can here:
	<a
		href="/DistributedSystems/login/main-menu-for-all/student-menu/change-data">Change
		data</a>
	<!-- in reality it will load form from db -->
	<br />
	<br />
	<table>
		<tbody>
			<tr>
				<td>First Name :</td>
				<td>${fname}</td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td>${lname}</td>
			</tr>
			<tr>
				<td>E-mail :</td>
				<td>${email }</td>
			</tr>
			<tr>
				<td>Phone number :</td>
				<td>${phone }</td>
			</tr>
			<tr>
				<td>Place of residence :</td>
				<td>${pofresidence}</td>
			</tr>
			<tr>
				<td>Place of studying :</td>
				<td>${pofstudying}</td>
			</tr>
			<tr>
				<td>Department of study:</td>
				<td>${dep}</td>
			</tr>
			<tr>
				<td>Year of attendance :</td>
				<td>${year}</td>
			</tr>
			<tr>
				<td>Family status :</td>
				<td>${family}</td>
			</tr>
			<tr>
				<td>Number of siblings who study :</td>
				<td>${siblings}</td>
			</tr>
			<tr>
				<td>Family annual financial income :</td>
				<td>${income}</td>
			</tr>
			<tr>
				<td>Number of unemployed parents :</td>
				<td>${parents}</td>
			</tr>

		</tbody>
	</table>