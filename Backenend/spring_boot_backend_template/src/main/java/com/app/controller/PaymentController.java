//package com.app.controller;
//
//
//	
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.http.HttpStatus;
//	import org.springframework.http.ResponseEntity;
//	import org.springframework.web.bind.annotation.*;
//
//import com.app.entities.Payment;
//import com.app.service.PaymentService;
//
//import java.util.List;
//
//	@RestController
//	@RequestMapping("/payments")
//	public class PaymentController {
//		@Autowired
//	    private final PaymentService paymentService;
//
//	    @Autowired
//	    public PaymentController(PaymentService paymentService) {
//	        this.paymentService = paymentService;
//	    }
//
//	    @GetMapping("/{paymentId}")
//	    public ResponseEntity<Payment> getPaymentById(@PathVariable Long paymentId) {
//	    	System.out.println("in getpayment");
//	        //Payment payment = paymentService.getPaymentById(paymentId);
//	        //return ResponseEntity.ok(payment);
//	    	return null;
//	    }
//
//	    @GetMapping
//	    public ResponseEntity<List<Payment>> getAllPayments() {
//	        List<Payment> payments = paymentService.getAllPayments();
//	        return ResponseEntity.ok(payments);
//	    }
//
//	    @PostMapping
//	    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
//	        Payment savedPayment = paymentService.savePayment(payment);
//	        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
//	    }
//
//	    @DeleteMapping("/{paymentId}")
//	    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
//	        paymentService.deletePayment(paymentId);
//	        return ResponseEntity.noContent().build();
//	    }
//	}
//
//
