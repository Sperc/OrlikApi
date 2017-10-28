package com.sosnowka.controller;

import com.sosnowka.model.AppUser;
import com.sosnowka.model.Playground;
import com.sosnowka.model.Team;
import com.sosnowka.repository.AppUserRepository;
import com.sosnowka.repository.TeamRepository;
import com.sosnowka.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pawel on 14.10.2017.
 */
@RestController
@RequestMapping("/test")
public class PlaygroundController {

    @Autowired
    PlaygroundService playgroundService;

    @GetMapping("/get-by-city/{city}")
    public ResponseEntity<List<Playground>> findPlaygroundByCity(
            @PathVariable("city") String city
    ) {
        return new ResponseEntity<List<Playground>>(playgroundService.findPlaygroundByCityName(city), HttpStatus.OK);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Playground>> getAllPlayground(){
        return new ResponseEntity<List<Playground>>(playgroundService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/test")
    public String metoda(){
        return "test";
    }
}
