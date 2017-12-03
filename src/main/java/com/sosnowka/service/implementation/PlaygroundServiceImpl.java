package com.sosnowka.service.implementation;

import com.sosnowka.model.City;
import com.sosnowka.model.Playground;
import com.sosnowka.repository.CityRepository;
import com.sosnowka.repository.PlaygroundRepository;
import com.sosnowka.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 14.10.2017.
 */
@Service
public class PlaygroundServiceImpl implements PlaygroundService {
    @Autowired
    PlaygroundRepository playgroundRepository;
    @Autowired
    CityRepository cityRepository;

    @Override
    public Playground save(Playground playground) {
        return playgroundRepository.save(playground);
    }

    @Override
    public List<Playground> findAll() {
        return playgroundRepository.findAll();
    }

    @Override
    public Playground findOneById(long id) {
        return playgroundRepository.findOne(id);
    }

    @Override
    public List<Playground> findByName(String name) {
        return playgroundRepository.findAllByName(name);
    }

    @Override
    public List<Playground> findAllByCityName(String city) {
        City c = cityRepository.getByName(city);
        return c.getPlaygroundList();
    }

}
