package com.sosnowka.repository;

import com.sosnowka.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by Pawel on 27.10.2017.
 */
public interface TeamRepository extends JpaRepository<Team,Long> {
    public List<Team> findAll();
}
