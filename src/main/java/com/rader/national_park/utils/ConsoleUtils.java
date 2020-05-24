package main.java.com.rader.national_park.utils;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUtils {
	
	public static void blankPrintlns(int numberOfLines) {
		while(numberOfLines > 0) {
			System.out.println();
			numberOfLines--;
		}
	}
	
	public static void blankPrintlns() {
		System.out.println();
	}

	public static void println(String input) {
		System.out.println(input);
	}
	
	public static void println(Double input) {
		System.out.println(input);
	}
	
	public static void println(Integer input) {
		System.out.println(input);
	}
	
	public static void println(Boolean input) {
		System.out.println(input);
	}
	
	public static void println(LocalDate input) {
		System.out.println(input);
	}
	
	public static String readln() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public static void clearScreen()
	{
	    blankPrintlns(50);
	} 
}
