package com.sosnowka.service.implementation;

import com.sosnowka.exeption.PlayerNotFoundExeption;
import com.sosnowka.model.Booking;
import com.sosnowka.model.Player;
import com.sosnowka.model.Playground;
import com.sosnowka.repository.BookingRepository;
import com.sosnowka.repository.PlayerRepository;
import com.sosnowka.repository.PlaygroundRepository;
import com.sosnowka.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pawel on 28.10.2017.
 */
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlaygroundRepository playgroundRepository;

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

    @Override
    public Booking getById(Long id) {
        return bookingRepository.getById(id);
    }

    @Override
    public List<Player> removePlayerFromBooking(Long bookingId, String username) throws PlayerNotFoundExeption {
        Booking booking = bookingRepository.getById(bookingId);
        Player player = playerRepository.findOneByUsername(username);
        if (player == null)
            throw new PlayerNotFoundExeption("player not found");
        booking.getPlayers().remove(player);
        bookingRepository.save(booking);
        return booking.getPlayers();

    }

    @Override
    public List<Booking> getBookingByPlaygroundId(Long id) throws PlayerNotFoundExeption {
        Playground playground = playgroundRepository.getById(id);
        if (playground == null) throw new PlayerNotFoundExeption("Playground not found");
        ArrayList<Booking> arrayList = new ArrayList<>();
        arrayList.addAll(playground.getBookingSet());
        return arrayList;
    }

    @Override
    public List<Booking> getSortedBookingList(String date, Playground playground) {
        return bookingRepository.getAllByPlaygroundAndDate(playground, date)
                .stream()
                .sorted(Comparator.comparing(Booking::getStartOrderHour).thenComparing(Booking::getStartOrderMinutes))
                .collect(Collectors.toList());
    }

    @Override
    public void createBooking(Booking b) {
        List<Player> players = new ArrayList<>();
        Player leader = playerRepository.findOneByUsername(b.getLeaderName());
        players.add(leader);
        b.setPlayers(players);
        bookingRepository.save(b);
    }

    @Override
    public void delete(Long id) {
        try {
            bookingRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
