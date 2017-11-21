package com.sosnowka.repository;

import com.sosnowka.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Pawel on 17.11.2017.
 */
public interface PlayerRepository extends JpaRepository<Player,Long>{
    public Player save(Player player);
    public List<Player> findAll();
    public Player findOneByUsername(String username);
}
