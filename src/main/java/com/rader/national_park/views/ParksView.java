package main.java.com.rader.national_park.views;

import java.util.List;

import main.java.com.rader.national_park.models.ParkModel;
import main.java.com.rader.national_park.utils.ConsoleUtils;
import main.java.com.rader.national_park.utils.NumberUtils;

public class ParksView {

	public ParkModel run(List<ParkModel> parks) {		
		boolean parkSelected = false;
		
		while(!parkSelected) {
			ConsoleUtils.println("Please choose a park to view its sites:");
			ConsoleUtils.blankPrintlns();
			for(int i = 0; i < parks.size(); i++) {
				ParkModel park = parks.get(i);
				ConsoleUtils.println("[ " + i + " ] " + park.getName() + ", " + park.getLocation());
			}
			int parkChoice = NumberUtils.tryParseInt(ConsoleUtils.readln(), -1);
			if(parkChoice > -1 && parkChoice < parks.size()) {
				parkSelected = true;
				return parks.get(parkChoice);
			}else {
				ConsoleUtils.println("Invalid option. Please choose a number between 0 and " + (parks.size() - 1));
				boolean retrySelected = false;
				while(!retrySelected) {
					ConsoleUtils.println("Would you like to try again? (y/n)");
					String retryInput = ConsoleUtils.readln();
					if(retryInput.equalsIgnoreCase("y")) {
						retrySelected = true;
					}else if(retryInput.equalsIgnoreCase("n")) {
						retrySelected = true;
						parkSelected = true;
					}else {
						ConsoleUtils.println("Invalid input. Please enter 'y' or 'n'");
					}
				}
				ConsoleUtils.clearScreen();
			}
		}
		return null;
	}
}
