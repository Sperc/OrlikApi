package com.sosnowka.controller;

import com.sosnowka.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pawel on 01.12.2017.
 */
@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/all")
    public HttpEntity findAllCity(){
        return new ResponseEntity(cityService.getAllCity(), HttpStatus.OK);
    }
}
