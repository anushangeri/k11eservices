package net.javatutorial.tutorials;

import java.io.IOException;
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

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormatter;

import com.google.api.services.sheets.v4.Sheets;
import com.google.gdata.client.spreadsheet.SpreadsheetService;

import net.javatutorial.DAO.EmployeesManagerDAO;
import net.javatutorial.DAO.EmployeesTblDAO;

import java.util.Calendar;
import java.util.Locale;
import static java.util.Calendar.*;
import java.util.Date;

/**
 * Servlet implementation class TodHodSearchServlet
 */
public class TodHodAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;
	private static final String APPLICATION_NAME = "Google Sheets Example";
	private static Sheets sheetsService;
    private static String SPREADSHEET_ID = "1pKtYG7K4Tx3pq0rIs7j--LFT1__yaAPYujqhgs87zrw";
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String site = request.getParameter("site");
		String idNo = request.getParameter("idNo");
		String smth = request.getParameter("smth");
		
//		to make all UPPERCASE for comparing later
		if(!StringUtils.isEmpty(idNo)){
			idNo = idNo.trim();
			if(!StringUtils.isEmpty(idNo)){
				idNo = idNo.toUpperCase();
			}
		}
		SpreadsheetService service = new SpreadsheetService("Form Responses 1");
		 try {
		        String id = "1pKtYG7K4Tx3pq0rIs7j--LFT1__yaAPYujqhgs87zrw";
		        GoogleSheetsLiveTest test = new GoogleSheetsLiveTest();
		        test.whenWriteSheet_thenReadSheetOk();
		           
		    } catch (Exception e) {
		        // handle exception
		    }
//		ArrayList<String> responseObj = new ArrayList<String>();
//		responseObj.add(site);
//		responseObj.add(idNo);
//		responseObj.add(smth);
//		request.setAttribute("responseObj", responseObj);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("todhodattendance.jsp");
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
