package main.java.com.rader.national_park.models;

import java.util.List;

public class UserModel {
	
	private int id;
	private String username;
	private String password;
	private List<ReservationModel> reservations;

	
	public UserModel() {
		this.id = -1;
	}
	
	public UserModel(String username, String password) {
		this.id = -1;
		this.username = username;
		this.password = password;
	}
	
	public UserModel(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public List<ReservationModel> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationModel> reservations) {
		this.reservations = reservations;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	
	public boolean isLoggedIn() {
		return (id > -1);
	}
}
