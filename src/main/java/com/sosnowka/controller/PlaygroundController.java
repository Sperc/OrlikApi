package com.sosnowka.controller;

import com.sosnowka.model.Playground;
import com.sosnowka.service.PlaygroundService;
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
@RequestMapping("/playgrounds")
public class PlaygroundController {

    @Autowired
    PlaygroundService playgroundService;

    @GetMapping()
    public ResponseEntity<List<Playground>> getAllPlayground() {
        return new ResponseEntity<List<Playground>>(playgroundService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity getPlaygroundById(@PathVariable("id") Long id) {
        return new ResponseEntity(playgroundService.findOneById(id), HttpStatus.OK);
    }

    @GetMapping("/cityName/{cityName}")
    public HttpEntity<List<Playground>> getPlaygroundByCity(@PathVariable("cityName") String cityName) {
        return new ResponseEntity<List<Playground>>(playgroundService.findAllByCityName(cityName), HttpStatus.OK);
    }

    @GetMapping("/{cityName}/{category}")
    public HttpEntity getPlaygroundByCity_NameAndCategory(@PathVariable("cityName") String cityName,
                                                          @PathVariable("category") String category) {
        return new ResponseEntity(playgroundService.findAllByCityNameAndCategory(cityName, category), HttpStatus.OK);
    }


}
