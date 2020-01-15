<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Show The List</title>
</head>
<body>
	<h3>
		<sec:authorize access="isAuthenticated()">
			<div class="ui segment">
				User:
				<sec:authentication property="principal.username" />
				, Role:
				<sec:authentication property="principal.authorities" />
			</div>
		</sec:authorize>
		<br />
		<br /> You are an employee!
	</h3>
	<br />
	<br /> Here is the list with the accepted students that want to
	petition for free meals ! First is the student that has the most points
	and last the student with the less points!

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>PhoneNumber</th>
					<th>Place Of Residence</th>
					<th>Place Of Studying</th>
					<th>Department</th>
					<th>Year Of Attendance</th>
					<th>Family Status</th>
					<th>Sibling's Studying</th>
					<th>Annual Income</th>
					<th>Unemployed Parents</th>


					<!-- loop over and print all submitted forms that have been retrieved from the databases -->
					<c:forEach var="tempCustomer" items="${arraylist_accepted_forms}">

						<tr>
							<td>${tempCustomer.id}</td>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td>${tempCustomer.phoneNumber}</td>
							<td>${tempCustomer.placeOfResidence}</td>
							<td>${tempCustomer.placeOfStudying}</td>
							<td>${tempCustomer.department}</td>
							<td>${tempCustomer.yearOfAttendance}}</td>
							<td>${tempCustomer.familyStatus}</td>
							<td>${tempCustomer.siblingsStudying}</td>
							<td>${tempCustomer.annualIncome}</td>
							<td>${tempCustomer.unemployedParents}</td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>