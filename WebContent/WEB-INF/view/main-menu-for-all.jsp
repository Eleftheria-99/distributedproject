<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <link rel="stylesheet" type="text/css" href="styles_for_supervisor.css"> -->
<!--  <link href="<c:url value="/WEB-INF/resources/css/styles_for_supervisor.css"/>" rel="stylesheet"></link>  -->
<!--  <style> <%@include file="/WEB-INF/resources/css/styles_for_supervisor.css"%></style>  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Main menu for all users</title>
</head>
<body>
	<!-- 	<pre>
	                           <a id="logout-nav" class="item" > <i class="sign out icon"></i> Logout</a>
	                                                                                                                  <a href="/DistributedSystems/just-logged-out">Logout</a>
	</pre>
 -->
	<br>
	<br>
	<br>
	<br> Based on your role(student or an employee or a supervisor), a
	suitable menu for you will be shown!
	<sec:authorize access="isAuthenticated()">
		<div class="ui segment">
			<pre>
	                     	                                                                                                                  <a
					href="/DistributedSystems/just-logged-out">Logout</a>
	</pre>
			You are the user:
			<sec:authentication property="principal.username" />
			and your role is:
			<sec:authentication property="principal.authorities" />
		</div>
	</sec:authorize>
	<!-- <h3>${message}</h3> -->
	<br>
	<sec:authorize access="hasAuthority('student')">
		<div id="button to go from student-menu to the chosen option ">

			<br /> Choose one of the following options! <br /> <br /> <br />
			1. Fill in the <a
				href="/DistributedSystems/login/main-menu-for-all/student-menu/showForm">form</a>
			in order to get free broad at the University! <br /> 2. Update your
			submitted form and <a
				href="/DistributedSystems/login/main-menu-for-all/student-menu/change-data">change</a>
			your personal data! <br /> 3. See the <a
				href="/DistributedSystems/login/main-menu-for-all/student-menu/showResults">points</a>
			of your form and your place in the ranking with the other students!

		</div>
	</sec:authorize>
	<br>
	<br>
	<sec:authorize access="hasAuthority('employee')">
		<div id="button to go from employee-menu to the chosen option ">

			<br /> Choose one of the following options! <br /> <br /> 1.Show
			the submitted forms in order to accept or decline some of them <br />
			<br />
			<div
				id="div button show  the submitted forms dep. dietology to employee">
				<a
					href="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat">Show
					the submitted forms of the students of the department of dietology</a>

			</div>
			<br /> <br />
			<div
				id="div button show  the submitted forms dep. geography to employee">
				<a
					href="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo">Show
					the submitted forms of the students of the department of geography</a>

			</div>
			<br /> <br />
			<div
				id="div button show  the submitted forms dep. economics  to employee">
				<a
					href="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik">Show
					the submitted forms of the students of the department of economics</a>

			</div>
			<br /> <br />
			<div
				id="div button show  the submitted forms dep. informatics to employee">
				<a
					href="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir">Show
					the submitted forms of the students of the department of
					informatics</a>

			</div>
			<br /> <br /> 2. Show the list with the accepted students (per
			department) from the student that has the most points to the less <br />
			<br />
			<div id="div button show the list for dept. of  dietology">
				<a
					href="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-list-with-counted-points-dietology">Show
					the list for department of dietology</a>

			</div>
			<br /> <br />
			<div id="div button show the list for dept. of geograpyhy">
				<a
					href="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-list-with-counted-points-geography">Show
					the list for department of geography</a>

			</div>
			<br /> <br />
			<div id="div button show the list for dept. of economics">
				<a
					href="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-list-with-counted-points-economics">Show
					the list for department of economics</a>

			</div>
			<br /> <br />
			<div id="div button show the list for dept. of informatics">
				<a
					href="/DistributedSystems/login/main-menu-for-all/employee-menu/employee-show-the-list-with-counted-points-informatics">Show
					the list for department of informatics</a>

			</div>

		</div>
	</sec:authorize>

	<br>
	<br>
	<sec:authorize access="hasAuthority('supervisor')">
		<div id="button to go from supervisor-menu to the chosen option ">
			<br /> Count the limit of students that are entitled to free meals
			for each department and create the final ranking for the students
			that are entitled of free eating in the university per department.
			The final ranking results from the accepted forms and after the end
			of the time that the students can apply. <br /> <br />Choose one of
			the following options! <br /> <br />
			<div id="div button create final ranking dep dietology">

				<a
					href="/DistributedSystems/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-diat">1.Count
					limit and create ranking dep. dietology</a>

			</div>
			<br />
			<div id="div button create final ranking dep. geography">
				<a
					href="/DistributedSystems/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-geo">2.Count
					limit and create ranking dep. geography</a>

			</div>
			<br />
			<div id="div button create final ranking dep. economics">
				<a
					href="/DistributedSystems/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-eco">3.Count
					limit and create ranking dep.economics</a>

			</div>
			<br />
			<div id="div button create final ranking dep. informatics">
				<a
					href="/DistributedSystems/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-infor">4.Count
					limit and create ranking dep. informatics</a>

			</div>
			<br />
		</div>
	</sec:authorize>
	<br>
	<br>