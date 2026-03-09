package com.gabriel.emplms.serviceimpl;

import com.gabriel.emplms.entity.BookingData;
import com.gabriel.emplms.entity.ServiceData;
import com.gabriel.emplms.entity.UserData;
import com.gabriel.emplms.model.Booking;
import com.gabriel.emplms.repository.BookingDataRepository;
import com.gabriel.emplms.repository.ServiceDataRepository;
import com.gabriel.emplms.repository.UserDataRepository;
import com.gabriel.emplms.service.BookingDataService;
import com.gabriel.emplms.transform.TransformBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingServiceImpl implements BookingDataService {
    Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    BookingDataRepository bookingDataRepository;
    
    @Autowired
    UserDataRepository userDataRepository;
    
    @Autowired
    ServiceDataRepository serviceDataRepository;

    @Autowired
    TransformBookingService transformBookingService;

    @Override
    public Booking[] getAllBooking() {
        List<BookingData> bookingsData = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();

        bookingDataRepository.findAll().forEach(bookingsData::add);
        Iterator<BookingData> it = bookingsData.iterator();

        while(it.hasNext()) {
            BookingData bookingData = it.next();
            Booking booking = transformBookingService.transform(bookingData);
            bookings.add(booking);
        }

        Booking[] array = new Booking[bookings.size()];
        for  (int i=0; i<bookings.size(); i++){
            array[i] = bookings.get(i);
        }
        return array;
    }

    @Override
    public Booking createBooking(Booking booking) {
        logger.info(" add:Input " + booking.toString());
        BookingData bookingData = transformBookingService.transform(booking);

        // Fetch and attach foreign keys for User and Service
        Optional<UserData> user = userDataRepository.findById(booking.getUserId());
        if (user.isPresent()) {
            bookingData.setUser(user.get()); 
        }

        Optional<ServiceData> service = serviceDataRepository.findById(booking.getServiceId());
        if (service.isPresent()) {
            bookingData.setService(service.get()); 
        }

        bookingData = bookingDataRepository.save(bookingData);
        logger.info(" add:Input " + bookingData.toString());

        Booking newBooking = transformBookingService.transform(bookingData);
        return newBooking;
    }

    @Override
    public Booking updateBooking(Booking booking) {
        BookingData bookingData = transformBookingService.transform(booking);

        // Fetch and attach foreign keys for User and Service
        Optional<UserData> user = userDataRepository.findById(booking.getUserId());
        if (user.isPresent()) {
            bookingData.setUser(user.get());
        }

        Optional<ServiceData> service = serviceDataRepository.findById(booking.getServiceId());
        if (service.isPresent()) {
            bookingData.setService(service.get());
        }

        bookingData = bookingDataRepository.save(bookingData);
        Booking newBooking = transformBookingService.transform(bookingData);
        return newBooking;
    }

    @Override
    public Booking getBooking(Integer id) {
        logger.info(" Input id >> "+  Integer.toString(id) );
        Optional<BookingData> optional = bookingDataRepository.findById(id);

        if(optional.isPresent()) {
            logger.info(" Is present >> ");
            BookingData bookingDatum = optional.get();
            Booking booking = transformBookingService.transform(bookingDatum);
            return booking;
        }

        logger.info(" Failed >> unable to locate id: " +  Integer.toString(id)  );
        return null;
    }

    @Override
    public void deleteBooking(Integer id) {
        logger.info(" Input >> " +  Integer.toString(id));
        Optional<BookingData> optional = bookingDataRepository.findById(id);

        if( optional.isPresent()) {
            BookingData bookingDatum = optional.get();
            bookingDataRepository.delete(bookingDatum);
            logger.info(" Success >> " + bookingDatum.toString());
        }
        else {
            logger.info(" Failed >> unable to locate booking id:" +  Integer.toString(id));
        }
    }
}