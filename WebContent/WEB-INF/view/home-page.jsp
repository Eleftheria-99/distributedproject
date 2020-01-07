<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>  
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
            <!--  <meta charset="ISO-8859-1">  -->
<title>Home Page</title>
</head>
<body>
<b>Welcome to our system!</b>
<br>
<br>
<br>
<br>
Are you a student or an employee or a supervisor?
<br>
<br>

<div id="button to go from home page to student-login">
<form method = "GET" action = "/DistributedSystems/student-login">   
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Go to student login"/>
               </td>
            </tr>
         </table>  
      </form>
</div>
<!--    
<form id="submitbutton" name="main" action="/DistributedSystems/employee-login" onsubmit="showEmployeeLogIn()">
    <input type="submit" name="submit"/> 
</form>
-->
<br><br>
<div id="button to go from home page to employee-login">
	<form method = "GET" action = "/DistributedSystems/employee-login">      <!-- /DistributedSystems -->
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Go to employee login"/>
               </td>
            </tr>
         </table>  
      </form>
</div>
<br><br>
<div id="button to go from home page to supervisor-login">
	<form method = "GET" action = "/DistributedSystems/supervisor-login">      
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Go to supervisor login"/>
               </td>
            </tr>
         </table>  
      </form>
</div>
<br><br>
