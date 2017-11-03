package com.sosnowka.service;

import com.sosnowka.model.AppUser;

/**
 * Created by Pawel on 03.11.2017.
 */
public interface AppUserService {
    public AppUser findByUsername(String username);

    public AppUser save(AppUser appUser);
}
