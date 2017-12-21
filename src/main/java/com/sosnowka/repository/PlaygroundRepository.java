package com.sosnowka.repository;

import com.sosnowka.model.Playground;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Pawel on 14.10.2017.
 */
public interface PlaygroundRepository extends JpaRepository<Playground,Long>{
    @Override
    public List<Playground> findAll();

    @Override
    public Playground save(Playground playground);

    @Override
    public Playground getOne(Long aLong);

    public List<Playground> findAllByCity_NameAndCategory(String cityName,String category);
}
