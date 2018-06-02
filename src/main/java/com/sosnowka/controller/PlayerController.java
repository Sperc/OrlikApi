package com.sosnowka.controller;

import com.sosnowka.exeption.NotFoundException;
import com.sosnowka.model.Booking;
import com.sosnowka.model.Picture;
import com.sosnowka.model.Player;
import com.sosnowka.model.wraper.CreatePlayerObject;
import com.sosnowka.service.PictureService;
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
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private PictureService pictureService;

    @GetMapping()
    public HttpEntity<Player> getLogInPlayer() throws NotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Player p = playerService.findOneByUsername(name);
        if (p == null) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Player>(p, HttpStatus.OK);
    }

    @PostMapping()
    private HttpEntity addPlayer(@RequestBody CreatePlayerObject playerObject) throws NotFoundException {

        Player player = playerObject.getPlayer();
        byte[] bytesPhoto = playerObject.getPhoto();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        player.setUsername(name);
        if (playerService.findOneByUsername(player.getUsername()) != null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        player.setBookingList(new ArrayList<>());
        player.setUserTeams(new HashSet<>());

        Picture picture = pictureService.storagePhoto(bytesPhoto, player.getUsername());
        player.setPicture(picture);
        playerService.save(player);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping()
    public HttpEntity editPlayer(@RequestBody Player player) throws NotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        playerService.edit(name, player);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/reservation")
    public HttpEntity<List<Booking>> getUserReservation() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return new ResponseEntity<List<Booking>>(playerService.getUserReservation(name), HttpStatus.OK);
    }


    @GetMapping("/{username}")
    public HttpEntity<Player> getPlayerByUsername(@PathVariable String username) throws NotFoundException {
        Player player = playerService.findOneByUsername(username);
        if (player == null) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Player>(player, HttpStatus.OK);
    }
}
