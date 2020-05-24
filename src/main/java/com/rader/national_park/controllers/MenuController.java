package main.java.com.rader.national_park.controllers;

import main.java.com.rader.national_park.models.UserModel;
import main.java.com.rader.national_park.utils.ConsoleUtils;
import main.java.com.rader.national_park.views.MenuView;

public class MenuController {
	boolean initialStart = true;
	UserModel user = new UserModel();
	boolean isExit = false;
	
	public void start() {
		while(!isExit) {
			if(initialStart) {
				ConsoleUtils.println("Welcome to the National Park Reservation Maker");
				initialStart = false;
			}
			String  menuChoice = new MenuView().run(user);
			
			switch(menuChoice) {
			case "Login":
				redirectToLogin();
				break;
			case "Register":
				redirectToRegister();
				break;
			case "Logout":
				logout();
				break;
			case "Exit":
				isExit = true;
				break;
			case "View Parks":
				redirectToParks(user.getId());
				break;
			case "See My Reservations":
				redirectToReservations(user);
				break;
			default:
				break;
			}
		}
	}
	
	private void redirectToLogin() {
		new UsersController().loginAction(user);
	}
	
	private void redirectToRegister() {
		new UsersController().registerAction(user);
	}
	
	private void logout() {
		user = new UserModel();
	}
	
	private void redirectToParks(int userId) {
		new ParksController().veiwParksAction(userId);
	}
	
	private void redirectToReservations(UserModel user) {
		new ReservationsController().viewReservationsAction(user);
	}
}
