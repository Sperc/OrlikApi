package com.sosnowka.service;

import com.sosnowka.model.Booking;

import java.util.List;

/**
 * Created by Pawel on 21.10.2017.
 */
public interface BookingService {
   public Booking addBooking(Booking booking);
   public List<Booking> getBookingByDate(String date);
}
