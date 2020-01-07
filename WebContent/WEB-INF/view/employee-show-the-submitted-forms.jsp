<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp: Show The submitted forms</title>

</head>
<body>
	<pre>
	                                                                                                                  <a
			href="http://localhost/DistributedSystems/employee-login/just-logged-out">Logout</a>
	</pre>
	Here are the submitted forms : You will be asked to either accept or
	decline every form, based on if the submitted form meets the criteria
	or not !

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

					<!-- 	<th><form method="GET"
							action="/DistributedSystems/employee-login/employee-menu/employee-show-the-submitted-forms/decline">
							<table>
								<tr>
									<td><input type="submit"
										value="Decline the submitted form"
										name="Decline the submitted form based on dep." /></td>
								</tr>
							</table>
						</form></th>
					<th><form method="GET"
							action="/DistributedSystems/employee-login/employee-menu/employee-show-the-submitted-forms/accept">
							<table>
								<tr>
									<td><input type="submit" value="Accept the submitted form"
										name="Accept the submitted form based on dep." /></td>
								</tr>
							</table>
						</form></th>  -->

				</tr>
				<!-- loop over and print all submitted forms that have been retrieved from the databases -->
				<c:forEach var="tempCustomer" items="${arraylist_subforms}">

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
						<td><a
							href="/DistributedSystems/employee-login/employee-menu/employee-show-the-submitted-forms/decline">Decline
								the form</a></td>
						<td><a
							href="/DistributedSystems/employee-login/employee-menu/employee-show-the-submitted-forms/accept">Accept
								the form</a></td>
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>