<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your form</title>
</head>
<body>
${error}
<br/><br/>
Hello ${username}
<%--  ${currentUser} --%>
	This is your form, if you want to change some of your data you can
	here:
	<a href="/DistributedSystems/student-login/options/change-data">Change data</a>
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

