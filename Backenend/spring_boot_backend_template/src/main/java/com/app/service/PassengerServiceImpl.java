package com.app.service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.PassengerDao;
import com.app.dto.AddPasDTO;
import com.app.dto.PasRespDTO;
import com.app.entities.Passenger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerDao passengerRepository;
    @Autowired
	private ModelMapper mapper;

    @Autowired
    public PassengerServiceImpl(PassengerDao passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

//    @Override
//    public Passenger getPassengerById(Long id) {
//        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
//        return optionalPassenger.orElse(null);
//    }

//    @Override
//    public Passenger createPassenger(@Valid AddPasDTO dto) {
//        return passengerRepository.save(passenger);
//    }
	@Override
	public PasRespDTO addPasDetails(AddPasDTO newPas) {
		// 1. get dept from it's id
//		Department dept = deptDao.findById(newEmp.getDeptId())
//				.orElseThrow(() -> new ResourceNotFoundException("Invalid dept id !!!!!"));
		// => dept : persistent
		// 2. map emp dto --> entity
		Passenger emp = mapper.map(newPas, Passenger.class);
		//dept.addEmployee(emp);
		Passenger persistentEmp=passengerRepository.save(emp);// Since want to send generated emp id to the REST clnt : saved it explicitly!
		return mapper.map(persistentEmp, PasRespDTO.class);
	}

    @Override
    public Passenger updatePassenger(Long id, Passenger updatedPassenger) {
        if (passengerRepository.existsById(id)) {
            updatedPassenger.setId(id);
            return passengerRepository.save(updatedPassenger);
        }
        return null; // Handle non-existing passenger
    }

//    @Override
//    public void deletePassenger(Long id) {
//        passengerRepository.deleteById(id);
//    }
    @Override
    public Passenger getPassengerByBookingId(Long bookingId) {
        return passengerRepository.findByBookingId(bookingId);
    }

//	@Override
//	public Passenger getPassengerById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}


@Override
public String deletePassengerDetails(Long pasId) {
	if (passengerRepository.existsById(pasId)) {
		passengerRepository.deleteById(pasId);
		return "Deleted Passenger details....";
	}
	// => invalid emp id
	throw new ResourceNotFoundException("Passenger details can't be deleted : Invalid Emp Id!!!");
}

//	@Override
//	public String deletePassengerDetails(Long pasId) {
//		if (passengerRepository.existsById(pasId)) {
//			passengerRepository.deleteById(pasId);
//			return "Deleted emp details....";
//		}
//		// => invalid emp id
//		throw new ResourceNotFoundException("Passenger details can't be deleted : Invalid Emp Id!!!");
//	}
}