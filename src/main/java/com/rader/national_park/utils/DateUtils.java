package main.java.com.rader.national_park.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class DateUtils {

	public static boolean isDateFormat(String date) {
		String [] stringDateParts = date.split("/");
		List<Integer> thirtyDayMonths = new ArrayList<Integer>();
		thirtyDayMonths.add(9);
		thirtyDayMonths.add(4);
		thirtyDayMonths.add(6);
		thirtyDayMonths.add(11);
		
		List<Integer> thirtyOneDayMonths = new ArrayList<Integer>();
		thirtyOneDayMonths.add(1);
		thirtyOneDayMonths.add(3);
		thirtyOneDayMonths.add(5);
		thirtyOneDayMonths.add(7);
		thirtyOneDayMonths.add(8);
		thirtyOneDayMonths.add(10);
		thirtyOneDayMonths.add(12);
		
		
		if(stringDateParts.length != 3) return false;
		
		int month = NumberUtils.tryParseInt(stringDateParts[0], -1);
		int day = NumberUtils.tryParseInt(stringDateParts[1], -1);
		int year = NumberUtils.tryParseInt(stringDateParts[2], -1);
		
		if(month == -1 || day == -1 || year == -1) return false;
		if(month > 12 || month < 1) return false;
		if(day < 1) return false;
		if(year < Year.now().getValue() || year > 2100) return false;
		if(thirtyDayMonths.contains(month) && day > 30) return false;
		if(thirtyOneDayMonths.contains(month) && day > 31) return false;
		if(month == 2 && day > 29) return false;
		if(month == 2 && year % 4 != 0 && day > 28) return false;
		
		return true;
	}
	
	public static LocalDate stringToDate(String date) {
		String [] stringDateParts = date.split("/");
		int month = Integer.parseInt(stringDateParts[0]);
		int day = Integer.parseInt(stringDateParts[1]);
		int year = Integer.parseInt(stringDateParts[2]);
		
		return LocalDate.of(year, month, day);
	}
	
	public static int getDaysBetweenDatesInclusive(LocalDate startDate, LocalDate endDate) {
		Period dateDiff = startDate.until(endDate);
		return dateDiff.getDays();
	}
}


