
<%@page import="com.google.gdata.data.spreadsheet.CellEntry"%>
<%@page import="com.google.gdata.data.spreadsheet.Cell"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="net.javatutorial.entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="loginCSS.jsp"%>
<%@page import="java.util.*"%>
<%@page import="java.io.IOException"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gdata.client.spreadsheet.SpreadsheetService"%>
<%@page import="com.google.gdata.data.spreadsheet.CustomElementCollection"%>
<%@page import="com.google.gdata.data.spreadsheet.ListEntry"%>
<%@page import="com.google.gdata.data.spreadsheet.ListFeed"%>
<%@page import="com.google.gdata.util.ServiceException"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
        <script>
	        $.fn.datepicker.defaults.format = "mm/dd/yyyy";
	        $('.datepicker').datepicker({
	            startDate: '-3d'
	        });
        </script>
	</head>

	<body>
		<form action="todHodSearch" method="post">
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="site">Site: </label>
		      <input type="text" class="form-control" name="site" placeholder="Enter Site Name">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="idNo">NRIC/FIN: </label>
		      <input type="text" class="form-control" name="idNo" placeholder="Enter NRIC/FIN">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="from">From: </label>
		      <input class="datepicker" name="from" data-date-format="mm/dd/yyyy">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="to">To: </label>
		      <input class="datepicker" name="to" data-date-format="mm/dd/yyyy">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="idNo">NRIC/FIN: </label>
		      <input type="text" class="form-control" name="idNo" placeholder="Enter NRIC/FIN">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="shift">Select Shift Type: </label>
		      <select class="form-control" name="shift">
			    <option>Day</option>
			    <option>Night</option>
			  </select>
		    </div>
		    <button type="submit" class="btn btn-primary">Search NRIC/FIN</button>
		    </div>
		</form>
    </body>
</html>
