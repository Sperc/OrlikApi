package com.sosnowka.service;

import com.sosnowka.exeption.NotFoundException;
import com.sosnowka.model.Booking;
import com.sosnowka.model.Player;

import java.util.List;

/**
 * Created by Pawel on 17.11.2017.
 */

public interface PlayerService {
    void delete(Player player);

    Player save(Player player);

    List<Player> findAll();

    List<Booking> getUserReservation(String username);

    Player findOneByUsername(String username) throws NotFoundException;

    Player findById(Long id) throws NotFoundException;

    Player edit(String name, Player player) throws NotFoundException;

}
