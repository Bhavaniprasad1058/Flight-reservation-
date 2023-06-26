package com.flight_reservation_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight_reservation_app.dto.ReservationRequest;
import com.flight_reservation_app.entities.Flight;
import com.flight_reservation_app.entities.Passenger;
import com.flight_reservation_app.entities.Reservation;
import com.flight_reservation_app.repositories.FlightRepository;
import com.flight_reservation_app.repositories.PassengerRepository;
import com.flight_reservation_app.repositories.ReservationRepository;
import com.flight_reservation_app.utilities.EmailUtil;
import com.flight_reservation_app.utilities.PdfGenerator;
@Service
public class ReservationServiceImpl implements ReservationService {
	
	

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepository.save(passenger);
		
		
	   Long flightId = request.getFlightId();
	   Optional<Flight> findById = flightRepository.findById(flightId);
	   Flight flight = findById.get();
	   
	   Reservation reservation=new Reservation();
	   reservation.setFlight(flight);
	   reservation.setPassenger(passenger);
	   reservation.setCheckedIn(false);
	   reservation.setNumberOfBags(0);
	   reservationRepository.save(reservation);
	   String filepath="D:\\tickets\\"+reservation.getId()+".pdf";
	   
	   PdfGenerator pdf=new PdfGenerator();
	   pdf.generatePDF(filepath,request.getFirstName()+request.getMiddleName(), request.getEmail(), request.getPhone(), flight.getOperatingAirlines(), flight.getDateOfDeparture(), flight.getDepartureCity(), flight.getArrivalCity());
	   emailUtil.sendItinerary(passenger.getEmail(), filepath);
	   return reservation;
	}

}
