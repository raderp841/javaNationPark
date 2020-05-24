package main.java.com.rader.national_park.views;

import main.java.com.rader.national_park.models.ParkModel;
import main.java.com.rader.national_park.models.SiteModel;
import main.java.com.rader.national_park.utils.ConsoleUtils;
import main.java.com.rader.national_park.utils.NumberUtils;

public class SitesView {

	public int run(ParkModel park) {
		boolean siteChosen = false;
		ConsoleUtils.clearScreen();
		while(!siteChosen) {
			ConsoleUtils.println(((park.getSites().size() > 1)? "Sites" : "Site" ) + " for " + park.getName());
			ConsoleUtils.blankPrintlns();
			ConsoleUtils.println("Please select a site to make a reservtion");
			ConsoleUtils.blankPrintlns();

			for(int i = 0; i < park.getSites().size(); i++) {
				SiteModel site = park.getSites().get(i);
				ConsoleUtils.println("[ " + i + " ] Site #: " + site.getSiteNumber() +  " | " + (site.isUtils() ? "Has Utilities        " : "Doesnt Have Utilities") + "  | " + "Nightly Price: " + NumberUtils.doubleToMoney(site.getPricePerNight()));
			}
			int selectedSite = NumberUtils.tryParseInt(ConsoleUtils.readln(), -1);
			if(selectedSite > -1 && selectedSite < park.getSites().size()) {
				return selectedSite;
			}else {
				boolean retryAnswered = false;
				while(!retryAnswered) {
					ConsoleUtils.println("Invalid input. Would you like to retry? (y/n)");
					String retryAnswer = ConsoleUtils.readln();
					if(retryAnswer.equalsIgnoreCase("y")) {
						retryAnswered = true;
						ConsoleUtils.clearScreen();
					}else if(retryAnswer.equalsIgnoreCase("n")) {
						retryAnswered = true;
						ConsoleUtils.clearScreen();
						return -1;
					}else {
						ConsoleUtils.clearScreen();
						ConsoleUtils.println("Ivalid input. Please type 'y' or 'n'");
					}
				}
			}
		}
		return -1;
	}
}
