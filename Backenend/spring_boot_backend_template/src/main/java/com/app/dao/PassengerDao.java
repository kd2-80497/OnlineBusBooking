package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.entities.Passenger;

public interface PassengerDao extends JpaRepository<Passenger, Long>{
	 Passenger findByBookingId(Long bookingId);
}
