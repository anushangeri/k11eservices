package net.javatutorial.tutorials;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.util.ServiceException;

/**
 * Servlet implementation class TodHodSearchServlet
 */
public class sembcorptest extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SpreadsheetService service = new SpreadsheetService("Form Responses 1");
		String sheetUrl
        = "https://spreadsheets.google.com/feeds/list/1VBrjNMEJTVQkcccyOEiit5pAfvbnGmQ6WjgMcnCxR-I/1/public/values";

		// Use this String as url
		URL url = new URL(sheetUrl);
		
		// Get Feed of Spreadsheet url
		try {
			ListFeed lf = service.getFeed(url, ListFeed.class);
			ListEntry row = lf.getEntries().get(0);

	        // Update the row's data.
	        row.getCustomElements().setValueLocal("route", "Sarah");
	        row.getCustomElements().setValueLocal("day", "Hunt");
	        row.getCustomElements().setValueLocal("shuttle", "32");
	        row.getCustomElements().setValueLocal("category", "154");

	        // Save the row using the API.
	        row.update();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			    
			    
//		String site = request.getParameter("site");
//		String idNo = request.getParameter("idNo");
//		String shift = request.getParameter("shift");
//		String from = request.getParameter("from");
//		String to = request.getParameter("to");
//		
//		ArrayList<String> responseObj = new ArrayList<String>();
//		responseObj.add(site);
//		responseObj.add(idNo);
//		responseObj.add(from);
//		responseObj.add(to);
//		request.setAttribute("responseObj", responseObj);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("sembcorpms.jsp");
		
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
