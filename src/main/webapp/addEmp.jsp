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
<%@page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
    <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
	
</head>
<body>
 <%		
 		ArrayList<String> maritalStatus = new ArrayList<String>();
        SpreadsheetService service = new SpreadsheetService("K11CLICKS: DROPDOWN EXCEL");
        try {
        	//Dropdown for marital status START
            String maritalStatusUrl
                    = "https://spreadsheets.google.com/feeds/list/116L_MDacE0331uQDZLRQD4UKpKXfHgWKcMFeD0ne324/1/public/values";
            // Use this String as url
            URL maritalStatusurl = new URL(maritalStatusUrl);

            // Get Feed of Spreadsheet url
            ListFeed maritalStatuslf = service.getFeed(maritalStatusurl, ListFeed.class);
            %>
            <h1><%= maritalStatuslf.getEntries()%></h1>
            <%
            for (ListEntry le : maritalStatuslf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                maritalStatus.add(cec.getValue("MARITAL_STATUS").trim());
            }
          //Dropdown for marital status END
        } catch (Exception e) {
        	%>
			<h1><%=e %></h1>
			<%
        }
    %>
	<form>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputEmail4">Email</label>
	      <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputPassword4">Password</label>
	      <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputAddress">Address</label>
	    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
	  </div>
	  <div class="form-group">
	    <label for="inputAddress2">Address 2</label>
	    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputCity">City</label>
	      <input type="text" class="form-control" id="inputCity">
	    </div>
	    <div class="form-group col-md-4">
	      <label for="inputState">Marital Status</label>
	      <select name="inputState" class="form-control">
	      	<%

			for(int i=0; i < maritalStatus.size(); i++)
			{
			%>
			<option value="<%=maritalStatus.get(i)%>"> <%=maritalStatus.get(i)%></option>
			<% } %>
	      </select>
	    </div>
	    <div class="form-group col-md-2">
	      <label for="inputZip">Zip</label>
	      <input type="text" class="form-control" id="inputZip">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="form-check">
	      <input class="form-check-input" type="checkbox" id="gridCheck">
	      <label class="form-check-label" for="gridCheck">
	        Check me out
	      </label>
	    </div>
	  </div>
	  <button type="submit" class="btn btn-primary">Sign in</button>
	</form>
           <%
           for(int f=0; f < maritalStatus.size(); f++)
			{
				System.out.println(maritalStatus.get(f));
			}
           %>
			
</body>
</html>