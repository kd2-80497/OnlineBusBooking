package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Bus;

public interface BusDao extends JpaRepository<Bus, Long>{

	Bus findBySourceAndDestination(String source, String destination);

	
}
