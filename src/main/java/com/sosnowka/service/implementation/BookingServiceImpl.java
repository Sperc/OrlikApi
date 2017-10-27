package com.sosnowka.service.implementation;

import com.sosnowka.model.AppUser;
import com.sosnowka.model.Booking;
import com.sosnowka.repository.BookingRepository;
import com.sosnowka.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Pawel on 21.10.2017.
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingByDate(String date) {
        return bookingRepository.findAllByDate(date);
    }

    @Override
    public Booking addPlayersToBooking(Set<AppUser> setUser, Long id) {
        Booking booking = bookingRepository.getBookingById(id);
        Set<AppUser> set = booking.getAppUserSet();
        set.addAll(setUser);
        if (set.size() <= booking.getMaxNumberOfPlayer()) {
            booking.setAppUserSet(set);
            return booking;
        } else
            throw new IllegalArgumentException("To many players");
    }

}
