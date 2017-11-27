package com.sosnowka.controller;

import com.sosnowka.model.Booking;
import com.sosnowka.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Pawel on 27.11.2017.
 */
@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/reservation")
   public List<Booking> getUserReservation(){
        String user = "psosnowka";
        return playerService.getUserReservation(user);
    }
}
