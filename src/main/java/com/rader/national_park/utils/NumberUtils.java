package main.java.com.rader.national_park.utils;

public class NumberUtils {

	public static int tryParseInt(String input, int defaultOutput) {
		try {
			return Integer.parseInt(input);
		}catch(Exception e) {
			return defaultOutput;
		}
	}
	
	public static String doubleToMoney(double amount) {
		String amountString = String.valueOf(amount);
		String outputString = "$";
		String [] arr = amountString.split("\\.");
		if(arr.length == 1) {
			outputString += arr[0];
			outputString += ".00";
		}else if(arr.length == 2) {
			outputString += arr[0];
			outputString += ".";
			
			if(arr[1].length() == 1) {
				outputString += arr[1];
				outputString += "0";
			}else if(arr[1].length() > 2) {
				outputString += arr[1].subSequence(0, 2);
			}else {
				outputString += arr[1];
			}
		}
		return outputString;
	}
}
