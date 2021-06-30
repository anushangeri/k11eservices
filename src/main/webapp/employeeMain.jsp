<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="loginVMSCSS.jsp"%>
<%@page import="java.util.*"%>
<%@page import="java.io.IOException"%>
<%@page import="java.net.URL"%>
<%@page import="com.google.gdata.client.spreadsheet.SpreadsheetService"%>
<%@page
	import="com.google.gdata.data.spreadsheet.CustomElementCollection"%>
<%@page import="com.google.gdata.data.spreadsheet.ListEntry"%>
<%@page import="com.google.gdata.data.spreadsheet.ListFeed"%>
<%@page import="com.google.gdata.util.ServiceException"%>
<%@page import="net.javatutorial.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://drvic10k.github.io/bootstrap-sortable/Scripts/bootstrap-sortable.js"
	type="text/javascript"></script>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
</head>
<body>
	<center>
		<label class="heading">Welcome! Hi, <%=request.getSession(false).getAttribute("name")%></label>
			
		<div class="container">
			<form action="vms" method="get" >
				<button type="submit" id="removeBackground">
					<div class="card bg-dark text-white">
						<div class="card-body font-size-percent">
							View Visitor Records<br> 
							Select this.

						</div>
					</div>
				</button>
			</form>
			<br>
			<form action="vehms" method="get" >
				<button type="submit" id="removeBackground">
					<div class="card bg-warning text-white">
						<div class="card-body font-size-percent">
							View Vehicle Records<br>
							Select this.
						</div>
					</div>
				</button>
			</form>
			<br>
		</div>
	</center>
	<div class="container body-content">
		<center>
			<a href="employeeLogin.jsp" class="btn btn-warning btn-lg active"
				role="button" aria-pressed="true">Back</a>
		</center>
	</div>
	<div class="container body-content">
		<center>
			<!-- Create client account is for K11 Admin only -->
			<%if (request.getSession(false).getAttribute("usertype") != null) {
				String userInput = (String) request.getSession(false).getAttribute("usertype");
				if (!userInput.toUpperCase().equals("SECURITY OFFICER")){ %>
					<a href="addEmp.jsp" class="btn btn-warning btn-lg active"
					role="button" aria-pressed="true">Create Employee Record</a>
					<a href="/retrieveAllClientRecords" class="btn btn-warning btn-lg active"
					role="button" aria-pressed="true">Manage Employee Records</a>
					<br>
				<%	
				}
			%>
			<% 
			}
			%>
		</center>
	</div>
</body>
</html>
