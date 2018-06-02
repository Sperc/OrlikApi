package com.sosnowka.service;

import com.sosnowka.exeption.NotFoundException;
import com.sosnowka.model.Booking;
import com.sosnowka.model.Player;
import com.sosnowka.model.Playground;

import java.util.List;

/**
 * Created by Pawel on 28.10.2017.
 */
public interface BookingService {
    List<Booking> findAll();

    Booking save(Booking booking);

    Booking getById(Long id) throws NotFoundException;

    List<Player> removePlayerFromBooking(Long bookingId, String username) throws NotFoundException;

    List<Booking> getBookingByPlaygroundId(Long id) throws NotFoundException;

    List<Booking> getSortedBookingList(String date, Playground playground);

    void createBooking(Booking b);

    void delete(Long id);

}
