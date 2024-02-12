//package com.app.controller;
//
//import com.app.entities.Cancellation;
//import com.app.services.CancellationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/cancellations")
//public class CancellationController {
//
//    @Autowired
//    private CancellationService cancellationService;
//
//    // Add your CRUD operations here
//
//    // Example: Get all cancellations
//    @GetMapping
//    public List<Cancellation> getAllCancellations() {
//        return cancellationService.getAllCancellations();
//    }
//
//    // Example: Get a cancellation by ID
//    @GetMapping("/{id}")
//    public Cancellation getCancellationById(@PathVariable Long id) {
//        return cancellationService.getCancellationById(id);
//    }
//
//    // Example: Create a new cancellation
//    @PostMapping
//    public Cancellation createCancellation(@RequestBody Cancellation cancellation) {
//        return cancellationService.createCancellation(cancellation);
//    }
//
//    // Example: Update an existing cancellation
//    @PutMapping("/{id}")
//    public Cancellation updateCancellation(@PathVariable Long id, @RequestBody Cancellation cancellation) {
//        return cancellationService.updateCancellation(id, cancellation);
//    }
//
//    // Example: Delete a cancellation by ID
//    @DeleteMapping("/{id}")
//    public void deleteCancellation(@PathVariable Long id) {
//        cancellationService.deleteCancellation(id);
//    }