package com.gabriel.emplms.service;

import com.gabriel.emplms.model.Booking;

public interface BookingDataService {
    Booking[] getAllBooking() throws Exception;
    Booking getBooking(Integer bookingId) throws Exception;
    Booking createBooking(Booking booking) throws Exception;
    Booking updateBooking(Booking booking) throws Exception;
    void deleteBooking(Integer bookingId) throws Exception;
}