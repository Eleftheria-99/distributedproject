<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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

<title>Employee Show The List</title>
</head>
<body>
	<h3>
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
		<br />
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
					<th>Place Of Studying/Living</th>
					<th>Department</th>
					<th>Year Of Attendance</th>
					<th>Family Status</th>
					<th>Sibling's Studying</th>
					<th>Annual Income</th>
					<th>Unemployed Parents</th>
					<th>Points</th>


					<!-- loop over and print all submitted forms that have been retrieved from the databases -->
					<c:forEach var="tempCustomer" items="${arraylist_accepted_forms}">

						<tr>
							<td>${tempCustomer.id}</td>
							<td>${tempCustomer.fname}</td>
							<td>${tempCustomer.lname}</td>
							<td>${tempCustomer.email}</td>
							<td>${tempCustomer.phone_number}</td>
							<td>${tempCustomer.place_of_residence}</td>
							<td>${tempCustomer.place_of_living}</td>
							<td>${tempCustomer.department}</td>
							<td>${tempCustomer.year_of_attendance}</td>
							<td>${tempCustomer.family_state}</td>
							<td>${tempCustomer.number_of_siblings_studying}</td>
							<td>${tempCustomer.annual_family_income}</td>
							<td>${tempCustomer.number_of_unemployed_parents}</td>
							<td>${tempCustomer.points}</td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>