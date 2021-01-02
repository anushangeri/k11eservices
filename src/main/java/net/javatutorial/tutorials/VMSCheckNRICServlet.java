package net.javatutorial.tutorials;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
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
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormatter;

import com.google.api.client.auth.oauth2.Credential;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;

import net.javatutorial.DAO.EmployeesManagerDAO;
import net.javatutorial.DAO.EmployeesTblDAO;

import java.util.Calendar;
import java.util.Locale;
import static java.util.Calendar.*;
import java.util.Date;

/**
 * Servlet implementation class TodHodSearchServlet
 */
public class VMSCheckNRICServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ArrayList<String> responseObj = new ArrayList<String>();
		RequestDispatcher rd = null;
		
		String idNo = request.getParameter("idNo").trim();
		try {
			//make idNo uppercase
        	if(idNo != null && !idNo.isEmpty() ){
        		idNo = idNo.toUpperCase();
        	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		boolean loginsuccessful = false;
		
		if(!StringUtils.isEmpty(idNo)) {
			if(idNo.toUpperCase().equals("K11ADMIN")) {
				loginsuccessful = true;
				session.setAttribute("usertype", "K11ADMIN");
			}
			else{
				loginsuccessful = true;
				session.setAttribute("usertype", idNo);
			}
		}
		
		if(loginsuccessful) {
			responseObj.add("Login successful.");
			request.setAttribute("responseObj", responseObj);
			// Redirect to view visitor servlet to query all the visitors again.
			response.sendRedirect("/vms");
		}
		else{
			responseObj.add("NRIC/FIN is invalid. Please try again: " + idNo);
			request.setAttribute("responseObj", responseObj);
			rd = request.getRequestDispatcher("vmsCheckNRIC.jsp");
		}
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

