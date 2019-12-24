package net.javatutorial.tutorials;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormatter;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;


import java.util.Calendar;
import java.util.Locale;
import static java.util.Calendar.*;
import java.util.Date;

/**
 * Servlet implementation class TodHodSearchServlet
 */
public class RoasterGenerationServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String site = request.getParameter("site");
//		String idNo = request.getParameter("idNo");
//		String shift = request.getParameter("shift");
//		String from = request.getParameter("from");
//		String to = request.getParameter("to");
		
		SpreadsheetService service = new SpreadsheetService("test roaster generation");
		Set<String> pastRoasterHeader = null;
		Set<String> leaveProjHeader = null;
		Map<String, ArrayList<String>>  responseObj = new HashMap<String, ArrayList<String>>();
		ArrayList<String> sites = new ArrayList<String>();
		Map<String, Integer> unSortedSoSiteDay = new HashMap<String, Integer>();
		Map<String, ArrayList<String>> sortSoSiteDay = new HashMap<String, ArrayList<String>>();
		Map<String, ArrayList<String>> soLeave = new HashMap<String, ArrayList<String>>();
		Map<String, ArrayList<String>> roasterDay = new HashMap<String, ArrayList<String>>();
		
		//get number of days of current Month
		Calendar c = Calendar.getInstance();
		int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		try {
			//FOR THE SHEET 1: PAST ROASTER
            String sheetUrl
                    = "https://spreadsheets.google.com/feeds/list/1tWf8GXe22zZpWg8_s1yxR43VsnYWQnhcc85Pd2kaX_M/1/public/values";

            // Use this String as url
            URL url = new URL(sheetUrl);

            //Get Feed of Spreadsheet url
            ListFeed lf = service.getFeed(url, ListFeed.class);
           
            //FOR THE SHEET 2: LEAVE PROJECTION
            String sheetUrl2
                    = "https://spreadsheets.google.com/feeds/list/1tWf8GXe22zZpWg8_s1yxR43VsnYWQnhcc85Pd2kaX_M/2/public/values";

            // Use this String as url
            URL url2 = new URL(sheetUrl2);

            //Get Feed of Spreadsheet url
            ListFeed lf2 = service.getFeed(url2, ListFeed.class);
           
//            //Iterate over feed to get cell value
//            for (ListEntry le : lf.getEntries()) {
//                CustomElementCollection cec = le.getCustomElements();
//                System.out.println(cec.toString());
//                if (cec != null){
//                	responseObj = cec.getTags();
//                    //System.out.println("THE PROBLEM IS HERE: " + nricfin);
//                    //String dateofbirth = cec.getValue("dateofbirth");
//                    //System.out.println("THE PROBLEM IS HERE: " + dateofbirth);
//                    
//		
//                }
//            }
            //Step 1: get all the tags in Sheet 1 (the header)
            for (ListEntry le : lf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                if (cec != null){
                	pastRoasterHeader = cec.getTags();
                	break;
                }
            }
            //Step 2: get all the tags in Sheet 2 (the header) so you can get the name
            for (ListEntry le : lf2.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                if (cec != null){
                	leaveProjHeader = cec.getTags();
                	break;
                }
            }
            //Convert to List to make it easier
            List<String> leaveProjHeaderList = new ArrayList<String>(leaveProjHeader);
            List<String> pastRoasterHeaderList = new ArrayList<String>(pastRoasterHeader);
            //Step 3: get all sites
            for (ListEntry le : lf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                if (cec != null){
                	String site = cec.getValue(pastRoasterHeaderList.get(0));
                	if(site!= null && !site.isEmpty()) {
                		sites.add(site);
                	}
                }
            }
            
            //Step 4: Get the name of each SO from Sheet 2 index 2 (for Col C)
            //iterating each officer name in Sheet 2 colC
	        for (ListEntry eachR : lf2.getEntries()) {
	            CustomElementCollection allE = eachR.getCustomElements();
	            if (allE != null){
	            	//the SHORT NAME
	            	String officerName = allE.getValue(leaveProjHeaderList.get(2));
	            	if(officerName != null && !officerName.isEmpty()) {
		            	int countSite = 0;
		            	//Step 5: For each officer, find the top 3 sites in Sheet 1 for Day Shift
		            	//iterating each row is each site
		            	for (ListEntry le : lf.getEntries()) {
		            		int countSoSiteDay = 0;
		                    CustomElementCollection cec = le.getCustomElements();
		                    //COUNT DAY SHIFT
		                    if (cec != null){
		                    	//count for the all the day shift
		                    	int dayCol = 1;
		                    	//getting all the day column
		                    	while (dayCol < pastRoasterHeaderList.size()) {
		                    		String so = cec.getValue(pastRoasterHeaderList.get(dayCol));
			                    	if(!so.isEmpty()) {
			                    		if(so.equalsIgnoreCase(officerName)) {
			                    			countSoSiteDay++;
			                    		}
			                    	}
			                    	dayCol= dayCol+2;
		                    	}
		                    }
	                    	//after the entire row has been counted, put into Map
	                    	if(countSite < sites.size()) {
	                    		String eachSite = sites.get(countSite);
	                    		unSortedSoSiteDay.put(eachSite, countSoSiteDay);
	                    		countSite++;
	                    	}
		                }
		            	//find the top 3 site for the SO
		            	// Create a list from elements of HashMap 
		                List<Map.Entry<String, Integer> > list = 
		                       new LinkedList<Map.Entry<String, Integer> >(unSortedSoSiteDay.entrySet()); 
		          
		                // Sort the list 
		                Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
		                    public int compare(Map.Entry<String, Integer> o1,  
		                                       Map.Entry<String, Integer> o2) 
		                    { 
		                        return (o2.getValue()).compareTo(o1.getValue()); 
		                    } 
		                }); 
		                  
		                // put data from sorted list to hashmap  
		                HashMap<String, Integer> sortSitesDay = new LinkedHashMap<String, Integer>(); 
		                for (Map.Entry<String, Integer> aa : list) { 
		                	sortSitesDay.put(aa.getKey(), aa.getValue()); 
		                } 
		            	//get the top 3 sites for Day shift
		            	Set<String> sitesSet = sortSitesDay.keySet();
		            	List<String> sitesSetList = new ArrayList<String>(sitesSet);
		            	ArrayList<String> top3Site = new ArrayList<String>();
		            	for(int i = 0; i < sitesSetList.size(); i++ ) {
		            		if(i < 3) {
		            			top3Site.add(sitesSetList.get(i));
		            		}
		            	}
		            	sortSoSiteDay.put(officerName, top3Site);
		            	
		            	//Step 6: Read the same excel (Sheet 2) for each officer, get the leave dates
		            	//looping through the dates
		            	ArrayList<String> leaves = new ArrayList<String>();
		            	for(int i = 4; i < leaveProjHeaderList.size(); ++i) {
		            		//check each even column or odd column for "RD" or "AL"
		            		String eachCol = allE.getValue(leaveProjHeaderList.get(i));
		            		//String eachOddCol = allE.getValue(leaveProjHeaderList.get(i+1));
		            		//i = even number check for RD/AL
		            		if(eachCol.equals("RD") || eachCol.equals("AL") || eachCol.equals("UL") || eachCol.equals("OC")) {
		            			leaves.add("RD");
		            			leaves.add("RD");
		            		}
//		            		//if the even col doesnt have RD/AL check the odd col to make sure too
//		            		else if(eachOddCol.equals("RD") || eachOddCol.equals("AL")){
//		            			leaves.add("RD");
//		            			leaves.add("RD");
//		            		}
		            		else {
		            			leaves.add("1");
		            			leaves.add("1");
		            		}
//		            		++i;
		            	} //for(int i = 4; i < leaveProjHeaderList.size(); i++)
		            	//add officer name and leaves to hashmap for later
		            	soLeave.put(officerName, leaves);
	            	}
	            }
	        }//for (ListEntry eachR : lf2.getEntries()) //each officer
	        
	        //Step 7: Display all the day shift
	        //logic: for each site, find the officer with priority #1, if officer on leave, find the next one with priority #1, then #2, then #3. else leave empty.
	        //also check if officer working that day
	        ArrayList<String> eachSiteRoaster = new ArrayList<String>(monthMaxDays);
	        Iterator sortSoSiteDayIter = sortSoSiteDay.entrySet().iterator();
	        Iterator soLeaveIter = soLeave.entrySet().iterator();
	        boolean siteCompleted = false;
	        boolean moveToNextSO = false;
	        for(String eachSite: sites) {
	        	System.out.println("eachSite" + eachSite);
	        	int dayCol = 0;
	        	int top3 = 0;
	        	siteCompleted = false;
	        	moveToNextSO = false;
	        	while (!siteCompleted && top3 != 3) {
	        		System.out.println("siteCompleted" + siteCompleted);
	        		System.out.println("eachSiteRoaster.size(): " + eachSiteRoaster.size());
	        		while (sortSoSiteDayIter.hasNext()  && !siteCompleted) {
		 	            Map.Entry pairSoSite = (Map.Entry)sortSoSiteDayIter.next();
		 	            String eachSO = (String) pairSoSite.getKey();
		 	            ArrayList<String> top3Sites = (ArrayList<String>) pairSoSite.getValue();
		 	            System.out.println("eachSO" + eachSO);
		 	            String top3Site = top3Sites.get(top3);
		 	            if(eachSite.equals(top3Site)) {
		 	            	//found an SO with this site as top priority
		 	            	//loop throught the leaves
		 	            	while(soLeaveIter.hasNext() && !moveToNextSO && !siteCompleted) {
		 	            		Map.Entry pairSoLeave = (Map.Entry)sortSoSiteDayIter.next();
				 	            String eSO = (String) pairSoLeave.getKey();
				 	            ArrayList<String> leaves = (ArrayList<String>) pairSoLeave.getValue();
		 	            		if(eachSO.equals(eSO)) {
		 	            			System.out.println("dayCol" + dayCol);
		 	            			String eachDay = leaves.get(dayCol);
		 	            			System.out.println("eachDay" + eachDay);
		 	            			if(!eachDay.equals("RD")) {
		 	            				eachSiteRoaster.set(dayCol, eachSO);
		 	            				if(dayCol == monthMaxDays) {
		 	            					siteCompleted = true;
		 	            					roasterDay.put(eachSite, eachSiteRoaster);
		 	            				}
		 	            				dayCol = dayCol + 2;
		 	            				
		 	            				
		 	            			}
		 	            			else {
		 	            				moveToNextSO = true;
		 	            			}
		 	            		}
		 	            	}
		 	            }
		 	            
		 	        }
	        		top3++;
	        		System.out.println("top3: " + top3);
	        	}
	        }
	        System.out.println(roasterDay.toString());
	        
        }catch (Exception e) {
			e.printStackTrace();
		}
		responseObj = sortSoSiteDay;
//		ArrayList<String> responseObj = new ArrayList<String>();
//		responseObj.add(tags);
		request.setAttribute("responseObj", responseObj);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("roastergeneration.jsp");
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
