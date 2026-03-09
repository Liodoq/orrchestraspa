// Notification.java
package com.gabriel.emplms.model;


import lombok.Data;

@Data
public class Notification {

    private int notificationId;
    private int bookingId;

    private String message;
    private boolean isRead;
}