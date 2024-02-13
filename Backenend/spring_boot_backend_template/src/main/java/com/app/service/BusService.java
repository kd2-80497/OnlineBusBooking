package com.app.service;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.BusDto;

public interface BusService {

	BusDto addNewBus(@Valid BusDto dto);

	BusDto getBusDeails(Long busId);

	BusDto getBusDetailsBySourceAndDestination(String source, String destination);

	BusDto updateBus(Long busId, @Valid BusDto bus);

	ApiResponse deleteBus(Long busId);

}
