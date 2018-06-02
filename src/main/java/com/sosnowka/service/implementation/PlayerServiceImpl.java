package com.sosnowka.service.implementation;

import com.sosnowka.core.DateClass;
import com.sosnowka.exeption.ExceptionMessage;
import com.sosnowka.exeption.NotFoundException;
import com.sosnowka.model.Booking;
import com.sosnowka.model.Player;
import com.sosnowka.repository.PlayerRepository;
import com.sosnowka.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

/**
 * Created by Pawel on 17.11.2017.
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void delete(Player player) {
        playerRepository.delete(player);
    }

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
        for (Booking b : playerRepository.findOneByUsername(username).getBookingList()) {
            try {
                if (dateClass.isAfterNowday(b.getDate())) {
                    list.add(b);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Player findOneByUsername(String username) throws NotFoundException {
        Optional<Player> optionalPlayer = Optional.ofNullable(playerRepository.findOneByUsername(username));
        if (!optionalPlayer.isPresent())
            throw new NotFoundException(ExceptionMessage.userNotFound);

        return optionalPlayer.get();
    }

    @Override
    public Player findById(Long id) throws NotFoundException {
        Optional<Player> optionalPlayer = Optional.ofNullable(playerRepository.findById(id));
        if (!optionalPlayer.isPresent())
            throw new NotFoundException(ExceptionMessage.userNotFound);
        return optionalPlayer.get();
    }

    public Player edit(String name, Player player) throws NotFoundException {
        Optional<Player> playerOptional = Optional.ofNullable(playerRepository.findOneByUsername(name));
        if (playerOptional.isPresent())
            throw new NotFoundException(ExceptionMessage.userNotFound);
        Player playerFromDb = playerOptional.get();
        if (player.getFirstName() != null) {
            playerFromDb.setUsername(player.getFirstName());
        }
        if (player.getBirthDate() != null) {
            playerFromDb.setBirthDate(player.getBirthDate());
        }
        if (player.getLastName() != null) {
            playerFromDb.setLastName(player.getLastName());
        }
        if (player.getPhoneNumber() != null) {
            playerFromDb.setPhoneNumber(player.getPhoneNumber());
        }
        return playerRepository.save(playerFromDb);
    }

}
