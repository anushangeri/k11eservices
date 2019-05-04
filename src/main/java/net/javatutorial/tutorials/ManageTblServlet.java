package net.javatutorial.tutorials;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManageTblServlet
 */
public class ManageTblServlet extends HttpServlet {
	
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String responseObj = "Successful";
		Connection connection;
		try {
			connection = Main.getConnection();
			Statement stmt = connection.createStatement();
//	        stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
	        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS EMPLOYEES(\r\n" + 
	        		"   EMPLOYEE_ID   VARCHAR (100)              NOT NULL,\r\n" + 
	        		"   FIRST_NAME VARCHAR (100)     NOT NULL,\r\n" + 
	        		"   LAST_NAME VARCHAR (100)     NOT NULL,\r\n" + 
	        		"   GENDER VARCHAR (2)     NOT NULL,	# M,F\r\n" + 
	        		"   MARITAL_STATUS VARCHAR (50)     NULL, #SINGLE, MARRIED, DIVORCED [K11CLICKS: DROPDOWN EXCEL]\r\n" + 
	        		"   DOB DATE     NOT NULL,\r\n" + 
	        		"   AGE  INT     NOT NULL,\r\n" + 
	        		"   NATIONALITY VARCHAR (100)     NOT NULL,\r\n" + 
	        		"   POB VARCHAR (100)     NULL, #PLACE OF BIRTH\r\n" + 
	        		"   IDENTIFICATION VARCHAR (100)    NOT NULL, #CITIZEN, PR, WORKPERMIT [K11CLICKS: DROPDOWN EXCEL]\r\n" + 
	        		"   ID_TYPE VARCHAR (50)    NOT NULL, #NRIC, FIN, PASSPORT NO. [K11CLICKS: DROPDOWN EXCEL]\r\n" + 
	        		"   ID_NO VARCHAR (100)    NOT NULL, \r\n" + 
	        		"   RELIGION VARCHAR (100)     NULL, #[K11CLICKS: DROPDOWN EXCEL]\r\n" + 
	        		"   RACE VARCHAR (100)     NULL, #[K11CLICKS: DROPDOWN EXCEL]\r\n" + 
	        		"   MOBILE_NO  VARCHAR (100) NOT NULL,   \r\n" + 
	        		"   EMERGENCY_NAME  VARCHAR (100) NOT NULL, \r\n" + 
	        		"   EMERGENCY_RLP  VARCHAR (50) NULL,  #EMERGENCY RELATIONSHIP: FATHER, MOTHER [K11CLICKS: DROPDOWN EXCEL]\r\n" + 
	        		"   EMERGENCY_CONTACT  VARCHAR (100) NOT NULL,\r\n" + 
	        		"   EMAIL  VARCHAR (100) NULL,\r\n" + 
	        		"   ALLOW_LOGIN VARCHAR (2)     NOT NULL,	# Y,N\r\n" + 
	        		"   EMPLOYEE_STATUS VARCHAR(50) NOT NULL, #DIRECTOR, MGMT, SECURITY OFFICER [K11CLICKS: DROPDOWN EXCEL]\r\n" + 
	        		"   JOINING_DT DATE     NOT NULL,\r\n" + 
	        		"   PROB_FROM_DT DATE   NULL, #PROBATION PERIOD\r\n" + 
	        		"   PROB_TO_DT DATE   NULL,	#PROBATION PERIOD\r\n" + 
	        		"   SUPERVISOR_NAME VARCHAR (100)     NOT NULL, #RETRIEVE DIRECTOR,MGMT AND DROPDOWN\r\n" + 
	        		"   HIGHEST_QUAL VARCHAR (100)     NOT NULL, #[K11CLICKS: DROPDOWN EXCEL]\r\n" + 
	        		"   PRIMARY KEY (EMPLOYEE_ID)\r\n" + 
	        		");");
//	        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
//	        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
//	        while (rs.next()) {
//	        	responseObj = responseObj + "Read from DB: " + rs.getTimestamp("tick");
//	        }
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			responseObj = responseObj + "Read from DB: " + e;
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			responseObj = responseObj + "Read from DB: " + e;
		}
        
        
		
		request.setAttribute("responseObj", responseObj);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}

}
