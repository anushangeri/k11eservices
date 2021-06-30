package net.javatutorial.DAO;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	        rs = stmt.executeQuery("SELECT FIRST_NAME FROM EMPLOYEES ORDER BY MODIFIED_DT LIMIT 1;");
	        message = "Successful Added";
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			message = "" + e;
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			message = "" + e;
		}
		
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
	        rs = stmt.executeQuery("SELECT MAX(REPLACE(Employee_id, 'K11_', '')) FROM EMPLOYEES;");
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
	
	public static ArrayList<Employee> retrieveByID(String idNo) {
        PreparedStatement pstmt = null;
        Connection connection = null;
        ResultSet rs = null;
        Employee v = null;
        ArrayList<Employee> vList = new ArrayList<Employee>();
        try {
        	connection = Main.getConnection();
            String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, GENDER, MARITAL_STATUS, " + 
            		"DOB, AGE, NATIONALITY, POB, IDENTIFICATION, ID_TYPE, ID_NO, RELIGION, " + 
            		"RACE, MOBILE_NO, EMAIL, EMERGENCY_NAME, EMERGENCY_RLP, EMERGENCY_CONTACT, " + 
            		"EMPLOYEE_STATUS, HIGHEST_QUAL, JOINING_DT, PROB_FROM_DT, PROB_TO_DT, " + 
            		"PASSWORD, SALT, CREATED_DT, MODIFIED_DT"
            		+ " FROM EMPLOYEES "
            		+ " WHERE ID_NO ='" + idNo + "' \r\n"
    				+ " ORDER BY MODIFIED_DT DESC";
            pstmt = connection.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
            	v = new Employee(rs.getString(1), 
            			rs.getString(2),
            			rs.getString(3),
            			rs.getString(4),
            			rs.getString(5),
            			rs.getTimestamp(6),
            			rs.getInt(7),
            			rs.getString(8),
            			rs.getString(9),
            			rs.getString(10),
            			rs.getString(11),
            			rs.getString(12),
            			rs.getString(13),
            			rs.getString(14),
            			rs.getString(15),
            			rs.getString(16),
            			rs.getString(17),
            			rs.getString(18),
            			rs.getString(19),
            			rs.getString(20),
            			rs.getString(21),
            			rs.getTimestamp(22),
            			rs.getTimestamp(23),
            			rs.getTimestamp(24),
            			rs.getString(25),
            			rs.getString(26),
            			rs.getTimestamp(27),
            			rs.getTimestamp(28));
                vList.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	Main.close(connection, pstmt, rs);
        }
        return vList;
    }
}
