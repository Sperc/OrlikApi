package com.sosnowka.service.implementation;

import com.sosnowka.model.Player;
import com.sosnowka.model.Team;
import com.sosnowka.repository.PlayerRepository;
import com.sosnowka.repository.TeamRepository;
import com.sosnowka.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Pawel on 20.11.2017.
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Set<Team> findUserTeams(String useranme) {
        Player player = playerRepository.findOneByUsername(useranme);
        return player.getUserTeams();
    }
}
