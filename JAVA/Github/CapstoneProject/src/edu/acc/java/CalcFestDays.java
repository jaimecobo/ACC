package edu.acc.java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalcFestDays {
	
	public int calcDays(Date entry_Date, Date departureDate) {
		
		int festDaysCount = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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
		    
		    for(int j=0; j < festDates.length; j){
                
		    }
			
		}
		
		return festDaysCount;
		
	}
	
}