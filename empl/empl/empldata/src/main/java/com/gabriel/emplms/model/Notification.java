// Notification.java
package com.gabriel.emplms.model;


import lombok.Data;

@Data
public class Notification {

    private int notificationId;
    private Booking booking;

    private String message;
    private boolean isRead;
}