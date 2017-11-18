package com.sosnowka.service;

import com.sosnowka.model.AppUser;
import com.sosnowka.model.Player;

import java.util.List;

/**
 * Created by Pawel on 17.11.2017.
 */

public interface PlayerService {
    public Player save(Player player);
    public List<Player> findAll();
}
