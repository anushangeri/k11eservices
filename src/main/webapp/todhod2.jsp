
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
    <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

    <script>
        $(document).ready(function () {
            $('#escalation').DataTable();
        });
    </script>
</head>

<body>

        <%
            List<Employee> players = new ArrayList<Employee>();
            players.add(new Employee("Virat", "98273633", "Mohali"));
            players.add(new Employee("Mahendara", "98273634", "Ranchi"));
            players.add(new Employee("Virender", "98273635", "Delhi"));
            players.add(new Employee("Ajinkya", "98273636", "Jaipur"));
            players.add(new Employee("Gautam", "98273637", "Delhi"));
            players.add(new Employee("Rohit", "98273637", "Delhi"));
            players.add(new Employee("Ashok", "98273637", "Delhi"));
            players.add(new Employee("Ravi", "98273637", "Delhi"));

            session.setAttribute("players", players);
            
            List<Employee> stars = new ArrayList<Employee>();
            stars.add(new Employee("Shahrukh", "98273637", "Delhi"));
            stars.add(new Employee("Sallu", "98273637", "Delhi"));
            stars.add(new Employee("Roshan", "98273637", "Delhi"));
            stars.add(new Employee("Devgan", "98273637", "Delhi"));
            stars.add(new Employee("Hashmi", "98273637", "Delhi"));
            stars.add(new Employee("Abraham", "98273637", "Delhi"));
            stars.add(new Employee("Kumar", "98273637", "Delhi"));
            stars.add(new Employee("Shetty", "98273637", "Delhi"));
           
            session.setAttribute("stars", stars);

        %>



        <div id='tab1' class="tab_content" style="display: block; width: 100%">
            <h3>Display tag Pagination and Sorting Example</h3>
            <p>This is FIRST TABLE </p>
            <display:table name="sessionScope.players" pagesize="5"
                           export="true" sort="list" uid="one">
                <display:column property="firstName" title="Name"
                                sortable="true" headerClass="sortable" />
                <display:column property="lastName" title="Mobile"
                                sortable="true" headerClass="sortable" />
                <display:column property="idNo" title="Resident"
                                sortable="true" headerClass="sortable" />
            </display:table>
        </div>
       
        <div id='tab2' class="tab_content" style="width: 100%">
            <h3>Table 2</h3>
            <p>This is SECOND TABLE</p>
            <display:table name="sessionScope.stars" pagesize="5"
                           export="false" sort="list" uid="two">
                <display:column property="firstName" title="Name"
                                sortable="true" headerClass="sortable" />
                <display:column property="lastName" title="Mobile"
                                sortable="true" headerClass="sortable" />
                <display:column property="idNo" title="Resident"
                                sortable="true" headerClass="sortable" />
            </display:table>
        </div>
    </body>
</html>
