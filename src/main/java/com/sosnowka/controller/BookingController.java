package com.sosnowka.controller;

import com.sosnowka.model.Booking;
import com.sosnowka.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pawel on 21.10.2017.
 */
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @GetMapping("{date}")
    public ResponseEntity<List<Booking>> getBookingByDay(
            @PathVariable("date") String date){
        return new ResponseEntity<List<Booking>>(bookingService.getBookingByDate(date), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Booking> addBook(@RequestBody Booking booking){
                return new ResponseEntity<Booking>(bookingService.addBooking(booking),HttpStatus.OK);
    }
}
