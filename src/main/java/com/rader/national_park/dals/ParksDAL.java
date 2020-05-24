package main.java.com.rader.national_park.dals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.com.rader.national_park.models.ParkModel;
import main.java.com.rader.national_park.models.SiteModel;

public class ParksDAL extends DAL{

	public List<ParkModel> getAllParks(){
		
		List<ParkModel> parks = new ArrayList<ParkModel>();
		
		try(Connection conn = getConnection();
				Statement statement = conn.createStatement();){
			ResultSet result = statement.executeQuery("SELECT * FROM park");
				
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String location = result.getString("location");
					
				parks.add(new ParkModel(id, name, location));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return parks;
	}
	
	public List<SiteModel> getSitesForPark(int parkId){
		
		List<SiteModel> sites = new ArrayList<SiteModel>();
		
		try(Connection conn = getConnection();
				Statement statement = conn.createStatement();){
			ResultSet result = statement.executeQuery("SELECT * FROM site WHERE parkId = " + parkId);
			
			while(result.next()) {
				int id = result.getInt("id");
				int siteNumber = result.getInt("siteNumber");
				double pricePerNight = result.getDouble("pricePerNight");
				boolean isUtils = result.getBoolean("isUtils");
				
				sites.add(new SiteModel(id, parkId, siteNumber, pricePerNight, isUtils));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sites;
	}
}
