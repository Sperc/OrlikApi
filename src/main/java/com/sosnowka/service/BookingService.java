package com.sosnowka.service;

import com.sosnowka.exeption.PlayerNotFoundExeption;
import com.sosnowka.model.Booking;
import com.sosnowka.model.Player;
import com.sosnowka.model.Playground;

import java.util.List;

/**
 * Created by Pawel on 28.10.2017.
 */
public interface BookingService {
    public List<Booking> findAll();
    public List<Booking> getAllByDate(String date);
    public Booking save(Booking booking);
    public Booking getById(Long id);
    public List<Player> removePlayerFromBooking(Long bookingId,String username) throws PlayerNotFoundExeption;
    public List<Booking> getBookingByPlaygroundId(Long id) throws PlayerNotFoundExeption;
    public List<Booking>getSortedBookingList(String date,Playground playground);
    void createBooking(Booking b);
    void delete(Long id);

}
