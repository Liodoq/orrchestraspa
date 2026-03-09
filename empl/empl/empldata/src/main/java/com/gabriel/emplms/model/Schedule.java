// Schedule.java
package com.gabriel.emplms.model;


import lombok.Data;

@Data

public class Schedule {

    private int scheduleId;

    private String availableDate;
    private String availableTime;
    private boolean isBooked;
}