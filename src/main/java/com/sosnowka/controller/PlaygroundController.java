package com.sosnowka.controller;

import com.sosnowka.model.AppUser;
import com.sosnowka.model.Playground;
import com.sosnowka.model.Team;
import com.sosnowka.repository.AppUserRepository;
import com.sosnowka.repository.TeamRepository;
import com.sosnowka.service.PlaygroundService;
import com.sosnowka.test.MyObject;
import javafx.print.PageLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

    @GetMapping("/get-all")
    public ResponseEntity<List<Playground>> getAllPlayground() {
        return new ResponseEntity<List<Playground>>(playgroundService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/test")
    public MyObject metoda() {
        return new MyObject("ja");
    }

    @GetMapping("/get")
    public List<Playground> getAllPlaygroundsByName() {
        return playgroundService.findAllByCityName("Lublin");
    }

    @GetMapping("/get/{cityName}")
    public HttpEntity<List<Playground>> getPlaygroundByCity(@PathVariable("cityName") String cityName) {
        return new ResponseEntity<List<Playground>>(playgroundService.findAllByCityName(cityName), HttpStatus.OK);
    }

    @GetMapping("/get/{cityName}/{category}")
    public HttpEntity getPlaygroundByCity_NameAndCategory(@PathVariable("cityName") String cityName,
                                                          @PathVariable("category") String category) {
        return new ResponseEntity(playgroundService.findAllByCityNameAndCategory(cityName, category), HttpStatus.OK);
    }

}
