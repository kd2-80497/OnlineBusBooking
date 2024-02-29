package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BusDao;
import com.app.dto.AddBusDTO;
import com.app.dto.AddPasDTO;
import com.app.dto.ApiResponse;
import com.app.dto.BusDto;
import com.app.dto.BusResponseDTO;
import com.app.dto.PasRespDTO;
import com.app.entities.Booking;
import com.app.entities.Bus;
import com.app.entities.Passenger;

import custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class BusServiceImpl implements BusService {
	@Autowired
	private BusDao busdao;

	@Autowired
	private ModelMapper mapper;

//	@Override
//	public BusDto addNewBus(@Valid BusDto dto)
//	{
//		Bus bus = mapper.map(dto, Bus.class);
//		bus.setServiceStatus("Active");
//		Bus persistentBus = busdao.save(bus);
//		return mapper.map(persistentBus, BusDto.class);
//
//	}
	@Override
	public BusResponseDTO addBusDetails(AddBusDTO dto) {
		Bus bus = mapper.map(dto, Bus.class);
		bus.setServiceStatus("Active");
		Bus persistentBus = busdao.save(bus);
		return mapper.map(persistentBus, BusResponseDTO.class);
		
	}

	@Override
	public BusDto getBusDeails(Long busId) {

		return mapper.map(
				busdao.findById(busId).orElseThrow(() -> new ResourceNotFoundException("Invalid Bus Id !!!!")),
				BusDto.class);
	}

	@Override
	public List<BusDto> getBusDetailsBySourceAndDestination(String source, String destination) {

		List<Bus> buses = busdao.findBySourceAndDestination(source, destination);

		return buses.stream().map(bus -> mapper.map(bus, BusDto.class)).collect(Collectors.toList());
	}

	@Override
	public BusDto updateBus(Long busId, @Valid BusDto bus) {
		System.out.println("busid "+busId);
		Bus persistentBus = busdao.findById(busId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Bus Id !!!!"));
		persistentBus.setArrivalTime(bus.getArrivalTime());
		persistentBus.setDepartureTime(bus.getDepartureTime());
		persistentBus.setSource(bus.getSource());
		persistentBus.setDestination(bus.getDestination());
		persistentBus.setTravelDate(bus.getTravelDate());
		persistentBus.setFare(bus.getFare());
		persistentBus.setAvailableSeats(bus.getAvailableSeats());
		Bus persistentBus1 =busdao.save(persistentBus);
		return mapper.map(persistentBus1, BusDto.class);
	}

	@Override
	public ApiResponse deleteBus(Long busId) {

		Bus persistentBus = busdao.findById(busId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Bus Id !!!!"));
		persistentBus.setServiceStatus("Inactive");
//		busdao.delete(persistentBus);
		return new ApiResponse("Bus Details of Bus with ID " + persistentBus.getId() + " deleted....");

	}

//	@Override
//	public List<BusDto> getAllBus() {
//	
//	List<Bus> buses =busdao.findAll();
//	
//		
//	return buses.stream().map(bus->
//	
//	{
//		if(bus.getServiceStatus().equalsIgnoreCase("Active"))
//	return mapper.map(bus, BusDto.class);
//	}
//	)
//            .collect(Collectors.toList());
//	}

	@Override
	public List<BusDto> getAllBus() {
		List<Bus> buses = busdao.findAll();
		System.out.println("Bus list" + buses);
		return buses.stream().filter(bus -> bus.getServiceStatus().equalsIgnoreCase("Active"))
				.map(bus -> mapper.map(bus, BusDto.class)).collect(Collectors.toList());
	}

	

//	public List<Bus> getAllBus(){
//		return busdao.findAll();
//	}
}
