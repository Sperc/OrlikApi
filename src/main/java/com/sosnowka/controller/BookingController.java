package com.sosnowka.controller;

import com.sosnowka.model.Booking;
import com.sosnowka.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Pawel on 28.10.2017.
 */
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;
    @GetMapping("/get-all")
    public List<Booking> allList(){
        return bookingRepository.findAll();
    }


}
