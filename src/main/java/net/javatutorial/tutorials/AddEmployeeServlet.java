package net.javatutorial.tutorials;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javatutorial.DAO.EmployeesManagerDAO;
import net.javatutorial.entity.Employee;

/**
 * Servlet implementation class AddEmployeeServlet
 */
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat formatter1 = new SimpleDateFormat("MM/DD/YYYY");  
		
		
		int nextVal = EmployeesManagerDAO.getNextVal();
		
		String employeeId = "K11_" + nextVal;
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String gender = request.getParameter("gender");
		String maritalStatus = request.getParameter("maritalStatus");
		
		int age = 0;
		Date dob = null;
		Date joiningDt = null;
		Date probDtFrm = null;
		Date probDtTo = null;
		
		Timestamp dobTs = null;
		Timestamp joiningTs = null;
		Timestamp probTsFrm = null;
		Timestamp probTsTo = null;
		
		try {
			Date curDt = new Date();
			Calendar currDtCal = Calendar.getInstance(Locale.US);
			currDtCal.setTime(curDt);
			
			dob = (Date) formatter1.parse(request.getParameter("dob"));
			dobTs = new Timestamp(dob.getTime());  
			
			Calendar dobcal = Calendar.getInstance(Locale.US);
			dobcal.setTime(dob);
			
			age = currDtCal.get(YEAR) - dobcal.get(YEAR);
		    if (dobcal.get(MONTH) > currDtCal.get(MONTH) || 
		        (dobcal.get(MONTH) == currDtCal.get(MONTH) && dobcal.get(DATE) > currDtCal.get(DATE))) {
		    	age--;
		    }
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String nationality = request.getParameter("nationality");
		String pob = request.getParameter("pob");
		String identification = request.getParameter("identification");
		String idType = request.getParameter("idType");
		String idNo = request.getParameter("idNo");
		String religion = request.getParameter("religion");
		String race = request.getParameter("race");
		
		String mobileNo = request.getParameter("mobileNo");
		String email = request.getParameter("email");
		
		String emergencyName = request.getParameter("emergencyName");
		String emergencyRlp = request.getParameter("emergencyRlp");
		String emergencyNo = request.getParameter("emergencyNo");
		
		String employeeStatus = request.getParameter("employeeStatus");
		String highestQual = request.getParameter("highestQual");

		
		try {
			joiningDt = (Date) formatter1.parse(request.getParameter("joiningDt"));
			joiningTs = new Timestamp(joiningDt.getTime());  
			
			probDtFrm = (Date) formatter1.parse(request.getParameter("probDtFrm"));
			probTsFrm = new Timestamp(probDtFrm.getTime());  
			
			probDtTo = (Date) formatter1.parse(request.getParameter("probDtTo"));
			probTsTo = new Timestamp(probDtTo.getTime());  
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//standard password, allow officer to update later
		String password = "P@ssw0rd";
		
		//hashing the password
		String salt = PasswordUtils.generateSalt(512).get();
		String hashedPassword = PasswordUtils.hashPassword(password, salt).get();
		
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Singapore")) ;
		Timestamp timestamp = Timestamp.valueOf(zdt.toLocalDateTime());
		
		Employee em = new Employee(employeeId, firstName, lastName, gender, maritalStatus, dobTs,
				 age, nationality, pob, identification, idType, idNo, religion,
				 race, mobileNo, email, emergencyName, emergencyRlp, emergencyNo,
				 employeeStatus, highestQual, joiningTs, probTsFrm, probTsTo,
				 hashedPassword, salt, timestamp, timestamp);
		
		String responseObj = EmployeesManagerDAO.addEmployee(em);
		request.setAttribute("responseObj", responseObj);
        RequestDispatcher rd = request.getRequestDispatcher("addEmp.jsp");
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
