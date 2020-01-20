<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp: Show The submitted forms</title>

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
		<br /> <br /> You are an employee!
	</h3>
	Here are the submitted forms : You will be asked to either accept or
	decline every form, based on if the submitted form meets the criteria
	or not !

	<div id="container">
		<div id="content">
		
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Username</th>
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
				</tr>
				<!-- loop over and print all submitted forms that have been retrieved from the databases -->
				<c:forEach var="tempCustomer" items="${arraylist_subforms}">

					<tr>
						<td>${tempCustomer.username}</td>
						<td>${tempCustomer.fname}</td>
						<td>${tempCustomer.lname}</td>
						<td>${tempCustomer.email}</td>
						<td>${tempCustomer.phoneNumber}</td>
						<td>${tempCustomer.placeOfResidence}</td>
						<td>${tempCustomer.placeOfStudying}</td>
						<td>${tempCustomer.department}</td>
						<td>${tempCustomer.yearOfAttendance}</td>
						<td>${tempCustomer.familyStatus}</td>
						<td>${tempCustomer.siblingsStudying}</td>
						<td>${tempCustomer.annualIncome}</td>
						<td>${tempCustomer.unemployedParents}</td>
						
						<c:if test="${tempCustomer.department =='Nutrition'}" >
							<td>
								<form action="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat/decline" method="POST">
									<input type="hidden" name="username" value="${tempCustomer.username}" /> 
									<input type="hidden" name="fname" value="${tempCustomer.fname}" /> 
									<input type="hidden" name="lname" value="${tempCustomer.lname}" /> 
									<input type="hidden" name="email" value="${tempCustomer.email}" /> 
									<input type="hidden" name="phoneNumber" value="${tempCustomer.phoneNumber}" /> 
									<input type="hidden" name="placeOfResidence" value="${tempCustomer.placeOfResidence}" /> 
									<input type="hidden" name="placeOfStudying" value="${tempCustomer.placeOfStudying}" /> 
									<input type="hidden" name="department" value="${tempCustomer.department}" /> 
									<input type="hidden" name="yearOfAttendance" value="${tempCustomer.yearOfAttendance}" /> 
									<input type="hidden" name="familyStatus" value="${tempCustomer.familyStatus}" /> 
									<input type="hidden" name="siblingsStudying" value="${tempCustomer.siblingsStudying}" /> 
									<input type="hidden" name="annualIncome" value="${tempCustomer.annualIncome}" /> 
									<input type="hidden" name="unemployedParents" value="${tempCustomer.unemployedParents}" /> 
									<input id="button" 	type="submit" value="Decline">
							
								</form>
							</td>
							<td>
								<form action="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat/accept" method="POST">
									<input type="hidden" name="username" value="${tempCustomer.username}" /> 
									<input type="hidden" name="fname" value="${tempCustomer.fname}" /> 
									<input type="hidden" name="lname" value="${tempCustomer.lname}" /> 
									<input type="hidden" name="email" value="${tempCustomer.email}" /> 
									<input type="hidden" name="phoneNumber" value="${tempCustomer.phoneNumber}" /> 
									<input type="hidden" name="placeOfResidence" value="${tempCustomer.placeOfResidence}" /> 
									<input type="hidden" name="placeOfStudying" value="${tempCustomer.placeOfStudying}" /> 
									<input type="hidden" name="department" value="${tempCustomer.department}" /> 
									<input type="hidden" name="yearOfAttendance" value="${tempCustomer.yearOfAttendance}" /> 
									<input type="hidden" name="familyStatus" value="${tempCustomer.familyStatus}" /> 
									<input type="hidden" name="siblingsStudying" value="${tempCustomer.siblingsStudying}" /> 
									<input type="hidden" name="annualIncome" value="${tempCustomer.annualIncome}" /> 
									<input type="hidden" name="unemployedParents" value="${tempCustomer.unemployedParents}" /> 
									<input id="button" 	type="submit" value="Accept">
								</form>
							</td>
							</c:if>
							
							
							<c:if test="${tempCustomer.department =='Geography' }" >
								<td>
									<form action="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo/decline" method="POST">
										<input type="hidden" name="username" value="${tempCustomer.username}" /> 
										<input type="hidden" name="fname" value="${tempCustomer.fname}" /> 
										<input type="hidden" name="lname" value="${tempCustomer.lname}" /> 
										<input type="hidden" name="email" value="${tempCustomer.email}" /> 
										<input type="hidden" name="phoneNumber" value="${tempCustomer.phoneNumber}" /> 
										<input type="hidden" name="placeOfResidence" value="${tempCustomer.placeOfResidence}" /> 
										<input type="hidden" name="placeOfStudying" value="${tempCustomer.placeOfStudying}" /> 
										<input type="hidden" name="department" value="${tempCustomer.department}" /> 
										<input type="hidden" name="yearOfAttendance" value="${tempCustomer.yearOfAttendance}" /> 
										<input type="hidden" name="familyStatus" value="${tempCustomer.familyStatus}" /> 
										<input type="hidden" name="siblingsStudying" value="${tempCustomer.siblingsStudying}" /> 
										<input type="hidden" name="annualIncome" value="${tempCustomer.annualIncome}" /> 
										<input type="hidden" name="unemployedParents" value="${tempCustomer.unemployedParents}" /> 
										<input id="button" 	type="submit" value="Decline">
								
									</form>
								</td>
								<td>
									<form action="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo/accept" method="POST">
										<input type="hidden" name="username" value="${tempCustomer.username}" /> 
										<input type="hidden" name="fname" value="${tempCustomer.fname}" /> 
										<input type="hidden" name="lname" value="${tempCustomer.lname}" /> 
										<input type="hidden" name="email" value="${tempCustomer.email}" /> 
										<input type="hidden" name="phoneNumber" value="${tempCustomer.phoneNumber}" /> 
										<input type="hidden" name="placeOfResidence" value="${tempCustomer.placeOfResidence}" /> 
										<input type="hidden" name="placeOfStudying" value="${tempCustomer.placeOfStudying}" /> 
										<input type="hidden" name="department" value="${tempCustomer.department}" /> 
										<input type="hidden" name="yearOfAttendance" value="${tempCustomer.yearOfAttendance}" /> 
										<input type="hidden" name="familyStatus" value="${tempCustomer.familyStatus}" /> 
										<input type="hidden" name="siblingsStudying" value="${tempCustomer.siblingsStudying}" /> 
										<input type="hidden" name="annualIncome" value="${tempCustomer.annualIncome}" /> 
										<input type="hidden" name="unemployedParents" value="${tempCustomer.unemployedParents}" /> 
										<input id="button" 	type="submit" value="Accept">
									</form>
								</td>
							</c:if>
							
							<c:if test="${tempCustomer.department == 'Economics' }" >
								<td> 
									<form action="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik/decline" method="POST">
										<input type="hidden" name="username" value="${tempCustomer.username}" /> 
										<input type="hidden" name="fname" value="${tempCustomer.fname}" /> 
										<input type="hidden" name="lname" value="${tempCustomer.lname}" /> 
										<input type="hidden" name="email" value="${tempCustomer.email}" /> 
										<input type="hidden" name="phoneNumber" value="${tempCustomer.phoneNumber}" /> 
										<input type="hidden" name="placeOfResidence" value="${tempCustomer.placeOfResidence}" /> 
										<input type="hidden" name="placeOfStudying" value="${tempCustomer.placeOfStudying}" /> 
										<input type="hidden" name="department" value="${tempCustomer.department}" /> 
										<input type="hidden" name="yearOfAttendance" value="${tempCustomer.yearOfAttendance}" /> 
										<input type="hidden" name="familyStatus" value="${tempCustomer.familyStatus}" /> 
										<input type="hidden" name="siblingsStudying" value="${tempCustomer.siblingsStudying}" /> 
										<input type="hidden" name="annualIncome" value="${tempCustomer.annualIncome}" /> 
										<input type="hidden" name="unemployedParents" value="${tempCustomer.unemployedParents}" /> 
										<input id="button" 	type="submit" value="Decline">
								
									</form>
								</td>
								<td>
									<form action="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik/accept" method="POST">
										<input type="hidden" name="username" value="${tempCustomer.username}" /> 
										<input type="hidden" name="fname" value="${tempCustomer.fname}" /> 
										<input type="hidden" name="lname" value="${tempCustomer.lname}" /> 
										<input type="hidden" name="email" value="${tempCustomer.email}" /> 
										<input type="hidden" name="phoneNumber" value="${tempCustomer.phoneNumber}" /> 
										<input type="hidden" name="placeOfResidence" value="${tempCustomer.placeOfResidence}" /> 
										<input type="hidden" name="placeOfStudying" value="${tempCustomer.placeOfStudying}" /> 
										<input type="hidden" name="department" value="${tempCustomer.department}" /> 
										<input type="hidden" name="yearOfAttendance" value="${tempCustomer.yearOfAttendance}" /> 
										<input type="hidden" name="familyStatus" value="${tempCustomer.familyStatus}" /> 
										<input type="hidden" name="siblingsStudying" value="${tempCustomer.siblingsStudying}" /> 
										<input type="hidden" name="annualIncome" value="${tempCustomer.annualIncome}" /> 
										<input type="hidden" name="unemployedParents" value="${tempCustomer.unemployedParents}" /> 
										<input id="button" 	type="submit" value="Accept">
									</form>
								</td>
							</c:if>
							
							<c:if test="${tempCustomer.department == 'Informatics' }" >
							<td>
								<form action="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir/decline" method="POST">
									<input type="hidden" name="username" value="${tempCustomer.username}" /> 
									<input type="hidden" name="fname" value="${tempCustomer.fname}" /> 
									<input type="hidden" name="lname" value="${tempCustomer.lname}" /> 
									<input type="hidden" name="email" value="${tempCustomer.email}" /> 
									<input type="hidden" name="phoneNumber" value="${tempCustomer.phoneNumber}" /> 
									<input type="hidden" name="placeOfResidence" value="${tempCustomer.placeOfResidence}" /> 
									<input type="hidden" name="placeOfStudying" value="${tempCustomer.placeOfStudying}" /> 
									<input type="hidden" name="department" value="${tempCustomer.department}" /> 
									<input type="hidden" name="yearOfAttendance" value="${tempCustomer.yearOfAttendance}" /> 
									<input type="hidden" name="familyStatus" value="${tempCustomer.familyStatus}" /> 
									<input type="hidden" name="siblingsStudying" value="${tempCustomer.siblingsStudying}" /> 
									<input type="hidden" name="annualIncome" value="${tempCustomer.annualIncome}" /> 
									<input type="hidden" name="unemployedParents" value="${tempCustomer.unemployedParents}" /> 
									<input id="button" 	type="submit" value="Decline">
							
								</form>
							</td>
							<td>
								<form action="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir/accept" method="POST">
									<input type="hidden" name="username" value="${tempCustomer.username}" /> 
									<input type="hidden" name="fname" value="${tempCustomer.fname}" /> 
									<input type="hidden" name="lname" value="${tempCustomer.lname}" /> 
									<input type="hidden" name="email" value="${tempCustomer.email}" /> 
									<input type="hidden" name="phoneNumber" value="${tempCustomer.phoneNumber}" /> 
									<input type="hidden" name="placeOfResidence" value="${tempCustomer.placeOfResidence}" /> 
									<input type="hidden" name="placeOfStudying" value="${tempCustomer.placeOfStudying}" /> 
									<input type="hidden" name="department" value="${tempCustomer.department}" /> 
									<input type="hidden" name="yearOfAttendance" value="${tempCustomer.yearOfAttendance}" /> 
									<input type="hidden" name="familyStatus" value="${tempCustomer.familyStatus}" /> 
									<input type="hidden" name="siblingsStudying" value="${tempCustomer.siblingsStudying}" /> 
									<input type="hidden" name="annualIncome" value="${tempCustomer.annualIncome}" /> 
									<input type="hidden" name="unemployedParents" value="${tempCustomer.unemployedParents}" /> 
									<input id="button" 	type="submit" value="Accept">
								</form>
							</td>
							</c:if>
						</tr>
				</c:forEach>


			</table>



		</div>
	</div>