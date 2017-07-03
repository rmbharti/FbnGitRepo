package com.fbn.fares.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbn.fares.entity.Fare;

public interface FaresRepository extends JpaRepository<Fare,Long> {
	Fare getFareByFlightNumberAndFlightDate(String flightNumber, String flightDate);
}
