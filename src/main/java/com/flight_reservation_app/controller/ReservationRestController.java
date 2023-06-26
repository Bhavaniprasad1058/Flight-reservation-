package com.flight_reservation_app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight_reservation_app.dto.ReservationUpdaterequest;
import com.flight_reservation_app.entities.Reservation;
import com.flight_reservation_app.repositories.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	
	@RequestMapping("/reservation/{id}")
	public Reservation findreservation(@PathVariable("id") Long id) {
		Optional<Reservation> findById = reservationRepository.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}

	@RequestMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdaterequest request) {
		Optional<Reservation> findById = reservationRepository.findById(request.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		return reservationRepository.save(reservation);
	}
}
