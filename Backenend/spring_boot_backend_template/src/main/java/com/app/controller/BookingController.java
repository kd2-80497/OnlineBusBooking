//package com.app.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/busbooking")
//public class BookingController {
//
//    @Autowired
//    private BookingService busBookingService;
//
//    @GetMapping("/form")
//    public String showBookingForm(Model model) {
//        // Add any necessary data to the model (e.g., dropdown options, etc.)
//        return "bookingForm"; // Name of the Thymeleaf/HTML template
//    }
//
//    @PostMapping("/submit")
//    public String submitBooking(
//            @RequestParam("paymentStatus") String paymentStatus,
//            @RequestParam("totalAmount") double totalAmount,
//            @RequestParam("bookingId") Long bookingId,
//            @RequestParam("userId") Long userId,
//            Model model
//    ) {
//        // You may want to perform validation and error handling here
//
//        // Create a new Transaction object
//        Transaction transaction = new Transaction();
//        transaction.setPaymentStatus(paymentStatus);
//        transaction.setTotalAmount(totalAmount);
//        transaction.setBookingId(bookingId);
//        transaction.setUserId(userId);
//
//        // Save the transaction using the service
//        busBookingService.saveTransaction(transaction);
//
//        // Add any necessary data to the model for the confirmation page
//        model.addAttribute("transaction", transaction);
//
//        return "bookingConfirmation"; // Name of the Thymeleaf/HTML template
//    }
//}
