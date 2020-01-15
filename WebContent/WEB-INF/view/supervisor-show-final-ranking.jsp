<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supervisor Create Final Ranking</title>

</head>
<body>
	You are a supervisor!
	<sec:authorize access="isAuthenticated()">
		<div class="ui segment">
			User:
			<sec:authentication property="principal.username" />
			, Role:
			<sec:authentication property="principal.authorities" />
		</div>
	</sec:authorize>
	<br />
	<br /> Here is the ranking list for the students that are entitled to
	get free meals from university.

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Points</th>
					<th>Place in List</th>

				</tr>
				<!-- loop over and print all submitted forms that have been retrieved from the databases -->
				<c:forEach var="temp"
					items="${arraylist_from_accepted_forms_to_finalranking}">

					<tr>
						<td>${temp.id}</td>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.points}</td>
						<td>${temp.place_in_list}</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>