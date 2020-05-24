package main.java.com.rader.national_park.models;

import java.util.List;

public class ParkModel {

	private int id;
	private String name;
	private String location;
	private List<SiteModel> sites;
	
	public ParkModel() {
		this.id = -1;
		this.name = "";
		this.location = "";
	}
	
	public ParkModel(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public List<SiteModel> getSites() {
		return sites;
	}

	public void setSites(List<SiteModel> sites) {
		this.sites = sites;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}
	
	
}
