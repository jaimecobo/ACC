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
		
		return festDaysCount;
		
	}
	
}