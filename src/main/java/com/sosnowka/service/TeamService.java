package com.sosnowka.service;

import com.sosnowka.model.Team;

import java.util.List;
import java.util.Set;

/**
 * Created by Pawel on 20.11.2017.
 */
public interface TeamService {
    public List<Team> findAll();
    public Set<Team> findUserTeams(String useranme);

}
