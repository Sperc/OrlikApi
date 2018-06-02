package com.sosnowka.controller;

import com.sosnowka.exeption.NotFoundException;
import com.sosnowka.model.Booking;
import com.sosnowka.model.Player;
import com.sosnowka.model.Playground;
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
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    PlayerService playerService;
    @Autowired
    PlaygroundService playgroundService;

    @GetMapping()
    public List<Booking> allList() {
        return bookingService.findAll();
    }

    @PostMapping()
    public ResponseEntity addBooking(@RequestBody Booking booking) {
        bookingService.createBooking(booking);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity deleteBooking(@PathVariable("id") Long id) {
        bookingService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<Booking> getBookingById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<Booking>(bookingService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/add-user/{username}")
    public HttpEntity<List<Player>> addPlayerToBooking(@PathVariable Long id,
                                                       @PathVariable String username) throws NotFoundException {
        Booking b = bookingService.getById(id);
        Player player = playerService.findOneByUsername(username);
        if (b.getPlayers().contains(player) || player == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        try {
            b.getPlayers().add(player);
            bookingService.save(b);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(b.getPlayers(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete-user/{username}")
    public HttpEntity<List<Player>> removePlayerFromBooking(@PathVariable Long id,
                                                            @PathVariable String username) {
        try {
            return new ResponseEntity(bookingService.removePlayerFromBooking(id, username), HttpStatus.OK);
        } catch (NotFoundException playerNotFoundExeption) {
            playerNotFoundExeption.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("playground/{playground_id}/get-all")
    public HttpEntity<List<Booking>> getBookingByPlaygroundId(@PathVariable("playground_id") Long playground_id) {
        try {
            return new ResponseEntity<List<Booking>>(bookingService.getBookingByPlaygroundId(playground_id), HttpStatus.OK);
        } catch (NotFoundException playerNotFoundExeption) {
            playerNotFoundExeption.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("playground/{playground_id}/{date}")
    public HttpEntity<List<Booking>> getBookingByPlaygorundAndDate(@PathVariable("playground_id") Long playgroundId,
                                                                   @PathVariable("date") String date) {
        Playground playground = playgroundService.findOneById(playgroundId);
        if (playground == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(bookingService.getSortedBookingList(date, playground), HttpStatus.OK);
    }

}
