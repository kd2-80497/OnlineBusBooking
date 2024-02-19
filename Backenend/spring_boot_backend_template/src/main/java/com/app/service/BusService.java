package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.AddBusDTO;
import com.app.dto.ApiResponse;
import com.app.dto.BusDto;
import com.app.dto.BusResponseDTO;
import com.app.entities.Bus;

public interface BusService {

//	BusDto addNewBus(@Valid BusDto dto);

	BusDto getBusDeails(Long busId);

	List<BusDto> getBusDetailsBySourceAndDestination(String source, String destination);

	BusDto updateBus(Long busId, @Valid BusDto bus);

	ApiResponse deleteBus(Long busId);
//	public List<Bus> getAllBus();

	List<BusDto> getAllBus();

	

	BusResponseDTO addBusDetails(AddBusDTO dto);

//	List<String> getBusSource();

}
