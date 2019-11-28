<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="loginCSS.jsp"%>
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
<html lang="en">
<head>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<style type="text/css"></style>
	    <!--  jQuery -->
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
		
		<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
		<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
		
		<!-- Bootstrap Date-Picker Plugin -->
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
		<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.5/dist/bootstrap-table.min.css">
		
<script type="text/javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script src="https://unpkg.com/bootstrap-table@1.15.5/dist/bootstrap-table.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.5/dist/bootstrap-table.min.css">
  
<script type="text/javascript">
$(document).ready(function () {
	$('#dtBasicExample').DataTable();
	$('.dataTables_length').addClass('bs-select');
	});
</script>
</head>
<body>

	<%
		ArrayList<Visitor> vList = (ArrayList<Visitor>) session.getAttribute("vList");
		String responseObj = (String) request.getAttribute("responseObj");
		if (responseObj != null) {
	%>
	<label class="heading"><%=responseObj%></label>
	<%
		}
	%>
	<div class="container body-content">
		<div class="page-header">
			<label class="heading">Visitor Management System</label> <br> <b>How
				to use:</b> Filter and View all Visitor Records. <br> <br>
			<center>
				<table data-toggle="table"
					class="table table-striped table-bordered table-sm" cellspacing="0"
					width="80%">
					<thead>
						<tr>
							<th class="th-sm">S/N</th>
							<th class="th-sm">First Name</th>
							<th class="th-sm">Last Name</th>
							<th class="th-sm">NRIC/FIN</th>
							<th class="th-sm">Visitor Contact Number</th>
							<th class="th-sm">Vehicle Number</th>
							<th class="th-sm">Host Name</th>
							<th class="th-sm">Host Contact Number</th>
							<th class="th-sm">Visitor Pass ID</th>
							<th class="th-sm">Time In</th>
							<th class="th-sm">Time Out</th>
						</tr>
					</thead>
					<tbody>
						<%
							if (!vList.isEmpty()) {
								Iterator<Visitor> vListIter = vList.iterator();
								while (vListIter.hasNext()) {
									Visitor v = vListIter.next();
							%>
									<tr>
										<td><%=v.getVmsId()%></td>
										<td><%=v.getFirstName()%></td>
										<td><%=v.getLastName()%></td>
										<td><%=v.getIdNo()%></td>
										<td><%=v.getMobileNo()%></td>
										<td><%=v.getVehicleNo()%></td>
										<td><%=v.getHostName()%></td>
										<td><%=v.getHostNo()%></td>
										<td><%=v.getVisitorCardId()%></td>
										<td><%=v.getTimeInDt()%></td>
										<td><%=v.getTimeOutDt()%></td>
									</tr>
						<%
								}
						%>

						<%
							}
						%>
					</tbody>
				</table>
				<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-table@1.15.5/dist/bootstrap-table.min.js"></script>
  
				<br>
				<center>
					<a href="vms.jsp" class="btn btn-warning btn-lg active"
						role="button" aria-pressed="true">Back</a>
				</center>
			</center>
		</div>
	</div>

</body>
</html>