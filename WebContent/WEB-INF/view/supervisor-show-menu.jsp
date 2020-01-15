<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supervisor-menu</title>
<!-- <link rel="stylesheet" type="text/css" href="styles_for_supervisor.css"> -->
<!--  <link href="<c:url value="/WEB-INF/resources/css/styles_for_supervisor.css"/>" rel="stylesheet"></link>  -->
<!--  <style> <%@include file="/WEB-INF/resources/css/styles_for_supervisor.css"%></style>  -->

</head>
<body>

	<sec:authorize access="isAuthenticated()">
		<div class="ui segment">
			User:
			<sec:authentication property="principal.username" />
			, Role:
			<sec:authentication property="principal.authorities" />
		</div>
	</sec:authorize>

	<br />
	<br /> You are a supervisor!
	<!--${message}  -->
	<br />
	<br />
	<br /> Count the limit of students that are entitled to free meals for
	each department and create the final ranking for the students that are
	entitled of free eating in the university per department. The final
	ranking results from the accepted forms and after the end of the time
	that the students can apply.
	<br />
	<br />Choose one of the following options!
	<br />
		<br />
	<div id="div button create final ranking dep dietology">

		<a
			href="/DistributedSystems/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-diat">Count
			limit and create ranking dep. dietology</a>

	</div>
	<br />
	<div id="div button create final ranking dep. geography">
		<a
			href="/DistributedSystems/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-geo">Count
			limit and create ranking dep. geography</a>

	</div>
	<br />
	<div id="div button create final ranking dep. economics">
		<a
			href="/DistributedSystems/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-eco">Count
			limit and create ranking dep.economics</a>

	</div>
	<br />
	<div id="div button create final ranking dep. informatics">
		<a
			href="/DistributedSystems/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-infor">Count
			limit and create ranking dep. informatics</a>

	</div>	<br />