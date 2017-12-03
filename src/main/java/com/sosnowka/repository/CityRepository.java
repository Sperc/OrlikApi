package com.sosnowka.repository;

import com.sosnowka.model.City;
import com.sosnowka.model.Playground;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Pawel on 01.12.2017.
 */
public interface CityRepository extends JpaRepository<City,Long>{
    City getByName(String name);
    List<City> findAll();
}
