package main.java.com.rader.national_park.controllers;

import java.util.List;

import main.java.com.rader.national_park.dals.ParksDAL;
import main.java.com.rader.national_park.models.ParkModel;
import main.java.com.rader.national_park.models.SiteModel;
import main.java.com.rader.national_park.views.ParksView;
import main.java.com.rader.national_park.views.SitesView;

public class ParksController {

	public void veiwParksAction(int userId) {
		List<ParkModel> parks = new ParksDAL().getAllParks();
		ParkModel park = new ParksView().run(parks);
		if(park == null) return;
		viewParkSitesAction(park, userId);
	}
	
	private void viewParkSitesAction(ParkModel park, int userId) {
		List<SiteModel> sites = new ParksDAL().getSitesForPark(park.getId());
		park.setSites(sites);
		int siteIndex = new SitesView().run(park);
		SiteModel selectedSite = sites.get(siteIndex);
		new ReservationsController().makeReservationAction(selectedSite, userId);
	}
}
