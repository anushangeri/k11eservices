package net.javatutorial.DAO;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.javatutorial.entity.Employee;
import net.javatutorial.entity.Visitor;
import net.javatutorial.tutorials.Main;

public class VMSManagerDAO {
	
	public static String addVisitor(Visitor v){
		Connection connection;
		String message = "";
		try {
			connection = Main.getConnection();
			Statement stmt = connection.createStatement();

	        stmt.executeUpdate("INSERT INTO VMS "
	        		+  "(VMS_ID, FIRST_NAME, LAST_NAME, ID_NO, MOBILE_NO, VEHICLE_NO, HOST_NAME, HOST_CONTACT, VISTOR_CARD_ID, TIME_IN_DT)" + 
	        		"   VALUES ('" +v.getVmsId()+ "','" +v.getFirstName()+ "','" +v.getLastName()+ "','" +v.getIdNo()+ "','" +v.getMobileNo()+ "','"
	        		+v.getVehicleNo()+ "','" +v.getHostName()+ "','" +v.getHostNo()+ "','" +v.getVisitorCardId()+ "','" +v.getTimeInDt()+ 
	        		"')");
	        ResultSet rs = stmt.executeQuery("SELECT LAST(FIRST_NAME) FROM VMS");
	        while (rs.next()) {
	        	message = "Read from DB: " + rs.getTimestamp("tick");
	        }
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
	public static int getNextVal(){
		Connection connection;
		int result = 0;
		try {
			connection = Main.getConnection();
			Statement stmt = connection.createStatement();
//	        stmt.executeUpdate("SELECT count(*) FROM EMPLOYEES;");
	        ResultSet rs = stmt.executeQuery("SELECT count(LAST_INSERT_ID()) FROM VMS;");
	        while (rs.next()) {
                result = rs.getInt(1) + 1;
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
