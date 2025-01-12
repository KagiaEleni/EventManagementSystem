package com.team3.eventManagementSystem.eventManagementSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.team3.eventManagementSystem.eventManagementSystem.models.Reservation;
import com.team3.eventManagementSystem.eventManagementSystem.models.Visitor;

@Service
public class ReservationService {

	@Autowired
	EventService eventService;

	@Autowired
	VisitorService visitorService;

	private List<Reservation> reservationsList = new ArrayList<>();

	/**
	 * Searches the list reservation for all the reservations made by a Visitor.
	 * 
	 * @param userId
	 * @return
	 */

	public List<Reservation> findReservationByUserId(Integer userId) {
		List<Reservation> r = reservationsList.stream()
				.filter(reservation -> reservation.getVisitorId().equals(userId)).toList();
		
		return r;
	}

	/**
	 * Adds a reservation to the List with the reservations.
	 * 
	 * @param reservation
	 */

	public void createReservation(Integer userId, Integer eventId) {
		if (eventService.eventIsFull(eventId) == false) {
			if (userId != null && eventId != null) {
				System.out.println("Reservation made");
				Reservation r = new Reservation(userId, eventId);
				reservationsList.add(r);
			} else
				System.out.println("Incorrect credentials, please check again");
		} else
			System.out.println("Event is full");
	}

	/**
	 * Returns the visitors of a specific event
	 * 
	 * @param eventId
	 * @return
	 */
	// Returns all the visitors for a specific event
	public List<Visitor> getVisitorsForEvent(Integer eventId) {
		// get the reservations for this event
		List<Reservation> reservations = reservationsList.stream()
				.filter(reservation -> reservation.getEventId().equals(eventId)).toList();

		List<Visitor> myVisitors = new ArrayList<Visitor>();
		if (reservations != null) {
			for (Reservation r : reservations) {
				Visitor v = visitorService.findVisitorById(r.getVisitorId());
				myVisitors.add(v);
			}
			return myVisitors;
		} else {
			return null;
		}

	}

	// Deletes a visitor's reservation
	public List<Reservation> deleteReservation(Integer userId, Integer eventId) {
		if (userId != null && eventId != null) {
			reservationsList.removeIf(r -> r.getVisitorId().equals(userId) && r.getEventId().equals(eventId));

		}
		return getAllReservations();
	}

	/*
	 * The function returns all the reservations for a certain event given by id.
	 */
	public List<Reservation> getReservationsForEvent(Integer eventId) {
		return reservationsList.stream().filter(reservation -> reservation.getEventId().equals(eventId))
				.collect(Collectors.toList());
	}

	// Returns all reservations for all events made (not the deleted reservations)
	public List<Reservation> getAllReservations() {
		return reservationsList;
	}

	/*
	 * The function checks whether a visitor has already reserved a spot for an
	 * event or not. If the visitor has not reserved their spot yet, the function
	 * returns true, else it returns false.
	 */
	public boolean checkIfNotExists(Integer visitorId, Integer eventId) {
		return getAllReservations().stream().noneMatch(
				reservation -> reservation.getEventId().equals(eventId) && reservation.getVisitorId().equals(visitorId));
	}

	public void deleteAllReservationsByUser(Integer userId) {
		reservationsList.removeIf(r -> r.getVisitorId().equals(userId));
	}

	public void deleteAllReservationsByEvent(Integer eventId) {
		reservationsList.removeIf(r -> r.getVisitorId().equals(eventId));
	}

}
