package com.sosnowka.service.implementation;

import com.sosnowka.model.Booking;
import com.sosnowka.repository.BookingRepository;
import com.sosnowka.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pawel on 28.10.2017.
 */
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getAllByDate(String date) {
        return bookingRepository.findAllByDate(date);
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }
}
