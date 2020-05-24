package main.java.com.rader.national_park.views;

import main.java.com.rader.national_park.models.UserModel;
import main.java.com.rader.national_park.utils.ConsoleUtils;

public class RegisterView {
	
	public UserModel run() {
		boolean passesMatch = false;
		String username = "";
		String password = "";
		while(!passesMatch) {
			ConsoleUtils.println("Please choose a username:");
			username = ConsoleUtils.readln();
			ConsoleUtils.println("Please enter a password:");
			password = ConsoleUtils.readln();
			ConsoleUtils.println("Please retype your password:");
			String passwordCheck = ConsoleUtils.readln();
			
			if(password.equals(passwordCheck) && !username.isEmpty() && !password.isEmpty()) {
				passesMatch = true;
			}else {
				ConsoleUtils.clearScreen();
				ConsoleUtils.println("Passes do not match");
			}
		}
		return new UserModel(username, password);
	}
}
