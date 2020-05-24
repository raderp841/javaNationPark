package main.java.com.rader.national_park.dals;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.com.rader.national_park.models.ReservationModel;

public class ReservationsDAL extends DAL {
	
	public List<ReservationModel> getReservationsForSite(int siteId){
		
		List<ReservationModel> reservations = new ArrayList<ReservationModel>();
		
		try(Connection conn = getConnection();
				Statement statement = conn.createStatement();){
				ResultSet result = statement.executeQuery("SELECT * FROM reservation WHERE siteId =" + siteId);
				
				while(result.next()) {
					int id = result.getInt("id");
					int userId = result.getInt("userId");
					int parkId = result.getInt("parkId");
					LocalDate startDate = result.getDate("startDate").toLocalDate();
					LocalDate endDate = result.getDate("endDate").toLocalDate();
					double amountDue = result.getDouble("amountDue");
					
					reservations.add(new ReservationModel(id, userId, siteId, parkId, startDate, endDate, amountDue));
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}
	
	public List<ReservationModel> getReservationsForUser(int userId){
		List<ReservationModel> reservations = new ArrayList<ReservationModel>();
		
		try(Connection conn = getConnection();
				Statement statement = conn.createStatement();){
			
			ResultSet result = statement.executeQuery("SELECT * FROM reservation WHERE userId =" + userId);
			
			while(result.next()) {
				int id = result.getInt("id");
				int siteId = result.getInt("siteId");
				int parkId = result.getInt("parkId");
				LocalDate startDate = result.getDate("startDate").toLocalDate();
				LocalDate endDate = result.getDate("endDate").toLocalDate();
				double amountDue = result.getDouble("amountDue");
				
				reservations.add(new ReservationModel(id, userId, siteId, parkId, startDate, endDate, amountDue));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reservations;			
	}
	
	public boolean saveReservation(ReservationModel reservation) {
		boolean success = false;
		Date startDate = Date.valueOf(reservation.getStartDate());
		Date endDate = Date.valueOf(reservation.getEndDate());
		try(Connection conn = getConnection();
				Statement statement = conn.createStatement();){
				
			int rowsAffected = statement.executeUpdate("INSERT INTO reservation(userId, siteId, parkId, startDate, endDate, amountDue) VALUES(" + reservation.getUserId() + "," + reservation.getSiteId() + "," + reservation.getParkId() + ", '" + startDate + "', '" + endDate + "'," + reservation.getAmountDue() + ")");
			success = (rowsAffected > 0);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
}
