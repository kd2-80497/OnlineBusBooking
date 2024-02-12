package com.app.service;


import com.app.dao.CancellationDao;
import com.app.entities.Cancellation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancellationService implements CancellationServices{

    @Autowired
    private CancellationDao cancellationRepository;

    public List<Cancellation> getAllCancellations() {
        return cancellationRepository.findAll();
    }

    public Cancellation getCancellationById(Long id) {
        return cancellationRepository.findById(id).orElse(null);
    }

    public Cancellation createCancellation(Cancellation cancellation) {
        return cancellationRepository.save(cancellation);
    }

    public Cancellation updateCancellation(Long id, Cancellation newCancellation) {
        Cancellation existingCancellation = getCancellationById(id);

        if (existingCancellation != null) {
            // Update fields as needed
            existingCancellation.setRefoundAmount(newCancellation.getRefoundAmount());
            existingCancellation.setReason(newCancellation.getReason());
            existingCancellation.setCancelDate(newCancellation.getCancelDate());

            return cancellationRepository.save(existingCancellation);
        }

        return null; // or throw an exception indicating not found
    }

    public void deleteCancellation(Long id) {
        cancellationRepository.deleteById(id);
    }
}
