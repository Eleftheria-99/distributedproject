<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Personal Data</title>
</head>
<body>
	<pre>
	                                                                                                                  <a
			href="/DistributedSystems/st-just-logged-out">Logout</a>
	</pre>
	<h3>Here you can change some of your personal data, so we can be
		able to communicate with you!</h3>
	<br />
	<form action="/DistributedSystems/student-login/options/change-data/newForm" method="get">
		<table>
			<tr>
				<td>First, please choose which department you study in:</td>
			</tr>
		</table>
		<table>
			<tbody>
				<tr>
					<td>Department :</td>
					<td><select name="Department">
							<!-- <option value="">Choose an option...</option> -->
							<option value="Informatics">Informatics</option>
							<option value="Geography">Geography</option>
							<option value="Nutrition">Nutrition</option>
							<option value="Economics">Economics</option>
					</select></td>
				</tr>
				<tr>
					<td><br /></td>
				</tr>
				<tr>
					<td>E-mail :</td>
					<td><input name="email" type="text" size="30" value="" /></td>
				</tr>
				<tr>
					<td>Phone number :</td>
					<td><input name="phonenumber" type="number" size="30" value=""
						required required /></td>
				</tr>
				<tr>
					<td>Place of residence :</td>
					<td><input name="placeofliving" type="text" size="30" value=""></td>
				</tr>
			</tbody>
		</table>
		<br /> <input type="submit" value="Submit Form" /> <br />
	</form>
	<form id="backbutton" name="back" action="/DistributedSystems/student-login/options"
		method="post" onsubmit="Options()">
		<!-- <input type="submit" value="Back" /> -->
	</form>