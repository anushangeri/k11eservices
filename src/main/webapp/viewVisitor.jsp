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
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />

  <link rel="stylesheet" href="https://drvic10k.github.io/bootstrap-sortable/Contents/bootstrap-sortable.css" />

  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.19.1/moment.js"></script>

  <script src="https://drvic10k.github.io/bootstrap-sortable/Scripts/bootstrap-sortable.js"></script>

  <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

	<script src="extensions/export/bootstrap-table-export.js"></script>
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
				<table  id="example"
					class="table table-striped table-bordered table-sm sortable" cellspacing="0"
					width="100%">
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
				<br>
				<center>
					<a href="vms.jsp" class="btn btn-warning btn-lg active"
						role="button" aria-pressed="true">Back</a>
				</center>
				<tbody></tbody>
				<table></table>
			</center>
		</div>
	</div>

</body>
</html>