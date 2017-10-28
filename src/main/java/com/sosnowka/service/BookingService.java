package com.sosnowka.service;

import com.sosnowka.model.Booking;

import java.util.List;

/**
 * Created by Pawel on 28.10.2017.
 */
public interface BookingService {
    public List<Booking> findAll();
    public List<Booking> getAllByDate(String date);
    public Booking save(Booking booking);

}
