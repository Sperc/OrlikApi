package com.sosnowka.service;

import com.sosnowka.model.Playground;

import java.util.List;

/**
 * Created by Pawel on 14.10.2017.
 */
public interface PlaygroundService {
    public Playground save(Playground playground);
    public List<Playground> findAll();
    public Playground findOneById(long id);
    public List<Playground> findByName(String name);
    public List<Playground> findAllByCityName(String city);
}
