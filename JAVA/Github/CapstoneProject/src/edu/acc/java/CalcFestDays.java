package edu.acc.java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalcFestDays {
	
	String[] festDates = {"12-24-2017", "12-25-2017", "12-31-2017", "01-1-2018","01-15-2018","02-8-2018", "02-19-2018", "03-4-2018", "03-9-2018", "03-10-2018", "03-11-2018", 
			"03-12-2018", "03-13-2018", "03-14-2018", "03-15-2018", "03-16-2018", "03-17-2018", "03-18-2018", "04-8-2018", "04-28-2018", "05-18-2018", "06-7-2018", "06-8-2018", 
			"06-9-2018", "06-10-2018", "06-23-2018", "07-4-2018", "08-18-2018", "09-3-2018", "09-29-2018", "10-5-2018", "10-6-2018", "10-7-2018", "10-12-2018", "10-13-2018", 
			"10-14-2018", "10-25-2018", "10-26-2018", "10-27-2018", "10-28-2018", "10-29-2018","10-30-2018", "10-31-2018", "11-1-2018", "11-12-2018",	"11-22-2018" };
	
	public int calcDays(Date entry_Date, Date departureDate) {
		
		int festDaysCount = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/d/yyyy");	
		List<Date> dates = new ArrayList<Date>();
		
		long interval = 24 * 60 * 60 * 1000; 							// 1 day in milliseconds
		long curTime = entry_Date.getTime();
		long endTime = departureDate.getTime(); 						
		

		while (curTime <= endTime) {
		    dates.add(new Date(curTime));
		    curTime += interval;
			
		}
		
		for(int i=0; i<dates.size(); i++){
		    Date lDate = (Date)dates.get(i);
		    String ds = formatter.format(lDate);    			//ds is one of the dates in between entry_Date and departureDate
		    
		    for(int j=0; j < festDates.length; j++){
                
                //check if string array contains the string
                if(festDates[j].equals(ds)){
                	festDaysCount++;
					
                }
				
		    }
			
		}
		
		return festDaysCount;
		
	}
	
}