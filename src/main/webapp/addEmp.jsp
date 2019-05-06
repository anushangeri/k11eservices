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
	    
	    <!--  jQuery -->
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
		
		<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
		<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
		
		<!-- Bootstrap Date-Picker Plugin -->
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
		
		<script>
		    $(document).ready(function(){
		      var date_input=$('input[name="dob"]'); //our date input has the name "date"
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
	        String responseObj = (String) request.getAttribute("responseObj");
	        if (responseObj != null) {
	            %>
	            <label class="heading"><%=responseObj%></label>
	            <%
	        }
  %>
 <%		
 		ArrayList<String> maritalStatus = new ArrayList<String>();
 		ArrayList<String> identification = new ArrayList<String>();
 		ArrayList<String> idType = new ArrayList<String>();
 		ArrayList<String> religion = new ArrayList<String>();
 		ArrayList<String> race = new ArrayList<String>();
 		ArrayList<String> emergencyRlp = new ArrayList<String>();
 		ArrayList<String> employeeStatus = new ArrayList<String>();
 		ArrayList<String> highestQual = new ArrayList<String>();
 		
        SpreadsheetService service = new SpreadsheetService("K11CLICKS: DROPDOWN EXCEL");
        try {
        	//Dropdown for marital status START
            String maritalStatusUrl
                    = "https://spreadsheets.google.com/feeds/list/116L_MDacE0331uQDZLRQD4UKpKXfHgWKcMFeD0ne324/1/public/values";
            // Use this String as url
            URL maritalStatusurl = new URL(maritalStatusUrl);

            // Get Feed of Spreadsheet url
            ListFeed maritalStatuslf = service.getFeed(maritalStatusurl, ListFeed.class);
           
            for (ListEntry le : maritalStatuslf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                maritalStatus.add(cec.getValue("maritalstatus").trim());
            }
          //Dropdown for marital status END
          
          //Dropdown for identification START
            String identificationUrl
                    = "https://spreadsheets.google.com/feeds/list/116L_MDacE0331uQDZLRQD4UKpKXfHgWKcMFeD0ne324/2/public/values";
            // Use this String as url
            URL identificationurl = new URL(identificationUrl);

            // Get Feed of Spreadsheet url
            ListFeed identificationlf = service.getFeed(identificationurl, ListFeed.class);
           
            for (ListEntry le : identificationlf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                identification.add(cec.getValue("identification").trim());
            }
          //Dropdown for identification END
          
          //Dropdown for idType START
            String idTypeUrl
                    = "https://spreadsheets.google.com/feeds/list/116L_MDacE0331uQDZLRQD4UKpKXfHgWKcMFeD0ne324/3/public/values";
            // Use this String as url
            URL idTypeurl = new URL(idTypeUrl);

            // Get Feed of Spreadsheet url
            ListFeed idTypelf = service.getFeed(idTypeurl, ListFeed.class);
           
            for (ListEntry le : idTypelf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                idType.add(cec.getValue("idtype").trim());
            }
          //Dropdown for idType END
          
          //Dropdown for religion START
            String religionUrl
                    = "https://spreadsheets.google.com/feeds/list/116L_MDacE0331uQDZLRQD4UKpKXfHgWKcMFeD0ne324/4/public/values";
            // Use this String as url
            URL religionurl = new URL(religionUrl);

            // Get Feed of Spreadsheet url
            ListFeed religionlf = service.getFeed(religionurl, ListFeed.class);
           
            for (ListEntry le : religionlf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                religion.add(cec.getValue("religion").trim());
            }
          //Dropdown for religion END
          
          //Dropdown for race START
            String raceUrl
                    = "https://spreadsheets.google.com/feeds/list/116L_MDacE0331uQDZLRQD4UKpKXfHgWKcMFeD0ne324/5/public/values";
            // Use this String as url
            URL raceurl = new URL(raceUrl);

            // Get Feed of Spreadsheet url
            ListFeed racelf = service.getFeed(raceurl, ListFeed.class);
           
            for (ListEntry le : racelf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                race.add(cec.getValue("race").trim());
            }
          //Dropdown for race END
          
          //Dropdown for emergencyRlp START
            String emergencyRlpUrl
                    = "https://spreadsheets.google.com/feeds/list/116L_MDacE0331uQDZLRQD4UKpKXfHgWKcMFeD0ne324/6/public/values";
            // Use this String as url
            URL emergencyRlpurl = new URL(emergencyRlpUrl);

            // Get Feed of Spreadsheet url
            ListFeed emergencyRlplf = service.getFeed(emergencyRlpurl, ListFeed.class);
           
            for (ListEntry le : emergencyRlplf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                emergencyRlp.add(cec.getValue("emergencyrlp").trim());
            }
          //Dropdown for emergencyRlp END
          
          //Dropdown for employeeStatus START
            String employeeStatusUrl
                    = "https://spreadsheets.google.com/feeds/list/116L_MDacE0331uQDZLRQD4UKpKXfHgWKcMFeD0ne324/7/public/values";
            // Use this String as url
            URL employeeStatusurl = new URL(employeeStatusUrl);

            // Get Feed of Spreadsheet url
            ListFeed employeeStatuslf = service.getFeed(employeeStatusurl, ListFeed.class);
           
            for (ListEntry le : employeeStatuslf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                employeeStatus.add(cec.getValue("employeestatus").trim());
            }
          //Dropdown for employeeStatus END
          
          //Dropdown for highestQual START
            String highestQualUrl
                    = "https://spreadsheets.google.com/feeds/list/116L_MDacE0331uQDZLRQD4UKpKXfHgWKcMFeD0ne324/8/public/values";
            // Use this String as url
            URL highestQualurl = new URL(highestQualUrl);

            // Get Feed of Spreadsheet url
            ListFeed highestQuallf = service.getFeed(highestQualurl, ListFeed.class);
           
            for (ListEntry le : highestQuallf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                highestQual.add(cec.getValue("highestQual").trim());
            }
          //Dropdown for highestQual END
          
        } catch (Exception e) {
        	%>
			<h1><%=e %></h1>
			<%
        }
    %>
	<form action="addEmployee" method="post">
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="firstName">First Name: </label>
	      <input type="text" class="form-control" name="firstName" placeholder="Enter First Name" required>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="lastName">Last Name: </label>
	      <input type="text" class="form-control" name="lastName" placeholder="Enter Last Name" required>
	    </div>
	  </div>
	  
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="email">Email: </label>
	      <input type="email" class="form-control" name="email" placeholder="e.g. john.doe@gmail.com">
	    </div>
	    <div class="form-group col-md-6">
	      <label for="mobileNo">Mobile Number: </label>
	      <input type="tel" class="form-control" name="mobileNo" placeholder="e.g. 92233432" required>
	    </div>
	  </div>
	  
	  <div class="form-row">
	    <div class="form-group col-md-4">
	      <label for="gender">Gender: </label>
	      <select name="gender" class="form-control">
	      	<option value="M">Male</option>
	      	<option value="F">Female</option>
	      </select>
	    </div>
	    <div class="form-group col-md-4">
	      <label for="maritalStatus">Marital Status: </label>
	      <select name="maritalStatus" class="form-control">
	      	<%
			for(int i=0; i < maritalStatus.size(); i++)
			{
			%>
			<option value="<%=maritalStatus.get(i)%>"> <%=maritalStatus.get(i)%></option>
			<% } %>
	      </select>
	    </div>
	    <div class="form-group col-md-4">
	      <label for="dob">Date of Birth: </label>
	      <input class="form-control" id="date" name="dob" placeholder="MM/DD/YYYY" type="text"/>
	    </div>
	  </div>
	  
	  <div class="form-row">
	    <div class="form-group col-md-4">
	      <label for="nationality">Nationality: </label>
	      <select class="selectpicker countrypicker" data-flag="true" name="nationality" required></select>
	    </div>
	    <div class="form-group col-md-4">
	      <label for="pob">Place of Birth: </label>
	      <select class="selectpicker countrypicker" data-flag="true" name="pob" required></select>
	    </div>
	    <div class="form-group col-md-4">
	      <label for="identification">Identification: </label>
	      <select name="identification" class="form-control" required>
	      	<%
			for(int j=0; j < identification.size(); j++)
			{
			%>
			<option value="<%=identification.get(j)%>"> <%=identification.get(j)%></option>
			<% } %>
	      </select>
	    </div>
	  </div>
	  
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="idType">ID Type: </label>
	      <select name="idType" class="form-control" required>
	      	<%
			for(int k=0; k < idType.size(); k++)
			{
			%>
			<option value="<%=idType.get(k)%>"> <%=idType.get(k)%></option>
			<% } %>
	      </select>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="idNumber">IC Number: </label>
	      <input type="text" class="form-control" name="lastName" placeholder="SxxxxxxxJ" minlength="9" maxlength="9" required>
	    </div>
	  </div>
	  
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="religion">Religion: </label>
	      <select name="religion" class="form-control">
	      	<%
			for(int l=0; l < religion.size(); l++)
			{
			%>
			<option value="<%=religion.get(l)%>"> <%=religion.get(l)%></option>
			<% } %>
	      </select>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="race">Race: </label>
	      <select name="race" class="form-control">
	      	<%
			for(int l=0; l < race.size(); l++)
			{
			%>
			<option value="<%=race.get(l)%>"> <%=race.get(l)%></option>
			<% } %>
	      </select>
	    </div>
	  </div>
	  
	  <div class="form-row">
	    <div class="form-group col-md-4">
	      <label for="emergencyName">Emergency Contact Name: </label>
	      <input type="text" class="form-control" name="emergencyName" placeholder="Enter Emergency Contact Name">
	    </div>
	    <div class="form-group col-md-4">
	      <label for="emergencyRlp">Emergency Contact Relationship: </label>
	      <select name="emergencyRlp" class="form-control">
	      	<%
			for(int m=0; m < emergencyRlp.size(); m++)
			{
			%>
			<option value="<%=emergencyRlp.get(m)%>"> <%=emergencyRlp.get(m)%></option>
			<% } %>
	      </select>
	    </div>
	    <div class="form-group col-md-4">
	      <label for="emergencyNo">Emergency Contact Number: </label>
	      <input type="tel" class="form-control" name="emergencyNo" placeholder="e.g. 92233432">
	    </div>
	  </div>
	  
	  <div class="form-row">
	    <div class="form-group col-md-4">
	      <label for="employeeStatus">Employee Status: </label>
	      <select name="employeeStatus" class="form-control" required>
	      	<%
			for(int n=0; n < employeeStatus.size(); n++)
			{
			%>
			<option value="<%=employeeStatus.get(n)%>"> <%=employeeStatus.get(n)%></option>
			<% } %>
	      </select>
	    </div>
	    <div class="form-group col-md-4">
	      <label for="joiningDt">Joining Date: </label>
	      <input class="form-control" id="date" name="joiningDt" placeholder="MM/DD/YYYY" type="text" required/>
	    </div>
	    <div class="form-group col-md-4">
	      <label for="highestQual">Highest Qualification: </label>
	      <select name="highestQual" class="form-control" required>
	      	<%
			for(int p=0; p < highestQual.size(); p++)
			{
			%>
			<option value="<%=highestQual.get(p)%>"> <%=highestQual.get(p)%></option>
			<% } %>
	      </select>
	    </div>
	  </div>
	  
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="probDtFrm">Probation Date From: </label>
	      <input class="form-control" id="date" name="probDtFrm" placeholder="MM/DD/YYYY" type="text"/>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="probDtTo">Probation Date To: </label>
	      <input class="form-control" id="date" name="probDtTo" placeholder="MM/DD/YYYY" type="text"/>
	    </div>
	  </div>
	  
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="supervisor">Supervisor: </label>
	      <select name="supervisor" class="form-control" required>
			<option value="Nantha">Nantha</option>
			<option value="Sethu">Sethu</option>
	      </select>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="allowLogin">Allow Login 
	      	<input class="form-check-input" type="checkbox" name="allowLogin" id="exampleRadios2" value="allowLogin">
	      </label>
	      
	    </div>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Add Employee</button>
	</form>
			
</body>
</html>