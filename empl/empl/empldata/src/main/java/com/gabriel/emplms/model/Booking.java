// Booking.java
package com.gabriel.emplms.model;

import lombok.Data;

@Data
public class Booking {

    private int bookingId;
    private User user;
    private Service service;
    private Status status;
    private Notification notification;

    private String bookingDate; 
    private String bookingTime; 
}