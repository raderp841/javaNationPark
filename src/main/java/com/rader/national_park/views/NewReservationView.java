package main.java.com.rader.national_park.views;

import main.java.com.rader.national_park.models.ReservationModel;
import main.java.com.rader.national_park.utils.ConsoleUtils;
import main.java.com.rader.national_park.utils.DateUtils;

public class NewReservationView {

	public ReservationModel run(int siteNumber) {
		ReservationModel reservation = new ReservationModel();
		boolean isValidDate = false;
		while(!isValidDate) {
			ConsoleUtils.println("Reservation Selector");
			ConsoleUtils.println("");
			ConsoleUtils.println("When would you like to arrive at site number " + siteNumber + "? (mm/dd/yyyy)");
			String startDateString = ConsoleUtils.readln();
			ConsoleUtils.println("When would you like to depart site number " + siteNumber + "? (mm/dd/yyyy)");
			String endDateString = ConsoleUtils.readln();
			
			if(DateUtils.isDateFormat(startDateString) && DateUtils.isDateFormat(endDateString)) {
				reservation.setStartDate(DateUtils.stringToDate(startDateString));
				reservation.setEndDate(DateUtils.stringToDate(endDateString));
				isValidDate = true;
				ConsoleUtils.clearScreen();
			}else {
				ConsoleUtils.clearScreen();
				ConsoleUtils.println("Invalid date input. please use 'mm/dd/yyyy' ");
			}
		}
		return reservation;
	}
}
