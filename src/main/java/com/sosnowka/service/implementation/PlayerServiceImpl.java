package com.sosnowka.service.implementation;

import com.sosnowka.core.DateClass;
import com.sosnowka.model.Booking;
import com.sosnowka.model.Player;
import com.sosnowka.repository.PlayerRepository;
import com.sosnowka.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Pawel on 17.11.2017.
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public List<Booking> getUserReservation(String username) {
        DateClass dateClass = new DateClass();
        List<Booking> list = new ArrayList<>();
        for(Booking b : playerRepository.findOneByUsername(username).getBookingList()){
            try {
                if(dateClass.isAfterNowday(b.getDate())){
                    list.add(b);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
