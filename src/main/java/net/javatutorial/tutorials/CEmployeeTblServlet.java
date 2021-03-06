package net.javatutorial.tutorials;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javatutorial.DAO.*;
import net.javatutorial.entity.Employee;

/**
 * Servlet implementation class ManageTblServlet
 * To create table Employees
 */
public class CEmployeeTblServlet extends HttpServlet {
	
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String responseObj = EmployeesTblDAO.createEmpTbl();
		
		//creating an admin account
		//standard password, allow officer to update later
		String password = "P@ssw0rd";
		
		//hashing the password
		String salt = PasswordUtils.generateSalt(512).get();
		String hashedPassword = PasswordUtils.hashPassword(password, salt).get();
		
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Singapore")) ;
		Timestamp timestamp = Timestamp.valueOf(zdt.toLocalDateTime());
		
		Employee admin = new Employee("K11_1", "K11ADMIN", "K11ADMIN", null, null, timestamp,
				null, null, null, null, "S1234567D", null,
				null, null, null, null, null, null,
				null, null, timestamp, timestamp, timestamp,
				 hashedPassword, salt, timestamp, timestamp);
		
		responseObj = EmployeesManagerDAO.addEmployee(admin);
		
		request.setAttribute("responseObj", responseObj);
        RequestDispatcher rd = request.getRequestDispatcher("managedatabase.jsp");
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
