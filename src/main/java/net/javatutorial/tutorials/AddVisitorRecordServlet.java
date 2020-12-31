package net.javatutorial.tutorials;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.joda.time.format.DateTimeFormatter;

import net.javatutorial.DAO.EmployeesManagerDAO;
import net.javatutorial.DAO.EmployeesTblDAO;
import net.javatutorial.DAO.VMSManagerDAO;
import net.javatutorial.entity.Visitor;

import java.util.Calendar;
import java.util.Locale;
import static java.util.Calendar.*;
import java.util.Date;

/**
 * Servlet implementation class AddEmployeeServlet
 */
public class AddVisitorRecordServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nextVal = VMSManagerDAO.getNextVal();
		
		String vmsId = "" + nextVal;
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String idNo = request.getParameter("idNo");
		String mobileNo = request.getParameter("mobileNo");
		String vehicleNo = request.getParameter("vehicleNo");
		String hostName = request.getParameter("hostName");
		String hostNo = request.getParameter("hostNo");
		String visitorCardId = request.getParameter("visitorCardId");
		String timeIn = request.getParameter("timeInDt");
		// make sure the seconds are set before parsing because Chrome won't send the seconds part
		// https://stackoverflow.com/questions/27827614/conversion-from-datetime-local-to-java-sql-timestamp
		if (StringUtils.countMatches(timeIn, ":") == 1) {
			timeIn += ":00";
		}
		Timestamp timeInDt = Timestamp.valueOf(timeIn.replace("T"," "));
		Visitor v = new Visitor( vmsId,  firstName,  lastName,  idNo,  mobileNo,  vehicleNo,
			 hostName,  hostNo,  visitorCardId,  timeInDt);
		
		String message = VMSManagerDAO.addVisitor(v);
		
		ArrayList<String> responseObj = new ArrayList<String>();
		responseObj.add(message + " " + firstName);
		request.setAttribute("responseObj", responseObj);
        RequestDispatcher rd = request.getRequestDispatcher("/vms");
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
