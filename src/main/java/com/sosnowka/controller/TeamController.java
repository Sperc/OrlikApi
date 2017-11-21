package com.sosnowka.controller;

import com.sosnowka.model.Player;
import com.sosnowka.model.Team;
import com.sosnowka.service.AppUserService;
import com.sosnowka.service.PlayerService;
import com.sosnowka.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * Created by Pawel on 20.11.2017.
 */
@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;

    @GetMapping("/my")
    public HttpEntity<List<Team>> myTeams(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return new ResponseEntity(teamService.findUserTeams(name), HttpStatus.OK);
    }
    @GetMapping("/test")
    public List<Player> test(){
        return playerService.findAll();
    }
}
