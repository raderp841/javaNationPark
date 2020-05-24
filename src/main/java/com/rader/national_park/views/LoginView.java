package main.java.com.rader.national_park.views;

import main.java.com.rader.national_park.models.UserModel;
import main.java.com.rader.national_park.utils.ConsoleUtils;

public class LoginView {

	public UserModel run() {
		ConsoleUtils.println("Please enter your username:");
		String username = ConsoleUtils.readln();
		ConsoleUtils.println("Please enter your password:");
		String password = ConsoleUtils.readln();
		
		return new UserModel(username, password);
	}
}
