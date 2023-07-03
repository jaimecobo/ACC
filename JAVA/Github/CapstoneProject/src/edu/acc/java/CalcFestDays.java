package edu.acc.java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalcFestDays {
	
	String[] festDates = {"12-24-2017", "12-25-2017", "12-31-2017", "01-1-2018","01-15-2018","02-8-2018", "02-19-2018", "03-4-2018", "03-9-2018", "03-10-2018", "03-11-2018", };
	
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