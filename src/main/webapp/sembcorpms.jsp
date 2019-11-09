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
    <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

    <script>
        $(document).ready(function () {
            $('#escalation').DataTable();
        });
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
	<form action="sembcorptest" method="post">
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
<%--     <% --%>
//         SpreadsheetService service = new SpreadsheetService("Form Responses 1");
//         try {
// //            //getting the sheet number:
// //            String sheetNameUrl
// //                    = "https://spreadsheets.google.com/feeds/list/1Fcv9alOBh-SHR7Yxl_yiQMK05lbjJaDX7ba5AkTrK90/1/public/values";
// //
// //            // Use this String as url
// //            URL urlName = new URL(sheetNameUrl);
// //
// //            // Get Feed of Spreadsheet url
// //            ListFeed lfName = service.getFeed(urlName, ListFeed.class);
// //            String sheetNumber = "1";
// //            //Iterate over feed to get cell value
// //            for (ListEntry le : lfName.getEntries()) {
// //                CustomElementCollection cec = le.getCustomElements();
// //                //Pass column name to access it's cell values
// //                if (cec.getValue("sheetname").equals("Employment Particulars")) {
// //                    sheetNumber = cec.getValue("sheetnumber");
// //                }
// //            }
//             String sheetUrl
//                     = "https://spreadsheets.google.com/feeds/list/1VBrjNMEJTVQkcccyOEiit5pAfvbnGmQ6WjgMcnCxR-I/1/public/values";

//             // Use this String as url
//             URL url = new URL(sheetUrl);

//             // Get Feed of Spreadsheet url
//             ListFeed lf = service.getFeed(url, ListFeed.class);
<%--     %> --%>
<!--     <div class="container body-content"> -->
<!--         <div class="page-header"> -->
<!--             <label class="heading">SembCorpK11 Services</label> -->
<!--             <br> -->
<!--             <b>How to use:</b> Click on Name for Employee Details. -->
<!--             <br> -->
<!--             <br> -->
<!--             <div class="form-group"> -->
<!--                 <fieldset> -->
<!--                     <form action="sembcorptest" class="form-group" method="post"> -->
<!--                         <div class="table-responsive"> -->
<!--                             <div class="table-responsive">                             -->

<!--                                 <table id="escalation" class="table table-striped table-bordered everytable" cellspacing="0" width="100%"> -->
<!--                                     <thead> -->
<!--                                         <tr> -->
<!--                                             <th><center><b>Timestamp</b></center></th> -->
<!--                                             <th><center><b>test</b></center></th> -->
<!--                                         </tr> -->
<!--                                     </thead> -->
<!--                                     <tbody> -->

<%--                                         <% --%>
//                                             //Iterate over feed to get cell value
//                                             for (ListEntry le : lf.getEntries()) {
//                                                 CustomElementCollection cec = le.getCustomElements();
//                                                 //Pass column name to access it's cell values
//                                                 String Timestamp = cec.getValue("Timestamp");
//                                                 String test = cec.getValue("test");
<%-- %> --%>
<!--                                         <tr> -->
<%--                                             <td><center><%=Timestamp%></center></td> --%>
<%--                                             <td><center><%=test%></center></td> --%>
<!--                                         </tr> -->

<%--                                     <% --%>
//                                         }
<%--                                     %> --%>
<!--                                     </tbody> -->
<!--                                 </table> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                          <button type="submit" class="btn btn-primary">Search NRIC/FIN</button> -->
<!--                     </form>            END OF FORM ^^ -->
<!--                 </fieldset> -->
<!--             </div> -->
<!--         </div> -->
<!--     </div> -->

<%--     <% --%>
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
<%--     %> --%>
</body>
</html>