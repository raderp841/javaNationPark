package main.java.com.rader.national_park.controllers;

import main.java.com.rader.national_park.dals.UsersDAL;
import main.java.com.rader.national_park.models.UserModel;
import main.java.com.rader.national_park.utils.ConsoleUtils;
import main.java.com.rader.national_park.views.LoginView;
import main.java.com.rader.national_park.views.RegisterView;

public class UsersController {

	public void loginAction(UserModel user) {
		boolean tryLogin = true;
		while(tryLogin) {
			UserModel userForLogin = new LoginView().run();
			userForLogin = new UsersDAL().getUserByUsernamePassword(userForLogin.getUsername(), userForLogin.getPassword());
			if(userForLogin.isLoggedIn()) {
				user.setId(userForLogin.getId());
				user.setUsername(userForLogin.getUsername());
				tryLogin = false;
			}else {
				boolean answeredContinue = false;
				while(!answeredContinue) {
					ConsoleUtils.println("Something went wrong :(");
					ConsoleUtils.println("Would you like to try again?");
					String answer = ConsoleUtils.readln();
					if(answer.equalsIgnoreCase("n")) {
						ConsoleUtils.clearScreen();
						answeredContinue = true;
						tryLogin = false;
					}else if(answer.equalsIgnoreCase("y")) {
						ConsoleUtils.clearScreen();
						answeredContinue = true;
					}else {
						ConsoleUtils.clearScreen();
						ConsoleUtils.println("Please enter either 'y' or 'n'");
					}
				}
			}
		}
	}
	
	public void registerAction(UserModel user) {
		boolean tryRegister = true;
		
		while(tryRegister) {
			UserModel registerUser =  new RegisterView().run();
			if(new UsersDAL().saveUser(registerUser.getUsername(), registerUser.getPassword())) {
				tryRegister = false;
			}else {
				boolean answeredContinue = false;
				while(!answeredContinue) {
					ConsoleUtils.println("Something went wrong :(");
					ConsoleUtils.println("Would you like to try again?");
					String answer = ConsoleUtils.readln();
					if(answer.equalsIgnoreCase("n")) {
						ConsoleUtils.clearScreen();
						answeredContinue = true;
						tryRegister = false;
					}else if(answer.equalsIgnoreCase("y")) {
						ConsoleUtils.clearScreen();
						answeredContinue = true;
					}else {
						ConsoleUtils.clearScreen();
						ConsoleUtils.println("Please enter either 'y' or 'n'");
					}
				}
			}
		}
	}
}
