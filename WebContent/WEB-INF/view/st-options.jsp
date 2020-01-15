<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Options</title>
</head>
<body>
	<%-- ${username} --%>

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
	
	<h3>${message}</h3>
	<br />
	<br /> Choose one of the following options!
	<br />
	<br />
	<br /> 1. Fill in the
	<a href="/DistributedSystems/login/main-menu-for-all/student-menu/showForm">form</a>
	in order to get free broad at the University!
	<br /> 2. Update your submitted form and
	<a href="/DistributedSystems/login/main-menu-for-all/student-menu/change-data">change</a>
	your personal data!
	<br /> 3. See the
	<a href="/DistributedSystems/login/main-menu-for-all/student-menu/showResults">points</a>
	of your form and your place in the ranking with the other students!