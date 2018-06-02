package com.sosnowka.repository;

import com.sosnowka.model.Booking;
import com.sosnowka.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by Pawel on 17.11.2017.
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
    public Player save(Player player);

    public List<Player> findAll();

    public Player findOneByUsername(String username);

    Player findById(Long id);
}
