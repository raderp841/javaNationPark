package main.java.com.rader.national_park.views;

import java.util.ArrayList;
import java.util.List;

import main.java.com.rader.national_park.models.UserModel;
import main.java.com.rader.national_park.utils.ConsoleUtils;
import main.java.com.rader.national_park.utils.NumberUtils;

public class MenuView {

	public String run(UserModel user) {
		boolean selectedValidOption = false;
		String selectedMenuName = "";
		List<String> menuItems =  getMenuItems(user.isLoggedIn());
		
		while(!selectedValidOption) {
			ConsoleUtils.blankPrintlns(2);
			ConsoleUtils.println("Please choose a following option:");
			for(int i = 0; i < menuItems.size(); i++) {
				ConsoleUtils.println("[ " + i + " ] " + menuItems.get(i));
			}
			
			String userSelectionString = ConsoleUtils.readln();
			int userSelectionInt = NumberUtils.tryParseInt(userSelectionString, -1);
			ConsoleUtils.clearScreen();
			if(userSelectionInt < 0 || userSelectionInt >= menuItems.size()) {
				ConsoleUtils.println("Please choose a vaild option");
			}else {
				selectedMenuName = menuItems.get(userSelectionInt);
				selectedValidOption = true;
			}
		}
		return selectedMenuName;
				
	}
	
	public List<String> getMenuItems(boolean isLoggedIn){
		List<String> menuItems = new ArrayList<String>();
		if(isLoggedIn) {
			menuItems.add("View Parks");
			menuItems.add("See My Reservations");
			menuItems.add("Logout");
			menuItems.add("Exit");
		}else {
			menuItems.add("Login");
			menuItems.add("Register");
			menuItems.add("Exit");
		}		
		return menuItems;
	}
}
