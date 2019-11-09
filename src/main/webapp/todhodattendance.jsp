
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
    	<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
        <!-- Bootstrap Date-Picker Plugin -->
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
        <script>
        	$(document).ready(function(){
		      var date_input=$('input[name="from"]'); //our date input has the name "date"
		      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		      var options={
		        format: 'mm/dd/yyyy',
		        container: container,
		        todayHighlight: true,
		        autoclose: true,
		      };
		      date_input.datepicker(options);
		    })
		    
        </script>
	</head>

	<body>
	<%
		ArrayList<String> responseObj = (ArrayList<String>) request.getAttribute("responseObj");
		if (responseObj != null) {
	%>
			<label class="heading"><%=responseObj.toString() %></label>
	<%
		}
		String nricfin = "";
		if ( !(session.getAttribute("nricfin") == null)) {
			nricfin = (String) session.getAttribute("nricfin");
		}
		String site = request.getParameter("site");
	%>
	<center> 
	<form action="todhodattendance" method="post">
		<div class="form-row">
			<div class="form-group col-md-6">
			 <%if (!StringUtils.isEmpty(site)){
		    	%>
		    		 <input type="text" id="site" name="site" value=<%=site%>>
		    	<%
		    } 
		    else{//in case session empty
		    	%>
		    		<label for="site">Site: </label> <input class="form-control"
					id="site" name="site" placeholder="Enter Site" type="text" required />
		    	<%	
		    	}
		    %>
		   </div>
			<div class="form-group col-md-6">
				<label for="smth">Smth: </label> <input class="form-control"
					id="smth" name="smth" placeholder="Fill smth" type="text" required />
			</div>
			<div class="form-group col-md-6">
		    <%if (!StringUtils.isEmpty(nricfin)){
		    	%>
		    		 <input type="text" id="idNo" name="idNo" value=<%=nricfin%>>
		    	<%
		    } 
		    else{//in case session empty
		    	%>
		    		<label for="idNo">NRIC/FIN: </label>
		      		<input type="text" class="form-control" name="idNo" placeholder="Enter NRIC/FIN">
		    	<%	
		    	}
		    %>
		    </div>
			<button type="submit" class="btn btn-primary">Login</button>
		</div>
	</form>
	</center>
    </body>
</html>
