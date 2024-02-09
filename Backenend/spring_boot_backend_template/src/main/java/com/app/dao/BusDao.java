package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Bus;
import com.app.entities.User;
public interface BusDao extends JpaRepository<Bus, Long> {

	
	Optional<Bus> findBySourceAndDestination(String src, String des);
}



