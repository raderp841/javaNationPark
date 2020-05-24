package main.java.com.rader.national_park.models;

import java.time.LocalDate;

import main.java.com.rader.national_park.utils.DateUtils;

public class ReservationModel {
	private int id;
	private int userId;
	private int siteId;
	private int parkId;
	private LocalDate startDate;
	private LocalDate endDate;
	private double amountDue;
	
	public ReservationModel() {
		this.id = -1;
	}
	
	public ReservationModel(int siteId, int parkId, LocalDate startDate, LocalDate endDate) {
		this.id = -1;
		this.siteId = siteId;
		this.parkId = parkId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public ReservationModel(int id, int userId, int siteId, int parkId, LocalDate startDate, LocalDate endDate, double amountDue) {
		this.id = id;
		this.userId = userId;
		this.siteId = siteId;
		this.parkId = parkId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amountDue = amountDue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getParkId() {
		return parkId;
	}

	public void setParkId(int parkId) {
		this.parkId = parkId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	@Override
	public String toString() {
		return "ReservationModel [id=" + id + ", userId=" + userId + ", siteId=" + siteId + ", parkId=" + parkId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", amountDue=" + amountDue + "]";
	}
	
	public void calculateAmountDue(double pricePerNight) {
		
		this.amountDue = pricePerNight * DateUtils.getDaysBetweenDatesInclusive(startDate, endDate);
	}
}
