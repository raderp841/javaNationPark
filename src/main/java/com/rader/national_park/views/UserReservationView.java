package main.java.com.rader.national_park.views;

import java.util.Map;
import java.util.Map.Entry;

import main.java.com.rader.national_park.models.ReservationModel;
import main.java.com.rader.national_park.utils.ConsoleUtils;
import main.java.com.rader.national_park.utils.DateUtils;
import main.java.com.rader.national_park.utils.NumberUtils;

public class UserReservationView{

	public void run(Map<ReservationModel, String> parksAndRes) {
		double totalDue = 0.0d;
		for(Entry<ReservationModel, String> kvp : parksAndRes.entrySet()) {
			String parkName = kvp.getValue();
			ReservationModel reservation = kvp.getKey();
			int nightsStayed = DateUtils.getDaysBetweenDatesInclusive(reservation.getStartDate(), reservation.getEndDate());
			ConsoleUtils.println("-----------------------");
			ConsoleUtils.println("Order Number   : " + reservation.getId());
			ConsoleUtils.println("Park Name      : " + parkName);
			ConsoleUtils.println("Site Number    : " + reservation.getSiteId());
			ConsoleUtils.println("Arrival Date   : " + reservation.getStartDate());
			ConsoleUtils.println("Departure Date : " + reservation.getEndDate());
			ConsoleUtils.println("Nights Stayed  : " + nightsStayed);
			ConsoleUtils.println("Amount Due     : " + NumberUtils.doubleToMoney(reservation.getAmountDue()));
			ConsoleUtils.println("-----------------------");
			
			totalDue += reservation.getAmountDue();
		}
		ConsoleUtils.println("Total Due    : " + NumberUtils.doubleToMoney(totalDue));
		ConsoleUtils.readln();
		ConsoleUtils.clearScreen();
	}
}