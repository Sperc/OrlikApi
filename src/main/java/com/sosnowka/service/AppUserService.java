package com.sosnowka.service;

import com.sosnowka.model.AppUser;

/**
 * Created by Pawel on 03.11.2017.
 */
public interface AppUserService {
    AppUser findByUsername(String username);

    AppUser save(AppUser appUser);

    void delete(AppUser appUser);

}
