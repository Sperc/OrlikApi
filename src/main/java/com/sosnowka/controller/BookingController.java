package com.sosnowka.controller;

import com.sosnowka.model.Booking;
import com.sosnowka.model.Player;
import com.sosnowka.repository.BookingRepository;
import com.sosnowka.service.BookingService;
import com.sosnowka.service.PlayerService;
import com.sosnowka.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pawel on 28.10.2017.
 */
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    PlayerService playerService;

    @GetMapping("/get-all")
    public List<Booking> allList() {
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public HttpEntity<Booking> getBookingById(@PathVariable("id") Long id) {
        return new ResponseEntity<Booking>(bookingService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/{username}")
    public HttpEntity addPlayerToBooking(@PathVariable("id") Long id,
                                         @PathVariable("username") String username) {
        Booking b = bookingService.getById(id);
        Player player = playerService.findOneByUsername(username);
        if(b.getPlayers().contains(player) || player == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        try{
            b.getPlayers().add(player);
            bookingService.save(b);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.OK);
    }


}
