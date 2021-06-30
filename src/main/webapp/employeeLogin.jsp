<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="loginVMSCSS.jsp"%>
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
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://drvic10k.github.io/bootstrap-sortable/Scripts/bootstrap-sortable.js"
	type="text/javascript"></script>
<link
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
<script>
	function validateForm() {
		var idNo = document.forms["checkNRIC"]["idNo"].value;
		var first = idNo.charAt(0);
		var isDigitFirst = (first >= '0' && first <= '9');
		var second = idNo.charAt(1);
		var isDigitSecond = (second >= '0' && second <= '9');
		var third = idNo.charAt(2);
		var isDigitThird = (third >= '0' && third <= '9');
		var forth = idNo.charAt(3);
		var isDigitForth = (forth >= '0' && forth <= '9');
		var n = idNo.length;
		if (idNo != "K11ADMIN" && (!(n >= 4) ||
				!isDigitFirst || !isDigitSecond || !isDigitThird || isDigitForth))  {
			alert("PDPA Compliance: Enter ONLY last 3 digit and letter of ID Number. E.g. 409J ");
			return false;
		}
		if (idNo != "K11ADMIN" && (!(n >= 4) ||
				!isDigitFirst || !isDigitSecond || !isDigitThird || !isDigitForth))  {
			alert("PDPA Compliance: Enter ONLY last 4 digit of Passport No. E.g. 4456");
			return false;
		}
	}
	function showPassword() {
		  var x = document.getElementById("psw");
		  if (x.type === "password") {
		    x.type = "text";
		  } else {
		    x.type = "password";
		  }
	}
</script>
</head>
<body>
	<%
		session.removeAttribute("usertype");
		session.removeAttribute("name");
		session.removeAttribute("idNo");
		
		String responseObj = (String) request.getAttribute("responseObj");
		if (responseObj != null && !StringUtils.isEmpty(responseObj)) {
	%>
			<label class="heading"><%=responseObj%> </label><br>
		<%} %>
	<center>
		<form name="verifyLogin" action="verifyLogin" method="post"
			onsubmit="return validateForm()">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="idNo">ID Number: </label> <input type="text"
						class="form-control" name="idNo" id="idNo" placeholder="xxxx" oninput="this.value = this.value.toUpperCase()"
						minlength="4" maxlength="9" required>
				</div>
				<div class="form-group col-md-4">
					<label for="psw">Password</label> <input type="password" class="form-control" id="psw"
						name="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
						required><input type="checkbox" onclick="showPassword()">Show Password
				</div>
			</div>
			<br>
			<div class="form-row">
				<button type="submit" class="btn btn-primary btn-lg active">
				Login</button>
					
				<a href="/index.jsp" class="btn btn-warning btn-lg active" role="button"
					aria-pressed="true">Back</a>
			</div>
		</form>
	</center>
</body>
</html>