package com.sosnowka.service.implementation;

import com.sosnowka.model.Playground;
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
    public List<Playground> findPlaygroundByCityName(String cityName) {
        return playgroundRepository.findAllByCity(cityName);
    }
}
