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

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<style type="text/css"></style>
<script type="text/javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#escalation').DataTable();
	});
</script>
</head>
<body>
	<div class="container body-content">
		<div class="page-header">
			<label class="heading">Visitor Management System</label> <br> <b>How
				to use:</b> Filter and View all Visitor Records. <br> <br>
			<center>
				<div style="display: block; width: 80%" id="todhodtablediv">
					<display:table name="sessionScope.vList" pagesize="20"
						export="true" sort="list" class="table">
						<display:column property="vmsId" title="S/N" sortable="true"
							headerClass="sortable" />
						<display:column property="firstName" title="First Name" sortable="true"
							headerClass="sortable" />
						<display:column property="lastName" title="Last Name" sortable="true"
							headerClass="sortable" />
						<display:column property="idNo" title="NRIC/FIN" sortable="true"
							headerClass="sortable" />
						<display:column property="mobileNo" title="Visitor Contact Number"
							sortable="true" headerClass="sortable" />
						<display:column property="vehicleNo" title="Vehicle Number"
							sortable="true" headerClass="sortable" />
						<display:column property="hostName" title="Host Name"
							sortable="true" headerClass="sortable" />
						<display:column property="hostNo" title="Host Contact Number"
							sortable="true" headerClass="sortable" />
						<display:column property="visitorCardId" title="Visitor Pass ID"
							sortable="true" headerClass="sortable" />
						<display:column property="timeInDt" title="Time In"
							sortable="true" headerClass="sortable" />
						<display:column property="timeOutDt" title="Time Out"
							sortable="true" headerClass="sortable" />
					</display:table>
				</div>
				<br> <br>
				<center>
					<a href="vms.jsp" class="btn btn-warning btn-lg active"
						role="button" aria-pressed="true">Back</a>
				</center>
			</center>
		</div>
	</div>

</body>
</html>