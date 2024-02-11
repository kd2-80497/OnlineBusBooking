package com.app.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BusDao;
import com.app.dto.ApiResponse;
import com.app.dto.BusDto;
import com.app.entities.Bus;

import custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class BusServiceImpl implements BusService {
	@Autowired
	private BusDao busdao;
	
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public BusDto addNewBus(@Valid BusDto dto) {
		Bus bus = mapper.map(dto,Bus.class);
		Bus persistentBus = busdao.save(bus);
		return mapper.map(persistentBus, BusDto.class);
		
	}

	@Override
	public BusDto getBusDeails(Long busId) {
		
		return mapper.map(
				busdao.findById(busId).orElseThrow(() -> new ResourceNotFoundException("Invalid Bus Id !!!!")),
				BusDto.class);
	}

	@Override
	public BusDto getBusDetailsBySourceAndDestination(String source, String destination) {
		
		Bus persistentBus = busdao.findBySourceAndDestination(source,destination);
		
		
		return mapper.map(persistentBus, BusDto.class);
	}

	@Override
	public BusDto updateBus(Long busId, @Valid BusDto bus) {
		Bus persistentBus = busdao.findById(busId).orElseThrow(()->new ResourceNotFoundException("Invalid Bus Id !!!!"));
		persistentBus.setArrivalTime(bus.getArrivalTime());
		persistentBus.setDepartureTime(bus.getDepartureTime());
		persistentBus.setSource(bus.getSource());
		persistentBus.setDestination(bus.getDestination());
		persistentBus.setTravelDate(bus.getTravelDate());
		persistentBus.setFare(bus.getFare());
		persistentBus.setAvailableSeats(bus.getAvailableSeats());
		return mapper.map(persistentBus, BusDto.class);
	}

	@Override
	public ApiResponse deleteBus(Long busId) {
		
		Bus persistentBus = busdao.findById(busId).orElseThrow(()->new ResourceNotFoundException("Invalid Bus Id !!!!"));
		busdao.delete(persistentBus);
		return  new ApiResponse("Bus Details of Bus with ID " + persistentBus.getId() + " deleted....");

	
	
	}
}
