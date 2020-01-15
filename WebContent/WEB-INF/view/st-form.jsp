<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student form</title>
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
	${errormessage}
	<br />
	<br />
	<h3>Fill in the form below:</h3>
	
	<form
		action="/DistributedSystems/login/main-menu-for-all/student-menu/showForm/StudentForm"
		method="GET">
		<h3>Department :<i> ${department}</i></h3>
		<br>
		<table>
			<tbody>
				<tr>
					<td>First Name :</td>
					<td><input name="fname" type="text" size="30" value="" /></td>
				</tr>
				<tr>
					<td>Last Name :</td>
					<td><input name="lname" type="text" size="30" value="" /></td>
				</tr>
				<tr>
					<td>E-mail :</td>
					<td><input name="email" type="text" size="30" value="" /></td>
				</tr>
				<tr>
					<td>Phone number :</td>
					<td><input name="phonenumber" type="number" size="30" value=""
						required /></td>
				</tr>
				<tr>
					<td>Place of residence :</td>
					<td><input name="placeofliving" type="text" size="30" value=""></td>
				</tr>
				<tr>
					<td>Place of studying :</td>
					<td><input name="placeofstudying" type="text" size="30"
						value=""></td>
				</tr>

				<tr>
					<td>Year of attendance :</td>
					<td><input name="yearofattendance" type="number" size="30"
						value="" required /></td>
				</tr>
				<tr>
					<td>Family status :</td>
					<td><select name="FamilyStatus">
							<option value="Single">Single</option>
							<option value="Married">Married</option>
							<option value="Widowed">Widowed</option>
							<option value="Divorced">Divorced</option>
					</select></td>
				</tr>
				<tr>
					<td>Number of siblings who study :</td>
					<td><input name="numofsiblingswhostudy" type="number"
						size="30" value="" required></td>
				</tr>
				<tr>
					<td>Family annual financial income :</td>
					<td><select name="FinancialIncome">
							<option value="zero">0</option>
							<option value="lower than 10.000">lower than 10.000</option>
							<option value="10.000 - 15.000">10.000 - 15.000</option>
							<option value="higher than 15.000">higher than 15.000</option>
					</select></td>
				</tr>
				<tr>
					<td>Number of unemployed parents :</td>
					<td><select name="UnemployedParents">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
					</select></td>
				</tr>

			</tbody>
		</table>
		<br /> <input type="submit" value="Submit Form" /> <br />
	</form>