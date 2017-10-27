package com.sosnowka.repository;

import com.sosnowka.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Pawel on 01.10.2017.
 */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    public AppUser findOneByUsername(String username);
}
