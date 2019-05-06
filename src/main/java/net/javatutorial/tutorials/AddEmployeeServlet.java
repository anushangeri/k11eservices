package net.javatutorial.tutorials;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javatutorial.DAO.EmployeesManagerDAO;
import net.javatutorial.DAO.EmployeesTblDAO;

/**
 * Servlet implementation class AddEmployeeServlet
 */
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat formatter1=new SimpleDateFormat("MM/DD/YYYY");  
		
		EmployeesManagerDAO empManagerDAO = new EmployeesManagerDAO();
		
		int nextVal = empManagerDAO.getNextVal();
		
		String employeeId = "K11_" + nextVal;
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String gender = request.getParameter("gender");
		String maritalStatus = request.getParameter("maritalStatus");
		try {
			Date dob = (Date) formatter1.parse(request.getParameter("dob"));
			//age
			LocalDate localDob = LocalDate.parse(request.getParameter("dob"));
			LocalDate curDate = LocalDate.now();
			int age = Period.between(localDob, curDate).getYears();
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
		
		String emergencyName = request.getParameter("emergencyName");
		String emergencyRlp = request.getParameter("emergencyRlp");
		String emergencyNo = request.getParameter("emergencyNo");
		
		String email = request.getParameter("email");
		String allowLogin = request.getParameter("allowLogin");
		
		String employeeStatus = request.getParameter("employeeStatus");
		try {
			Date joiningDt = (Date) formatter1.parse(request.getParameter("joiningDt"));
			Date probDtFrm = (Date) formatter1.parse(request.getParameter("probDtFrm"));
			Date probDtTo = (Date) formatter1.parse(request.getParameter("probDtTo"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String supervisor = request.getParameter("supervisor");
		String highestQual = request.getParameter("highestQual");
		
		String password = "password";
		
		String created_by = "Shangeri";
		String last_modified_by = "Shangeri";
		
		Date created_dt = (Date) Calendar.getInstance().getTime();
		Date last_modified_dt = (Date) Calendar.getInstance().getTime();
		
		String responseObj = "Successful";
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
