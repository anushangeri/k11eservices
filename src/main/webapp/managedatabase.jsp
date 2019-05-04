<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="loginCSS.jsp"%>
<%@page import="java.util.*"%>
<%@page import="java.io.IOException"%>
<%@page import="java.net.URL"%>
<%@page import="com.google.gdata.client.spreadsheet.SpreadsheetService"%>
<%@page import="com.google.gdata.data.spreadsheet.CustomElementCollection"%>
<%@page import="com.google.gdata.data.spreadsheet.ListEntry"%>
<%@page import="com.google.gdata.data.spreadsheet.ListFeed"%>
<%@page import="com.google.gdata.util.ServiceException"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
</head>
<body>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Table Name</th>
	      <th scope="col">Create</th>
	      <th scope="col">Update</th>
	      <th scope="col">Delete</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <th scope="row">1</th>
	      <td>Employee</td>
	      <td><form action="createEmpTbl" method="post">
                     <div class="payslipbtnstyle">
                         <button class="btn payslipbtn" type="submit">Create</button>
                     </div>
              </form>
          </td>
	      <td>Update</td>
	      <td><form action="deleteEmpTbl" method="post">
                     <div class="payslipbtnstyle">
                         <button class="btn payslipbtn" type="submit">Delete</button>
                     </div>
              </form>
          </td>
	    </tr>
	  </tbody>
	</table>
</body>
</html>