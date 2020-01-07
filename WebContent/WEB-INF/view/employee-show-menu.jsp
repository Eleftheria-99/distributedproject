<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee-menu</title>
</head>
<body>
	<pre>
	                                                                                                                  <a
			href="http://localhost/DistributedSystems/employee-login/just-logged-out">Logout</a>
	</pre>
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
	${message}

	<br />
	<br /> ${users}
	<br />
	<br /> Choose one of the following options!
	<br />
	<br /> 1.Show the submitted forms in order to accept or decline some of
	them
	<br />
	<br />
	<div
		id="div button show  the submitted forms dep. dietology to employee">
		<a
			href="/DistributedSystems/employee-login/employee-menu/employee-show-the-submitted-forms-dep-diat">Show
			the submitted forms of the students of the department of dietology</a>

	</div>
	<br />
	<br />
	<div
		id="div button show  the submitted forms dep. geography to employee">
		<a
			href="/DistributedSystems/employee-login/employee-menu/employee-show-the-submitted-forms-dep-geo">Show
			the submitted forms of the students of the department of geography</a>

	</div>
	<br />
	<br />
	<div
		id="div button show  the submitted forms dep. economics  to employee">
		<a
			href="/DistributedSystems/employee-login/employee-menu/employee-show-the-submitted-forms-dep-oik">Show
			the submitted forms of the students of the department of economics</a>

	</div>
	<br />
	<br />
	<div
		id="div button show  the submitted forms dep. informatics to employee">
		<a
			href="/DistributedSystems/employee-login/employee-menu/employee-show-the-submitted-forms-dep-plir">Show
			the submitted forms of the students of the department of informatics</a>

	</div>
	<br />
	<br /> 2. Show the list with the accepted students (per department)
	from the student that has the most points to the less
	<br />
	<br />
	<div id="div button show the list for dept. of  dietology">
		<a
			href="/DistributedSystems/employee-login/employee-menu/employee-show-the-list-with-counted-points-dietology">Show
			the list for department of dietology</a>

	</div>
	<br />
	<br />
	<div id="div button show the list for dept. of geograpyhy">
		<a
			href="/DistributedSystems/employee-login/employee-menu/employee-show-the-list-with-counted-points-geography">Show
			the list for department of geography</a>

	</div>
	<br />
	<br />
	<div id="div button show the list for dept. of economics">
		<a
			href="/DistributedSystems/employee-login/employee-menu/employee-show-the-list-with-counted-points-economics">Show
			the list for department of economics</a>

	</div>
	<br />
	<br />
	<div id="div button show the list for dept. of informatics">
		<a
			href="/DistributedSystems/employee-login/employee-menu/employee-show-the-list-with-counted-points-informatics">Show
			the list for department of informatics</a>

	</div>