package com.sosnowka.controller;

import com.sosnowka.model.Playground;
import com.sosnowka.repository.PlaygroundRepository;
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

}
