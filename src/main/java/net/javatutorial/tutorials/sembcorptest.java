package net.javatutorial.tutorials;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.javatutorial.tutorials.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Data;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesResponse;
import com.google.api.services.sheets.v4.model.CopyPasteRequest;
import com.google.api.services.sheets.v4.model.GridRange;
import com.google.api.services.sheets.v4.model.Request;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.UpdateSpreadsheetPropertiesRequest;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
/**
 * Servlet implementation class TodHodSearchServlet
 */
public class sembcorptest extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;
	private static final String APPLICATION_NAME = "Google Sheets Example";
	private static Sheets sheetsService;
    private static String SPREADSHEET_ID = "1VBrjNMEJTVQkcccyOEiit5pAfvbnGmQ6WjgMcnCxR-I";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SpreadsheetService service = new SpreadsheetService("Form Responses 1");
		 try {
		        String id = "1VBrjNMEJTVQkcccyOEiit5pAfvbnGmQ6WjgMcnCxR-I";
		        GoogleSheetsLiveTest test = new GoogleSheetsLiveTest();
		        test.whenWriteSheet_thenReadSheetOk();
		           
		    } catch (Exception e) {
		        // handle exception
		    }
//		String sheetUrl
//        = "https://spreadsheets.google.com/feeds/list/1VBrjNMEJTVQkcccyOEiit5pAfvbnGmQ6WjgMcnCxR-I/1/public/values";
//
//		// Use this String as url
//		URL url = new URL(sheetUrl);
//		
//		// Get Feed of Spreadsheet url
//		try {
//			ListFeed lf = service.getFeed(url, ListFeed.class);
//			ListEntry row = lf.getEntries().get(0);
//
//			CellEntry cellEntry = new CellEntry(5, 10, "Value");
//			sheetUrl.insert(lf, cellEntry);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			    
			    
		String site = request.getParameter("site");
		String idNo = request.getParameter("idNo");
		String smth = request.getParameter("smth");
//		String from = request.getParameter("from");
//		String to = request.getParameter("to");
		
		ArrayList<String> responseObj = new ArrayList<String>();
		responseObj.add(site);
		responseObj.add(idNo);
		responseObj.add(smth);
//		responseObj.add(to);
		request.setAttribute("responseObj", responseObj);
		
        
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
	 public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        Credential credential = GoogleAuthorizeUtil.authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential).setApplicationName(APPLICATION_NAME).build();
    }
	 public static void setup() throws GeneralSecurityException, IOException {
        sheetsService = getSheetsService();
    }

}
