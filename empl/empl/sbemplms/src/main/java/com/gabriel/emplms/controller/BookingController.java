package com.gabriel.emplms.controller;

import com.gabriel.emplms.model.Booking;
import com.gabriel.emplms.service.BookingDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {
    
    Logger logger = LoggerFactory.getLogger(BookingController.class);
    
    @Autowired
    private BookingDataService bookingDataService;
    
    @GetMapping("/api/booking")
    public ResponseEntity<?> listBooking() {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> response;
        try {
            Booking[] bookings = bookingDataService.getAllBooking();
            response = ResponseEntity.ok().headers(headers).body(bookings);
        } catch(Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }
    
    @PutMapping("api/booking")
    public ResponseEntity<?> add(@RequestBody Booking booking) {
        logger.info("Input >> " + booking.toString() );
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> response;
        try {
            Booking newBooking = bookingDataService.createBooking(booking);
            logger.info("created booking >> " + newBooking.toString() );
            response = ResponseEntity.ok(newBooking);
        } catch(Exception ex) {
            logger.error("Failed to create booking : {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }
    
    @PostMapping("api/booking")
    public ResponseEntity<?> update(@RequestBody Booking booking) {
        logger.info("Update Input >> " + booking.toString());
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> response;
        try {
            Booking newBooking = bookingDataService.updateBooking(booking);
            response = ResponseEntity.ok(newBooking);
        } catch(Exception ex) {
            logger.error("Failed to update booking : {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @GetMapping("api/booking/{id}")
    public ResponseEntity<?> get(@PathVariable final Integer id) {
        logger.info("Input booking id >> " + Integer.toString(id));
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> response;
        try {
            Booking booking = bookingDataService.getBooking(id);
            response = ResponseEntity.ok(booking);
        } catch(Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }
    
    @DeleteMapping("api/booking/{id}")
    public ResponseEntity<?> delete(@PathVariable final Integer id) {
        logger.info("Input >> " + Integer.toString(id));
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> response;
        try {
            bookingDataService.deleteBooking(id);
            response = ResponseEntity.ok(null);
        } catch(Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }
}