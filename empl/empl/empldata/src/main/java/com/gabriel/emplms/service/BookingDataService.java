package com.gabriel.emplms.service;

import com.gabriel.emplms.entity.BookingData;
import java.util.List;

public interface BookingDataService {
    List<BookingData> getAllBooking() throws Exception;
    BookingData getBooking(Integer bookingId) throws Exception;
    BookingData createBooking(BookingData booking) throws Exception;
    BookingData updateBooking(BookingData booking) throws Exception;
    void deleteBooking(Integer bookingId) throws Exception;
}