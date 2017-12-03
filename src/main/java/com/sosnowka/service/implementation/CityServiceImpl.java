package com.sosnowka.service.implementation;

import com.sosnowka.model.City;
import com.sosnowka.repository.CityRepository;
import com.sosnowka.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pawel on 01.12.2017.
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<City> getAllCity() {
        return cityRepository.findAll();
    }
}
