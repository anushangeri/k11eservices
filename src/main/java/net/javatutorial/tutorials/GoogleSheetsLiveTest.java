package net.javatutorial.tutorials;

import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesResponse;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.CopyPasteRequest;
import com.google.api.services.sheets.v4.model.ExtendedValue;
import com.google.api.services.sheets.v4.model.GridRange;
import com.google.api.services.sheets.v4.model.RepeatCellRequest;
import com.google.api.services.sheets.v4.model.Request;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.UpdateSpreadsheetPropertiesRequest;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;


public class GoogleSheetsLiveTest {

    private static Sheets sheetsService;

    // this id can be replaced with your spreadsheet id
    // otherwise be advised that multiple people may run this test and update the public spreadsheet
    private static final String SPREADSHEET_ID = "1VBrjNMEJTVQkcccyOEiit5pAfvbnGmQ6WjgMcnCxR-I";
   
    public static void setup() throws GeneralSecurityException, IOException {
    	System.out.println("sheetsService in here");
        sheetsService = SheetsServiceUtil.getSheetsService();
    }

    
    public void whenWriteSheet_thenReadSheetOk() throws IOException, ServiceException {
    	

    	System.out.println("came in here");
    	List<String> ranges = Arrays.asList("A1","E4");
    	System.out.println("ranges in here");
    	try {
			setup();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	BatchGetValuesResponse readResult = sheetsService.spreadsheets().values()
    	  .batchGet(SPREADSHEET_ID)
    	  .setRanges(ranges)
    	  .execute();
    	
    	ValueRange januaryTotal = readResult.getValueRanges().get(0);
    	System.out.println(januaryTotal.getValues().get(0).get(0));
//    	
//    	
//    	ValueRange body = new ValueRange().
//    			setValues(
//    				    Arrays.asList(
//    				      Arrays.asList("Row 1 Cell 1", "Row 1 Cell 2", "Row 1 Cell 3"),
//    				      Arrays.asList("Row 2 Cell 1", "Row 2 Cell 2", "Row 2 Cell 3")));
//        UpdateValuesResponse result = sheetsService.spreadsheets().values().update(SPREADSHEET_ID, "A1", body).setValueInputOption("RAW").execute();
//
//        // [END sheets_update_values]
//        
//    	ValueRange response = sheetsService.spreadsheets().values()
//                .get(SPREADSHEET_ID, "Form Responses 1!A2:E")
//                .execute();
//        List<List<Object>> values = response.getValues();
//            for (List row : values) {
//                // Print columns A and E, which correspond to indices 0 and 4.
//                System.out.printf("%s, %s\n", row.get(0), row.get(4));
//            }
    	String content ="just now";
        List<Object> data1 = new ArrayList<Object>();
        data1.add (content);
        System.out.println("data1" + data1.toString());
        List<List<Object>> data = new ArrayList<List<Object>>();
        data.add (data1);
        ValueRange valueRange=new ValueRange();
        valueRange.setValues(data);
        System.out.println("valueRange" + valueRange.toString());
        AppendValuesResponse result = sheetsService.spreadsheets().values().
        		append(SPREADSHEET_ID, "A1", valueRange)
                .setValueInputOption("RAW")
                .execute();
        System.out.println("%d cells appended." + result.getUpdates().getUpdatedCells());
//       
    }

  
    
}