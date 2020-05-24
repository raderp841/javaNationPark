package main.java.com.rader.national_park.models;

import java.util.List;

public class SiteModel {
	private int id;
	private int parkId;
	private int siteNumber;
	private double pricePerNight;
	private boolean isUtils;
	private List<ReservationModel> reservations;
	
	public SiteModel() {
		this.parkId = -1;
	}
	
	public SiteModel(int id, int parkId, int siteNumber, double pricePerNight, boolean isUtils) {
		this.id = id;
		this.parkId = parkId;
		this.siteNumber = siteNumber;
		this.pricePerNight = pricePerNight;
		this.isUtils = isUtils;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParkId() {
		return parkId;
	}

	public void setParkId(int parkId) {
		this.parkId = parkId;
	}

	public int getSiteNumber() {
		return siteNumber;
	}

	public void setSiteNumber(int siteNumber) {
		this.siteNumber = siteNumber;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public boolean isUtils() {
		return isUtils;
	}

	public void setUtils(boolean isUtils) {
		this.isUtils = isUtils;
	}

	public List<ReservationModel> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationModel> reservations) {
		this.reservations = reservations;
	}
	
	
}
