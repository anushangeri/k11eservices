<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="loginCSS.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
    <center>
<!--         <div class="card"> -->
<!--             <a href="employeeparticulars.jsp"> -->
<!--                 <div class="eachCard crop"> -->
<!--                     <img class="center-block" src="employeeparticulars.png" alt="employeeparticulars.jpg"> -->
<!--                     <h4 class="fontheader"><b>EMPLOYEE PARTICULARS</b></h4>  -->
<!--                 </div> -->
<!--             </a> -->
<!--         </div> -->
		<div class="card">
            <a href="addEmp.jsp">
                <div class="eachCard crop">
                    <img class="center-block" src="employeeparticulars.png" alt="employeeparticulars.jpg">
                    <h4 class="fontheader"><b>MANAGE EMPLOYEE PARTICULARS</b></h4> 
                </div>
            </a>
        </div>
        
        
<!--         <div class="card"> -->
<!--             <a href="generatePayslip.jsp"> -->
<!--                 <div class="eachCard crop"> -->
<!--                     <img class="center-block" src="payslip.png" alt="payslip.jpg"> -->
<!--                     <h4 class="fontheader"><b>GENERATE PAYSLIP</b></h4>  -->
<!--                 </div> -->
<!--             </a> -->
<!--         </div> -->
<!--         <br> -->
<!--         <div class="card"> -->
<!--             <a href="generateWPPayslip.jsp"> -->
<!--                 <div class="eachCard crop"> -->
<!--                     <img class="center-block" src="payslipWP.png" alt="payslipWP.jpg"> -->
<!--                     <h4 class="fontheader"><b>GENERATE WORK PERMIT PAYSLIP</b></h4>  -->
<!--                 </div> -->
<!--             </a> -->
<!--         </div> -->
<!--         <br> -->
<!--         <div class="card"> -->
<!--             <a href="todhod_day.jsp"> -->
<!--                 <div class="eachCard crop"> -->
<!--                     <img class="center-block" src="todhod.png" alt="todhod.jpg"> -->
<!--                     <h4 class="fontheader"><b>TOD/HOD DETAILS DAY</b></h4>  -->
<!--                 </div> -->
<!--             </a> -->
<!--         </div> -->
        
<!--         <div class="card"> -->
<!--             <a href="todhod.jsp"> -->
<!--                 <div class="eachCard crop"> -->
<!--                     <img class="center-block" src="todhod.png" alt="todhodday.jpg"> -->
<!--                     <h4 class="fontheader"><b>TOD/HOD DETAILS NIGHT</b></h4>  -->
<!--                 </div> -->
<!--             </a> -->
<!--         </div> -->
        
<!--         <br> -->
<!--         <div class="card"> -->
<!--             <a href="generateEP.jsp"> -->
<!--                 <div class="eachCard crop"> -->
<!--                     <img class="center-block" src="entrypass.png" alt="entrypass.png"> -->
<!--                     <h4 class="fontheader"><b>GENERATE ENTRY PASS</b></h4>  -->
<!--                 </div> -->
<!--             </a> -->
<!--         </div> -->
        
<!--        <div class="card">
            <a href="eLearning.jsp">
                <div class="eachCard crop">
                    <img class="center-block" src="elearning.png" alt="elearning.png">
                    <h4 class="fontheader"><b>E-LEARNING</b></h4> 
                </div>
            </a>
        </div>-->
<!--         <div id='body' align='center'> -->
<!--              <div id="generatepayslip"> -->
<!--                  <form action="hello" method="post"> -->
<!--                      <br/> -->
<!--                      <input type="text" name="nricfin" class="form-control" placeholder="Enter NRIC/FIN (e.g. S1234567D)" required autofocus> -->
<!--                      <br/> -->
<!--                      <input id="paslip-month" class="form-control" type="month" name="payslipmonth" value="2017-06" required autofocus> -->
<!--                      <br/> -->
<!--                      <div class="payslipbtnstyle"> -->
<!--                          <button class="btn payslipbtn" type="submit">Generate Payslip</button> -->
<!--                      </div> -->

<!--                  </form> -->
<!--              </div> -->
<!--        </div> -->
 	<div class="card">
            <a href="managedatabase.jsp">
                <div class="eachCard crop">
                    <img class="center-block" src="elearning.png" alt="elearning.png">
                    <h4 class="fontheader"><b>MANAGE DATABASE</b></h4> 
                </div>
            </a>
        </div>
       <%
	        String responseObj = (String) request.getAttribute("responseObj");
	        if (responseObj != null) {
	            %>
	            <label class="heading"><%=responseObj%></label>
	            <%
	        }
        %>
       </center>
    </body>
</html>
