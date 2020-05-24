package main.java.com.rader.national_park.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import main.java.com.rader.national_park.dals.ParksDAL;
import main.java.com.rader.national_park.dals.ReservationsDAL;
import main.java.com.rader.national_park.models.ParkModel;
import main.java.com.rader.national_park.models.ReservationModel;
import main.java.com.rader.national_park.models.SiteModel;
import main.java.com.rader.national_park.models.UserModel;
import main.java.com.rader.national_park.utils.ConsoleUtils;
import main.java.com.rader.national_park.views.NewReservationView;
import main.java.com.rader.national_park.views.UserReservationView;

public class ReservationsController {

	public void makeReservationAction(SiteModel site, int userId) {
		
		boolean isVerified = false;
		List<ReservationModel> reservations = new ReservationsDAL().getReservationsForSite(site.getId());
		ReservationModel unverifiedReservation = new ReservationModel();
		while(!isVerified) {
			unverifiedReservation = new NewReservationView().run(site.getSiteNumber());
			isVerified = verifyAvailability(unverifiedReservation, reservations);
			if(!isVerified) ConsoleUtils.println("These dates are already taken");
		}
		unverifiedReservation.setUserId(userId);
		unverifiedReservation.setSiteId(site.getId());
		unverifiedReservation.setParkId(site.getParkId());
		unverifiedReservation.calculateAmountDue(site.getPricePerNight());
		boolean didSave = new ReservationsDAL().saveReservation(unverifiedReservation);
		
		if(!didSave) ConsoleUtils.println("An error occured while proccessing your reservation");
	}
	
	public void viewReservationsAction(UserModel user) {
		
		List<ReservationModel> reservations = new ReservationsDAL().getReservationsForUser(user.getId());
		List<ParkModel> parks = new ParksDAL().getAllParks();
		Map<ReservationModel, String> parksAndRes = new HashMap<ReservationModel, String>();
		for(ReservationModel res : reservations) {
			String parkName = parks.stream().filter(p -> p.getId() == res.getParkId()).collect(Collectors.toList()).get(0).getName();
			parksAndRes.put(res, parkName);
		}
		new UserReservationView().run(parksAndRes);
	}
	
	private boolean verifyAvailability(ReservationModel reservation, List<ReservationModel> reservations) {
		
		boolean isAvaliable = reservations.stream().allMatch(r -> 
				(
					(reservation.getStartDate().isBefore(r.getStartDate()) && reservation.getEndDate().isBefore(r.getStartDate()))
					||
					(reservation.getStartDate().isAfter(r.getEndDate()) && reservation.getEndDate().isAfter(r.getEndDate()))
				)
			);
		return isAvaliable;
	}
}
