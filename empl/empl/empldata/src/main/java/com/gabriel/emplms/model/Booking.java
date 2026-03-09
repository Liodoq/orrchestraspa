// Booking.java
package com.gabriel.emplms.model;

import lombok.Data;

@Data
public class Booking {

    private int bookingId;
    private int userId;
    private int serviceId;
    private Status status;
    private int notificationId;

    private String bookingDate; 
    private String bookingTime; 
}