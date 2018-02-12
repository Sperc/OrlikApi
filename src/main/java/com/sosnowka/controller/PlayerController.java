package com.sosnowka.controller;

import com.sosnowka.model.Booking;
import com.sosnowka.model.Player;
import com.sosnowka.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Pawel on 27.11.2017.
 */
@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/add")
    private HttpEntity addPlayer(@RequestBody Player player){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        player.setUsername(name);
        if(playerService.findOneByUsername(player.getUsername())!=null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        player.setBookingList(new ArrayList<>());
        player.setUserTeams(new HashSet<>());
        playerService.save(player);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/reservation")
    public HttpEntity<List<Booking>> getUserReservation() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return new ResponseEntity<List<Booking>>(playerService.getUserReservation(name), HttpStatus.OK);
    }
    @GetMapping("/get")
    public HttpEntity<Player> getLogInPlayer(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Player p = playerService.findOneByUsername(name);
        if(p==null){
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Player>(p,HttpStatus.OK);
    }
}
