package com.gabriel.emplms.transform;

import com.gabriel.emplms.entity.BookingData;
import com.gabriel.emplms.model.Booking;

public interface TransformBookingService {
    BookingData transform(Booking booking);
    Booking transform(BookingData bookingData);
}