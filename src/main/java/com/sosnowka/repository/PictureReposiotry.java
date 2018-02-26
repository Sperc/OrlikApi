package com.sosnowka.repository;

import com.sosnowka.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Pawel on 25.02.2018.
 */

public interface PictureReposiotry extends JpaRepository<Picture, Long> {
    Picture findById(Long id);
    Picture findByName(String name);

    @Override
    <S extends Picture> S save(S s);
}
