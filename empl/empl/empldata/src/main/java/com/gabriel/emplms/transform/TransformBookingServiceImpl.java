package com.gabriel.emplms.transform;

import com.gabriel.emplms.entity.BookingData;
import com.gabriel.emplms.model.Booking;
import com.gabriel.emplms.model.Status;
import org.springframework.stereotype.Service;

@Service
public class TransformBookingServiceImpl implements TransformBookingService {

    @Override
    public BookingData transform(Booking booking) {
        BookingData bookingData = new BookingData();

        bookingData.setBookingId(booking.getBookingId());
        bookingData.setBookingDate(booking.getBookingDate());
        bookingData.setBookingTime(booking.getBookingTime());
        
        bookingData.setStatus(Status.PENDING);
        
        return bookingData;
    }

    @Override
    public Booking transform(BookingData bookingData){
        Booking booking = new Booking();

        booking.setBookingId(bookingData.getBookingId());
        booking.setBookingDate(bookingData.getBookingDate());
        booking.setBookingTime(bookingData.getBookingTime());
        
        booking.setStatus(Status.PENDING);

        return booking;
    }
}