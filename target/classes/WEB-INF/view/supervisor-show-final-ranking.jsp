<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">

* {
  box-sizing: border-box;
}

body {
	min-height: 100vh;
	position: relative;
}

.table-container{
	text-align:center;
}
content{
	text-align:center;
}



</style>


<title>Supervisor Create Final Ranking</title>

</head>
<body>
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
	<br /> Here is the ranking list for the students that are entitled to
	get free meals from university.

	<div class="table-container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Id / Place in The List   </th>
					<th>First Name   </th>
					<th>Last Name   </th>
					<th>Points </th>
				</tr>
				<!-- loop over and print all submitted forms that have been retrieved from the databases -->
				<c:forEach var="temp"
					items="${arraylist_from_accepted_forms_to_finalranking}">

					<tr>
						<td>${temp.id}</td>
						<td>${temp.fname}</td>
						<td>${temp.lname}</td>
						<td>${temp.points}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>