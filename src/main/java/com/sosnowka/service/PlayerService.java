package com.sosnowka.service;

import com.sosnowka.model.AppUser;
import com.sosnowka.model.Booking;
import com.sosnowka.model.Player;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Pawel on 17.11.2017.
 */

public interface PlayerService {
    public Player save(Player player);
    public List<Player> findAll();
    public List<Booking> getUserReservation(String username);
    public Player findOneByUsername(String username);
}
