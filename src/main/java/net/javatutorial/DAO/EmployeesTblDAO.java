package net.javatutorial.DAO;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import net.javatutorial.tutorials.*;

public class EmployeesTblDAO {

	public static String createEmpTbl(){
		Connection connection;
		String message = "";
		try {
			connection = Main.getConnection();
			Statement stmt = connection.createStatement();
//	        stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
	        stmt.executeUpdate("DROP TABLE IF EXISTS EMPLOYEES; \r\n"
	        		+ "CREATE TABLE IF NOT EXISTS EMPLOYEES (\r\n" + 
	        		"   EMPLOYEE_ID   VARCHAR (100)     NOT NULL,c" + 
	        		"   FIRST_NAME VARCHAR (100)     NOT NULL,\r\n" + 
	        		"   LAST_NAME VARCHAR (100)     NOT NULL,\r\n" + 
	        		"   GENDER VARCHAR (50)      NULL,\r\n" + 
	        		"   MARITAL_STATUS VARCHAR (50)     NULL, \r\n" + 
	        		"   DOB TIMESTAMP    NOT NULL DEFAULT NOW(),\r\n" + 
	        		"   AGE  INT      NULL,\r\n" + 
	        		"   NATIONALITY VARCHAR (100)      NULL,\r\n" + 
	        		"   POB VARCHAR (100)     NULL, \r\n" + 
	        		"   IDENTIFICATION VARCHAR (100)     NULL, \r\n" + 
	        		"   ID_TYPE VARCHAR (50)     NULL, \r\n" + 
	        		"   ID_NO VARCHAR (100)    NOT NULL, \r\n" + 
	        		"   RELIGION VARCHAR (100)     NULL, \r\n" + 
	        		"   RACE VARCHAR (100)     NULL,\r\n" + 
	        		"   MOBILE_NO  VARCHAR (100)  NULL,   \r\n" + 
	        		"   EMAIL  VARCHAR (100) NULL,\r\n" + 
	        		"   EMERGENCY_NAME  VARCHAR (100)  NULL, \r\n" + 
	        		"   EMERGENCY_RLP  VARCHAR (50) NULL,  \r\n" + 
	        		"   EMERGENCY_CONTACT  VARCHAR (100)  NULL,\r\n" + 
	        		"   EMPLOYEE_STATUS VARCHAR(50)  NULL, \r\n" + 
	        		"   HIGHEST_QUAL VARCHAR (100)      NULL, \r\n" + 
	        		"   JOINING_DT TIMESTAMP    NOT NULL DEFAULT NOW(),\r\n" + 
	        		"   PROB_FROM_DT TIMESTAMP   NOT NULL DEFAULT NOW(), \r\n" + 
	        		"   PROB_TO_DT TIMESTAMP   NOT NULL DEFAULT NOW(),	\r\n" + 
	        		"   PASSWORD  VARCHAR (255) NOT NULL,   \r\n" + 
	        		"   SALT  VARCHAR (8000) NOT NULL,   \r\n" + 
	        		

	        		"   CREATED_DT TIMESTAMP  NOT NULL DEFAULT NOW(),\r\n" + 
	        		"   MODIFIED_DT TIMESTAMP   NOT NULL DEFAULT NOW(), \r\n" + 
	        		"   PRIMARY KEY (EMPLOYEE_ID) \r\n" + 
	        		");");
//	        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
//	        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
//	        while (rs.next()) {
//	        	responseObj = responseObj + "Read from DB: " + rs.getTimestamp("tick");
//	        }
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			message = "" + e;
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			message = "" + e;
		}
		message = "Successful";
		return message;
	}
	public static String deleteEmpTbl(){
		Connection connection;
		String message = "";
		try {
			connection = Main.getConnection();
			Statement stmt = connection.createStatement();
//	        stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
	        stmt.executeUpdate("DROP TABLE EMPLOYEES;");
//	        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
//	        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
//	        while (rs.next()) {
//	        	responseObj = responseObj + "Read from DB: " + rs.getTimestamp("tick");
//	        }
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			message = "" + e;
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			message = "" + e;
		}
		message = "Successful";
		return message;
	}
	
	public static String updateEmpTbl(){
		Connection connection;
		String message = "";
		try {
			connection = Main.getConnection();
			Statement stmt = connection.createStatement();
	        stmt.executeUpdate("ALTER TABLE EMPLOYEES\r\n" + 
	        		"ADD COLUMN PASSWORD VARCHAR(100) NOT NULL,\r\n" + 
	        		"ADD COLUMN CREATED_BY VARCHAR(100) NOT NULL,\r\n" + 
	        		"ADD COLUMN CREATED_DT DATE NOT NULL,\r\n" + 
	        		"ADD COLUMN LAST_MODIFIED_BY VARCHAR(100) NOT NULL,\r\n" + 
	        		"ADD COLUMN LAST_MODIFIED_DT DATE NOT NULL;");
//	        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
//	        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
//	        while (rs.next()) {
//	        	responseObj = responseObj + "Read from DB: " + rs.getTimestamp("tick");
//	        }
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			message = "" + e;
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			message = "" + e;
		}
		message = "Successful";
		return message;
	}
}
