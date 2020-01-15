<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- body
	text-align: justify;   text-align: justify and the following few lines of codes inclusive allows my navigation elements to have equal spaces within between them no matter how many elements there are
-->
<style type="text/css">

* {
  box-sizing: border-box;
}
.body-wrapper {
	margin: 0 auto;
	/* Shorthand for margin. Auto on left and right allows .wrap to be centered in the browser */
}

/* Left and right column */
.column-left {
    margin-top: 50px;   /*na apexei apo panw toso */
	float: left;
	width: 25%;
}

.column-right {
 margin-top: 50px;   /*na apexei apo panw toso */
	float: right;
	text-align:center;
	width: 25%;
}
/* Middle column */
.column-middle {
    margin-top: 50px;  
	display: inline-block;
	width: 50%;
	/* text-align: justify; */
	/* text-align: justify and the following few lines of codes inclusive allows my navigation elements to have equal spaces within between them no matter how many elements there are.*/
}
.login{
	float: left;
}
</style>

<title>Home Page</title>
</head>
<body>

	<div class="body-wrapper">
		<div class="column-left">
			<ul>
				<li><a>Announcements</a></li>
				<li>Events</li>
				<li>Lectures</li>
				<li>Workshops</li>
				<li>Photos</li>
			</ul>
		</div>


		<div class="column-middle">
		<div class="login" > You can 
			<a href="/DistributedSystems/login/"> login </a> here.
			</div>

<br/>
			<h3>General information about the university</h3>
			Harokopio University of Athens is a public university dedicated to
			promoting research and learning in a small, well focused set of
			intellectual areas. The university, situated in the centre of Athens
			and close to the Unesco World Heritage Centre of the Acropolis,
			originates from an educational institution that was first established
			in 1929 and gained the status of University in 1990. It takes its
			name from the national benefactor Panagis Harokopos. The University’s
			excellent campus facilities houses four academic departments, the
			central administration, the library, the IT centre and student
			advisory services. Harokopio University of Athens is located close to
			many important cultural sites of interest such as the Acropolis
			Museum, Thissio,Panathenaic Stadium (Kallimarmaron), Keramikos and
			the Benaki Museum.
		</div>

		<div class="column-right">Latest News</div>
	</div>