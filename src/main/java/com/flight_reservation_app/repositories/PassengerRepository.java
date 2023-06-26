package com.flight_reservation_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation_app.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
