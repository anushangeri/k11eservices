package net.javatutorial.DAO;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.javatutorial.entity.Employee;
import net.javatutorial.tutorials.Main;

public class EmployeesManagerDAO {
	
	public static String addEmployee(Employee em){
		Connection connection = null;
		ResultSet rs = null;
		Statement stmt = null;
		String message = "";
		try {
			connection = Main.getConnection();
			stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO EMPLOYEES "
	        		+  "(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, GENDER, MARITAL_STATUS, "
	        		+ "DOB, AGE, NATIONALITY, POB, IDENTIFICATION, ID_TYPE, ID_NO, RELIGION, "
	        		+ "RACE, MOBILE_NO, EMAIL, EMERGENCY_NAME, EMERGENCY_RLP, EMERGENCY_CONTACT, "
	        		+ "EMPLOYEE_STATUS, HIGHEST_QUAL, JOINING_DT, PROB_FROM_DT, PROB_TO_DT, "
	        		+ "PASSWORD, SALT, CREATED_DT, MODIFIED_DT)" + 
	        		"  VALUES ('" +em.getEmployeeId()+ "','" +em.getFirstName()+ "','" +em.getLastName()+ "','" 
	        		+em.getGender()+ "','" +em.getMaritalStatus()+ "','" +em.getDob()+ "'," +em.getAge()+ ",'" 
	        		+em.getNationality()+ "','" +em.getPob()+ "','" 
	        		+em.getIdentification()+ "','" +em.getIdType()+ "','" +em.getIdNo()+ "','" 
	        		+em.getReligion()+ "','" +em.getRace()+ "','" +em.getMobileNo()+ "','" +em.getEmail()+ "','"
	        		+em.getEmergencyName()+ "','" +em.getEmergencyRlp()+ "','" +em.getEmergencyNo()+ "','" 
	        		+em.getEmployeeStatus()+ "','" +em.getHighestQualification()+ "','" +em.getJoiningDt()+ "','" 
	        		+em.getProbDtFrm()+ "','" +em.getProbDtTo()+ "','" +em.getPassword()+ "','" +em.getSalt()+ "','"
	        		+em.getCreated_dt()+ "','" +em.getLast_modified_dt()+"');");
	        rs = stmt.executeQuery("SELECT LAST(NAME) FROM EMPLOYEES;");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			message = "" + e;
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			message = "" + e;
		}
		message = "Successful Added";
		return message;
	}
	public static int getNextVal(){
		Connection connection = null;
		ResultSet rs = null;
		Statement stmt = null;
		int result = 1;
		try {
			connection = Main.getConnection();
			stmt = connection.createStatement();
	        rs = stmt.executeQuery("SELECT MAX(EMPLOYEE_ID) FROM EMPLOYEES;");
	        if(rs != null) {
	        	while (rs.next()) {
		        	if(rs.getString(1) != null && !rs.getString(1).isEmpty()) {
		        		result = Integer.parseInt(rs.getString(1)) + 1;
		        	}
	                
	            }
	        }
	        
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
